package com.example.board.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.board.model.Board;
import com.example.board.repository.BoardRepository;

@Transactional
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
//	INSERT INTO board(writer, title, content, reg_date, hit_count)
//	VALUES(#{writer}, #{title}, #{content}, CURRENT_TIMESTAMP(), 0)
	@Override
	public int insert(Board board) {
		board.setRegDate(new Date());
		board = boardRepository.save(board);
		return 1;
	}

//	UPDATE board SET title=#{title}, content=#{content} WHERE id=#{id}
	@Override
	public int update(Board board) {
		board = boardRepository.save(board);
		return 1;
	}

//	DELETE FROM board WHERE id=#{id}
	@Override
	public int delete(long id) {
		boardRepository.delete(id);
		return 1;
	}

//	"SELECT COUNT(*) FROM board"
	@Override
	public long count() {
		return boardRepository.count();
	}

//	"SELECT * FROM board ORDER BY id DESC"
	@Override
	public List<Board> selectAll() {
		return boardRepository.findAll();
	}

//	SELECT * FROM board WHERE id=#{id}
	@Override
	public Board selectById(long id) {
		return boardRepository.findOne(id);
	}


//	@Override
//	public List<Board> selectByLimit(int page, int size) {
//		/**
//		 * 1-base paging index
//		 */
//		page = page > 0 ? (page - 1) : page;
//		
//		Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
//		Page<Board> result = boardRepository.findAll(pageable);
//		return result.getContent();
//	}

//	SELECT * FROM board ORDER BY id DESC OFFSET #{offset} LIMIT #{size}
	@Override
	public Page<Board> selectByLimit(int page, int size) {
		/**
		 * 1-base paging index
		 */
		page = page > 0 ? (page - 1) : page;
		
		Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
		return boardRepository.findAll(pageable);
	}
	
//	UPDATE board SET hit_count=hit_count+1 WHERE id=#{id}
	@Override
	public int increment(long id) {
		return boardRepository.incrementHitCountById(id);
	}

}
