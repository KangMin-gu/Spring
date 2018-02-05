package com.gura.step04.exception;

import org.springframework.dao.DataAccessException;

/*
 * Dao 객체에서 특정 상황에서 발생시킬 Exception 클래스 정의하기 
 */
public class NoDeliveryException extends DataAccessException{//노딜리버리익세셥타입이면서 데이타엑세스익셉션타입이다.

	public NoDeliveryException(String msg) {
		super(msg); //부모 생성자에 문자열(예외 메세지) 넘겨주기(디폴트생성자가없기때문에 값을 넣어줘야함.)
		
	}
	
	
}
