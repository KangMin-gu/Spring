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
		//mView.setViewName("member/alert");
		
		
		//리턴해준다.
		return mView;
	}

	@Override
	public ModelAndView update(MemberDto dto) {
		dao.update(dto);
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("msg", "회원 정보를 수정했습니다.");
		
		return mView;
	}

	@Override
	public void delete(int num) {
		//Dao 를 이용해서 삭제한다.
		dao.delete(num);
		//return을 안하는이유는 삭제하고 리턴할게 없음으로 void를 타입으로줌으로써 return을 없앤다.
		//만약 수정사항이 있다면 인터페이스도 수정해야한다.-> 인터페이스에서 임플해서 사용함으로!
	}

	@Override
	public ModelAndView getData(int num) {
		
		//수정할 회원의 정보를 얻어와서
		MemberDto dto = dao.getData(num);
		//ModelAndView 객체에 담고
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", dto);
		//리턴해 준다.
		return mView;
	}

	@Override
	public ModelAndView getList() {
		//Dao 를 이용해서 회원목록을 얻어온다. 
		List<MemberDto> list = dao.getList();
		
		ModelAndView mView = new ModelAndView();
		//Model 을 list 라는 키값으로 담는다. 
		mView.addObject("list", list); //list를 list키값으로 addobject에 담아서
		//mView.setViewName("member/list"); //member/list view페이지로 기본디폴트인 forward이동해서 보낸다.
		//위에 뷰페이지르 ㄹ지운이유는 컨트롤러에서 경로를 보기위해 그래야지 좋기때문에 모델만담아리턴한다.
		//Model 이 담긴 ModelAndView 객체를 리턴한다.
		return mView;
	}
	
}
