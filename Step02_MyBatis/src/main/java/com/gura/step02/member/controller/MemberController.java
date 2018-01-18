package com.gura.step02.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step02.member.service.MemberService;
// 컨트롤러로써 동작할 수 있도록  여기에 설정한다.
// spring > app servlet > servlet-context.xml에 명시한다. (dispatcherservlet이다.)
//컨트롤러를 bean 으로 만들기
@Controller 
public class MemberController {
	//의존객체 주입 받기 
	@Autowired //memberService를 service란 변수명으로 주입시키겟다.
	private MemberService service;
	
	//회원 추가 폼 요청 처리
	@RequestMapping("/member/insertform")
	public String insertForm(){
		
		return "member/insertform";
	}
	
	//회원 목록 요청 처리
	@RequestMapping("/member/list")	//http://localhost:8888/step02/member/list.do
	public ModelAndView list(){
		
		//MemberService 객체를 이용해서 ModelAndView 객체를 리턴 받는다.
		ModelAndView mView = service.getList();
		
		// 서비스 객체가 리턴해준 ModelAndView 객체에 view 페이지 정보를 담기
		mView.setViewName("memeber/list"); //forward이동
		//WEB_INF/views/(여기까지 자동으로 붙음 그럼으로 위에 맨앞 / 는 뺀다. )member/list.jsp
		//모델 view 페이지의 정보를 함께 담고 있는 ModelAndView
		//객체를 리턴해 준다.
		return mView;
		//뷰페이지는 컨트롤러에서 설정하고 서비스는 모델만 담는 구조가 제일 인상적이다.
	}
}
