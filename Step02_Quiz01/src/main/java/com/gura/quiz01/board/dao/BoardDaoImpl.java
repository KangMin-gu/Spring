package com.gura.quiz01.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gura.quiz01.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	public SqlSession session;

	@Override
	public void insert( BoardDto dto) {
		session.insert("board.insert", dto);
	}

	@Override
	public void update(BoardDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		session.delete("board.delete", num);
		
	}

	@Override
	public List<BoardDto> getList() {
		List<BoardDto> list = session.selectList("board.getList");
		return list;
	}

	@Override
	public BoardDto getData(int num) {
		// TODO Auto-generated method stub
		return null;
	}

}
