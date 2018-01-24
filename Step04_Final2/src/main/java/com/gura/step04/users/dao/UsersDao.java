package com.gura.step04.users.dao;

import com.gura.step04.users.dto.UsersDto;

public interface UsersDao {
	public void insert(UsersDto dto); //저장
	public boolean isValid(UsersDto dto); //id, pwd check
	public UsersDto getData(String id); //id,pwd 한나의 정보가져오기
	public void update(UsersDto dto); //수정
	public void delete(String id); //삭제
	public boolean canUseId(String id); //id 중복여부확인
}
