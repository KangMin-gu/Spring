package test.service;

import org.springframework.stereotype.Service;

// 어노테이션을 붙이고 component scan 을 이용해서 bean으로 등록.
@Service
public class MemberServiceImpl implements MemberService{

	@Override
	public void insert() {
		
		System.out.println("회원 정보를 저장합니다.");
		
	}

	@Override
	public void select() {
		System.out.println("회원정보를 select 합니다.");
		
	}
	
	
	
}
