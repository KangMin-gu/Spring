package com.gura.step04.shop.contorller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.exception.MyException;
/*
 * 	밖에 따로 예외를 처리하는 컨트롤러 exception 예외가 되면 여기로온다. 
 * 	@ControllerAdvice 붙여줘야하고 bean에 등록해야한다.
 */	
@ControllerAdvice
public class ExceptionController {
	//MyException type 의 예외가 발생했을때 호출되는 메소드
	@ExceptionHandler(MyException.class)
	public ModelAndView hadleMyException(MyException me){
		ModelAndView mView = new ModelAndView();
		mView.addObject("exception", me);
		mView.setViewName("error/my");
		return mView;
	}
}
