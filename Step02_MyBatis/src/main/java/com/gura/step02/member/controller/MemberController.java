package com.gura.step02.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step02.member.service.MemberService;
// 컨트롤러로써 동작할 수 있도록  여기에 설정한다.
// spring > app servlet > servlet-context.xml에 명시한다. (dispatcherservlet이다.)

@Controller 
public class MemberController {
	
	@Autowired //memberService를 service란 변수명으로 주입시키겟다.
	private MemberService service;
	
	@RequestMapping("/member/list")
	public ModelAndView list(){
		
		//MemberService 객체를 이용해서 ModelAndView 객체를 리턴 받는다.
		ModelAndView mView = service.getList();
		//모델 view 페이지의 정보를 함께 담고 있는 ModelAndView
		//객체를 리턴해 준다.
		return mView;
		
	}
}
