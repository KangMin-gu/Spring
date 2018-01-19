package com.gura.quiz01.board.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.quiz01.board.dto.BoardDto;

public interface BoardService {
	public ModelAndView insert(BoardDto dto);
	public ModelAndView update(BoardDto dto);
	public void delete(int num);
	public ModelAndView getList();
	public ModelAndView getData(int num);
	public ModelAndView detail(int num);
}
