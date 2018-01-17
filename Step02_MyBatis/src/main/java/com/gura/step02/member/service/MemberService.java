package com.gura.step02.member.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.step02.member.dto.MemberDto;

public interface MemberService {
	//ModelAndView 데이타와 리턴값을 한번에 담아보내겠다.
	//jsp처럼 requset.setAttribute 담고 return해서 안해도한번에담겨짐.
	 public ModelAndView insert(MemberDto dto);
	 public ModelAndView update(MemberDto dto);
	 public ModelAndView delete(int num);
	 public ModelAndView getData(int num);
	 public ModelAndView getList();
}
