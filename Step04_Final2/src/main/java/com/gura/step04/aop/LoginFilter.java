package com.gura.step04.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class LoginFilter {
	
//	@Around("execution(* auth*(..))")
//	public ModelAndView LoginFilter(ProceedingJoinPoint joinPoint) throws Throwable{
//		Object[] args = joinPoint.getArgs();
//		ModelAndView mView = new ModelAndView();
//		for(Object tmp:args){
//			if(tmp instanceof HttpSession){
//				HttpSession session = (HttpSession)tmp;
				
//	if(session.getAttribute("id") == null){
//		System.out.println("로그인하러가자");
//		mView.setViewName("users/loginform");
//		return mView;
//	}else{
//		ModelAndView mView = (ModelAndView)joinPoint.proceed();
//		return mView;
//	}
//	}
}


