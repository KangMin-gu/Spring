package com.gura.step02.member.dao;

import java.util.List;

import com.gura.step02.member.dto.MemberDto;
/*
 * 	MemberDaoImpl 클래스가 구현할 인터페이스 정의하기 
 *  즉 DAO를 인터페이스로 적극적을 활용하기위해 만들어버림
 */
public interface MemberDao {
	public void insert(MemberDto dto);
	public void update(MemberDto dto);
	public void delete(int num);
	public List<MemberDto> getList();
	public MemberDto getData(int num);
}
