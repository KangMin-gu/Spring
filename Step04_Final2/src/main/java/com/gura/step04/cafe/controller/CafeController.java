package com.gura.step04.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.cafe.service.CafeService;

@Controller
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	//Cafe 글 목록 요청 처리
	@RequestMapping("/cafe/list")
	public ModelAndView list(HttpServletRequest request){//검색키워드 들이 넘어 올수 있어서 request를 넘겨줌 
		ModelAndView mView = cafeService.list(request);
		mView.setViewName("cafe/list");
		return mView;
	}
	
	@RequestMapping("/cafe/insertform")
	public ModelAndView authInsertForm(HttpServletRequest request){
		
		return new ModelAndView("cafe/insertform");
	}
	
	
	
}
