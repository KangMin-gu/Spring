package com.gura.step04.users.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.users.dto.UsersDto;
import com.gura.step04.users.service.UsersService;

@Controller
public class UsersController {
	
	//의존 객체
	@Autowired
	private UsersService service;
	
	//회원가입 폼 요청 처리 
	@RequestMapping("/users/signup_form")
	public String signupForm(){
		
		return "users/signup_form";
		// /WEB-INF/views/users/signup_form.jsp
	}
	
	//아이디 중복 확인 요청 처리 
	@RequestMapping("/users/checkid")
	//jackson 라이브러리로 응답 
	@ResponseBody   
	public Map<String, Object> checkid(@RequestParam String inputId){
		//서비스를 이용해서 사용가능 여부를 boolean type으로 리턴받기
		boolean canUse = service.canUseId(inputId);
		//Map 에 담는다. 
		Map<String, Object> map = new HashMap<>();
		map.put("canUse", canUse);
		//Map 리턴하기 
		return map; //{"canUse":true} or {"canUse":false} 로 응답하게됨.
	}
	
	// 회원 가입 요청 처리
	@RequestMapping("/users/signup")
	public ModelAndView signup(@ModelAttribute UsersDto dto){
		//전달되는 인자에 회원 가입 정보가 들어 있다. 
		ModelAndView mView=service.signup(dto);
		mView.setViewName("users/signup_result");
		return mView;
	}
	
	//로그인 폼 요청 처리
	@RequestMapping("/users/loginform")
	public ModelAndView loginForm(ModelAndView mView, 
		HttpServletRequest request ){
		//인자에 명시를 하면 안에서 new 할 필요없이 스프링이 필요하면 ModelAndView mView 생성해서 참조값을 얻어와서 넣어준다.
		
		// url 이라는 파라미터로 전달된 문자열 읽어오기 
		String url = request.getParameter("url");
		if(url==null){ //전달 되지 않았으면 root 요청을 하도록 (정보가없으면 context명만->/step04/ 가져온다)
			url=request.getContextPath()+"/";
		}
		
		//로그인 후 이동할 url 정보를 ModelAndView 객체에 담고 
		mView.addObject("url", url);
		//view 페이지 정보를 담고 
		mView.setViewName("users/loginform");
		//ModelAndView 객체를 리턴해 준다.
		
		return mView;
	}
	
	//로그인 요청처리
	@RequestMapping("/users/login")
	public ModelAndView login(@ModelAttribute UsersDto dto,
			HttpServletRequest request){
		
		ModelAndView mView = service.login(dto, request); //로그인 폼에서 넘어온 인자값을 전달 받음.
		mView.setViewName("users/login_result");
		
		return mView;
	}
	
	//로그아웃 요청처리
	@RequestMapping("/users/logout")
	public ModelAndView logout(HttpSession session, ModelAndView mView){
		
		String id =(String)session.getAttribute("id");
  		//세션 초기화 (로그아웃처리)
		session.invalidate();
		
		mView.addObject("msg", id+"님 로그아웃 되었습니다.");
		mView.setViewName("users/logout_result");
		return mView;
	}
	
	//유저의 디테일정보
	@RequestMapping("/users/info")
	public ModelAndView authInfo(HttpServletRequest request){
		//세션 객체를 request에서 얻어오도록
		HttpSession session = request.getSession();
		//세션에 등록된 로그인된 아이디를 읽어온다. 
		String id = (String)session.getAttribute("id");
		//사용자 정보가 담긴 ModelAndView 객체를 리턴받고 
		ModelAndView mView = service.detail(id);
		//view 페이지 정보를 설정하고 
		mView.setViewName("users/info");
		return mView; //리턴한다.
	}
	
	//유저정보 삭제
	@RequestMapping("/users/delete")
	public ModelAndView authDelete(HttpServletRequest request){
		//세션 객체를 request에서 얻어오도록
		HttpSession session = request.getSession();
		//서비스를 이용해서 탈퇴 처리를 한다. 
		ModelAndView mView = service.delete(session);
		//ModelAndView mView = new ModelAndView();
		mView.setViewName("/users/delete_result");
		return mView;
	}
	
	//유저정보 업데이트폼
	@RequestMapping("/users/updateform")
	public ModelAndView authUpdateform(HttpServletRequest request){
		//세션 객체를 request에서 얻어오도록
		HttpSession session = request.getSession();
		//세션에 저장된 아이드를 불러와서
		String id = (String)session.getAttribute("id");
		//서비스객체를 이용해서 사용자 정보가 담긴 ModelAndView 
		//객체 얻어오기
		ModelAndView mView = service.detail(id);
		mView.setViewName("users/updateform");
		return mView;
	}
	
	//유저 업데이트하기
	@RequestMapping("/users/update")
	public ModelAndView authUpdate(@ModelAttribute UsersDto dto, 
			HttpServletRequest request){//aop 적용을 위한 session인자 추가
		//서비스를 객체를 이용해서 수정반영
		service.update(dto);
		ModelAndView mView = new ModelAndView();
//		mView.setViewName("users/update_result");
		//개인정보보기로 리다일렉트 이동
		mView.setViewName("redirect:/users/info.do");
		return mView;
	}

}



































