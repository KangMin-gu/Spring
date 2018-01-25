package com.gura.step04.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.step04.cafe.dto.CafeDto;

@Repository
public class CafeDaoImpl implements CafeDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public void insert(CafeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CafeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CafeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CafeDto getData(CafeDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//글의 목록(검색어에 일치하는) 리턴하기
	@Override
	public List<CafeDto> getList(CafeDto dto) {
		
		return session.selectList("cafe.getList", dto);
	}
	
	//글의 갯수 (검색어에 맞는 일치하는) 리턴하기
	@Override
	public int getCount(CafeDto dto) {
		/*
		 * parameterType => CafeDto
		 * resultType => int
		 */
		int count=session.selectOne("cafe.getCount", dto);
		return count;
	}

	@Override
	public void increaseViewCount(int num) {
		// TODO Auto-generated method stub
		
	}

}
