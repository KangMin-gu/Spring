package com.gura.step04.users.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.users.dao.UsersDao;
import com.gura.step04.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{
	
	//의존 객체
	@Autowired
	private UsersDao dao;
	
	@Override
	public ModelAndView signup(UsersDto dto) {
		//Dao 를 이용해서 DB 에 저장
		dao.insert(dto);
		
		// 아이디를 ModelAndView 객체에 담아서 리턴해준다. 
		ModelAndView mView=new ModelAndView();
		mView.addObject("id", dto.getId());
		
		return mView;
	}

	@Override
	public boolean canUseId(String id) {
		//Dao 가 리턴해주는 값을
		boolean canUse = dao.canUseId(id);
		//리턴해준다.
		return canUse;
	}

	@Override
	public ModelAndView login(UsersDto dto, HttpServletRequest request) {
		//Dao 를 이용해서 유효한 정보인지 확인한다. 
		boolean isValid = dao.isValid(dto);
		//원래 가야할 url
		String url = request.getParameter("url");
		
		ModelAndView mView = new ModelAndView();
		if(isValid){//아이디 비밀번호가 일치한다면
			//로그인 처리를 해준다.  세션에 id를 올린다. 
			request.getSession().setAttribute("id", dto.getId());
			mView.addObject("msg", dto.getId()+"님 로그인 되었습니다.");
			mView.addObject("url", url);
		}else{//아이디 혹은 비밀번호가 틀린 경우
			mView.addObject("msg", "아이디 혹은 비밀번호가 틀려요");
			String location=request.getContextPath()+
					"/users/loginform.do?url="+url;
			mView.addObject("url", location);
		}
		
		return mView;
	}

	@Override
	public void update(UsersDto dto) {
		dao.update(dto);
	}

	@Override
	public ModelAndView delete(HttpSession session) {
		//로그인된 아이디를 읽어와서
		String id = (String)session.getAttribute("id");
		ModelAndView mView = new ModelAndView();
		dao.delete(id); //DB 에서 아이디 삭제
		//ModelAndView 객체에 탈퇴한 회원의 아이디를 담아서 리턴
		mView.addObject("id", id);
		//세션 초기화 세션과 DB삭제는 별게 임으로 세션을 초기화해주어야한다.(탈퇴와 동시에 로그아웃되도록)
		session.invalidate();
		return mView;
	}

	@Override
	public ModelAndView detail(String id) {
		UsersDto dto = dao.getData(id);
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", dto);
		
		return mView;
	}

}
