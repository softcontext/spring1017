package com.example.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.board.dto.Pager;
import com.example.board.model.Board;
import com.example.board.service.BoardService;
import com.example.user.model.User;

@Controller
@RequestMapping("/boards")
@SessionAttributes("pagerRequest")
public class BoardController {
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	// boards가 메뉴에서 활성환된 것을 표시하기 위한 안내 값을 뷰에 전달한다.
	@ModelAttribute("active")
	public String active(){
		return "board";
	}
	
	// 조회, 수정, 삭제, 또는 취소 시 원래 보던 페이지를 보여주기 위한 값을 세션에 백업한다.
	@ModelAttribute("pagerRequest")
	public Pager.Request pagerRequest(){
		return new Pager.Request(1, 10, 5); // page, size, bsize
	}
	
	@GetMapping()
	public ModelAndView getBoardsView(
			@ModelAttribute("pagerRequest") Pager.Request request
//			@RequestParam(name="page", required=false, defaultValue="1") int page,
//			@RequestParam(name="size", required=false, defaultValue="10") int size,
//			@RequestParam(name="bsize", required=false, defaultValue="5") int bsize
			) {
		
		ModelAndView mav = new ModelAndView("board_list");
		
//		Page<Board> mPage = boardService.selectByLimit(page, size);
//		mav.addObject("boards", mPage.getContent());
//		mav.addObject("pager", new Pager(page, size, bsize, mPage.getTotalElements()));
		
		Page<Board> mPage = boardService.selectByLimit(request.getPage(), request.getSize());
		mav.addObject("boards", mPage.getContent());
		mav.addObject("pager", new Pager(request.getPage(), request.getSize(), request.getBsize(), mPage.getTotalElements()));
		
		return mav;
	}
	
	@GetMapping("/view/{id}")
	public String getBoardView(@PathVariable long id, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return session.getServletContext().getContextPath() + "/login";
		}
		
		Board board = boardService.selectById(id);
		
		if (!board.getWriter().equals(user.getEmail())) {
			boardService.increment(id);
		}
		
		model.addAttribute("board", board);
		
		return "board_view";
	}
	
	@GetMapping("/write")
	public String getInsertView(HttpSession session, Model model, HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			logger.trace("[[ trace # BoardController # GET/{} : redirect:/login ]]", request.getRequestURI());
			logger.info("[[ info # BoardController # GET/{} : redirect:/login ]]", request.getRequestURI());
			logger.debug("[[ debug # BoardController # GET/{} : redirect:/login ]]", request.getRequestURI());
			logger.warn("[[ warn # BoardController # GET/{} : redirect:/login ]]", request.getRequestURI());
			logger.error("[[ error # BoardController # GET/{} : redirect:/login ]]", request.getRequestURI());
			
			return "redirect:/login";
		}
		model.addAttribute("user", user);
		return "board_write";
	}
	
	@PostMapping("/write")
	public String postInsert(Board board, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		if (user != null && board != null) {
			if (user.getEmail().equals(board.getWriter())) {
				boardService.insert(board);
			}
		}
		return "redirect:/boards?page=1";
	}
	
	@GetMapping("/update/{id}")
	public String getUpdateView(@PathVariable long id, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		Board board = boardService.selectById(id);
		
		if (user != null && board != null) {
			if (user.getEmail().equals(board.getWriter())) {
				model.addAttribute("board", board);
				return "board_update";
			}
		}
		return "redirect:/boards";
	}
	
	@PostMapping("/update")
	public String postUpdate(Board board, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		if (user != null && board != null) {
			if (user.getEmail().equals(board.getWriter())) {
				boardService.update(board);
				return "redirect:/boards/view/" + board.getId();
			}
		}
		return "redirect:/boards";
	}
	
	@GetMapping("/delete/{id}")
	public String getDelete(@PathVariable long id, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		if (user != null) {
			Board board = boardService.selectById(id);
			
			if (user.getEmail().equals(board.getWriter())) {
				boardService.delete(id);
			}
		}
		return "redirect:/boards";
	}
	
}
