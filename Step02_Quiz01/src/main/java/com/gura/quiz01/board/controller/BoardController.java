package com.gura.quiz01.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.quiz01.board.dto.BoardDto;
import com.gura.quiz01.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	public BoardService service;
	
	//게시판 삭제
	@RequestMapping("/board/delete")
	public String delete(@RequestParam int num){
		
		service.delete(num);
				
		return "redirect:/board/list.do";
	}
	//게시판 글목록
	@RequestMapping("/board/list")
	public ModelAndView list(){
		
		ModelAndView mView = service.getList();
		
		mView.setViewName("board/list");
		return mView;
	}
	
	//게시판 글작성
	@RequestMapping("/board/insertform")
	public String insertform(){
		return "board/insertform";
	}
	
	//방명록 글 작성후 처리화면
	@RequestMapping("board/insert")
	public ModelAndView insert(@ModelAttribute BoardDto dto){
		ModelAndView mView = service.insert(dto);
		mView.setViewName("board/alert");
		return mView;
	}
	
}
