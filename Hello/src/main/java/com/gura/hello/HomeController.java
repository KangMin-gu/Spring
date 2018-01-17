package com.gura.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 *  컨트롤러 정의하기
 *  
 *  @controller 어노테이션을 클래스 위에 작성하면 된다.
 */
@Controller //jsp Action 추상클래스받던걸 spring에선 클래스명을 맘대로짓고 위에 @controller라고 하나만치면됨
public class HomeController {
	
	//userActionController에서 하던 호출을하고 싶은메소드가 있다면 메소드명을 맘대로짓고 위에  @RequestMapping 으로 쓰면됨.
	// /home 요청을 처리할 메소드 
	@RequestMapping("/home") //.do생략가능
	public String home(HttpServletRequest request) {
		//요청객체가필요하면HttpServletRequest request넣어주면됨
		//요청 객체가 필요하면 메소드의 인자로 선언하면 된다.
		//setAttribute에 담아내면 요청객체(/home)에서 읽어들일수있다 el로 표현해서...
		request.setAttribute("name", "김구라");
		
		
		/*
		 *  return type 이 문자열이면 view 페이지의 정보를 리턴한다.
		 *  
		 *  "WEB-INF/views/"+"home"+".jsp" 
		 *  자동으로 'WEB-INF/views/ (-----) .jsp' 가 앞에 붙어 return된다.
		 *  
		 *  위와 같이 view 페이지의 정보가 구성된다.
		 *  디폴트(기본) 동작은 forward 이동이다.
		 */
		return "home";
	}
	
}
