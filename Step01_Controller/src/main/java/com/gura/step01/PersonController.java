package com.gura.step01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
	
	@RequestMapping("/person")
	public String Person(HttpServletRequest request){
		
		String personToday= "오늘의 인물은 김구라!";
		request.setAttribute("personToday", personToday);
		
		return "person";
	}
}
