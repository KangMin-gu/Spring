package com.gura.step02.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step02.member.dao.MemberDao;
import com.gura.step02.member.dto.MemberDto;

//1. 
//이객체도 bean container 되게 @service 한다.
@Service
public class MemberServiceImpl implements MemberService{
	
	//2. 의존 객체인 dao 를 주입 받기 위해 
	@Autowired
	private MemberDao dao;
	
	@Override
	public ModelAndView insert(MemberDto dto) {
		//회원 정보 저장
		dao.insert(dto);
		
		
		//ModelAndView 객체를 생성해서
		ModelAndView mView = new ModelAndView();
		//msg 라는 키값으로 String type 을 담는다.
		mView.addObject("msg", "저장했습니다."); //request.setAttribute 담는걸 이렇게 한다.
		//View 페이지의 정보를 담고
		mView.setViewName("member/alert");
		
		
		//리턴해준다.
		return mView;
	}

	@Override
	public ModelAndView update(MemberDto dto) {
		
		return null;
	}

	@Override
	public ModelAndView delete(int num) {
		
		return null;
	}

	@Override
	public ModelAndView getData(int num) {
		
		return null;
	}

	@Override
	public ModelAndView getList() {
		//Dao 를 이용해서 회원목록을 얻어온다. 
		List<MemberDto> list = dao.getList();
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("list", list); //list를 list키값으로 addobject에 담아서
		mView.setViewName("member/list"); //member/list view페이지로 기본디폴트인 forward이동해서 보낸다.
		
		return mView;
	}

}
