package com.example.board.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.board.model.Board;

public interface BoardService {
	public int insert(Board board);
	public int update(Board board);
	public int delete(long id);
	
	public long count();
	public List<Board> selectAll();
	
	public Board selectById(long id);
	public int increment(long id);
	
//	public List<Board> selectByLimit(int page, int size);
	public Page<Board> selectByLimit(int page, int size);
}
