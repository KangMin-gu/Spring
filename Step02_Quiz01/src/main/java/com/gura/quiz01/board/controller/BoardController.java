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
	
	//글 상세보기
	@RequestMapping("/board/detail")
	public ModelAndView detail(@RequestParam int num){
		
		ModelAndView mView = service.getData(num);
		
		mView.setViewName("board/detail");
		return mView; 
	}
	
	//글 업데이트하기
	@RequestMapping("/board/update")
	public ModelAndView update(@ModelAttribute BoardDto dto){
		
		ModelAndView mView = service.update(dto);
		
		mView.setViewName("redirect:/board/detail.do?num="+dto.getNum());
		return mView;
	}
	
	//게시판 수정
	@RequestMapping("/board/updateform")
	public ModelAndView updateform(@RequestParam int num){
		
		ModelAndView mView = service.getData(num);
		
		mView.setViewName("board/updateform");
		return mView;
	}
	
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
	@RequestMapping("/board/insert")
	public ModelAndView insert(@ModelAttribute BoardDto dto){
		
		ModelAndView mView = service.insert(dto);
		
		mView.setViewName("board/alert");
		return mView;
	}
	
}
