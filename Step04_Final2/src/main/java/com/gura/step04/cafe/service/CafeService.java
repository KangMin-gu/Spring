package com.gura.step04.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.cafe.dto.CafeDto;

public interface CafeService { //리턴타입과 메소드명 인자로전달되는것들을 어떤걸 전달할것인가 고려햐여 작성 
	public void insert(CafeDto dto);
	public void update(CafeDto dto);
	public void delete(CafeDto dto);
	public ModelAndView list(HttpServletRequest request);
	public ModelAndView detail(HttpServletRequest request);
	public void increaseViewCount(int num);
	
}
