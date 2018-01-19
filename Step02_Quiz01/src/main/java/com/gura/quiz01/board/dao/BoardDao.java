package com.gura.quiz01.board.dao;

import java.util.List;

import com.gura.quiz01.board.dto.BoardDto;

public interface BoardDao {
	public void insert(BoardDto dto);
	public void update(BoardDto dto);
	public void delete(int num);
	public List<BoardDto> getList();
	public BoardDto getData(int num);
}
