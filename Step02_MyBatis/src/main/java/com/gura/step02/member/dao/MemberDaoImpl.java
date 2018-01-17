package com.gura.step02.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.step02.member.dto.MemberDto;

// 1.MemberDaoImpl 객체가 Spring Bean Container 에 등록 되도록 
@Repository //컨테이너에서 관리하도록 하기위해 
public class MemberDaoImpl implements MemberDao{
	
	// Spring Bean Container 에서 주입 받을 수 있도록 
	@Autowired //컨테이너에서 session객체를 찾아 자동 주입한다.
	private SqlSession session; //핵심 의존 객체 
	
	@Override
	public void insert(MemberDto dto) {
		//session 관리는 알아서하기때문에 close 할필요없다. 
		session.insert("member.insert", dto);
		
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
		
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete", num);
		
	}

	@Override
	public List<MemberDto> getList() {
		List<MemberDto> list = session.selectList("member.getList");
		return list;
	}

	@Override
	public MemberDto getData(int num) {
		MemberDto dto = session.selectOne("member.getData", num);
		return dto;
	}

}
