package com.gura.step04.file.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.file.dto.FileDto;
import com.gura.step04.file.service.FileService;

@Controller// contorller 든 service 든 여러개의 service에 의존하고 여러개의 dao에 의존할수 있다. 
public class FileController {
	//의존 객체
	@Autowired
	private FileService fileService;
	
	@RequestMapping("/file/list")
	public ModelAndView list(){
		ModelAndView mView = fileService.list();
		mView.setViewName("file/list");
		return mView;
	}
	
	/*
	 *  Aop 가 적용이 되면 HttpServletRequest 객체가 필요함으로 메소드의 인자로 전달 받도록 한다. 
	 */
	@RequestMapping("/file/insertform")
	public ModelAndView authInsertForm(HttpServletRequest request){
		
		//생성자의 인자로 view 페이지의 정보를 전달해서 객체 생성 
		ModelAndView mView = new ModelAndView("file/insertform");		//view 내임을 생성자의 인자로 전달할수도 있다. 

		return mView;
	}
	
	//파일 업로드 요청 처리 
	@RequestMapping("/file/insert")
	public ModelAndView authInsert(HttpServletRequest request, @ModelAttribute FileDto dto){
		
		/*
		 *  인자로 전달된 FileDto 에는 String writer 작성자하고 Multipartfile  file 객체의 참조값이 들어있다.
		 *  나머지 정보는 서비스에서 처리 해야 한다. 
		 */
		
		fileService.insert(request, dto);
		
		return new ModelAndView("redirect:/file/list.do");
	}
	
	@RequestMapping("/file/download")
	public ModelAndView download(@RequestParam int num){
		
		//다운로드할 파일의 정보를 ModelAndView 객체에 담아서 받는다.
		ModelAndView mView = fileService.getData(num);
		
		//컨트롤러에서 바로 다운로드 할수있게 클라이어트에게 Class로 보여주기 
		//view의 이름을 지정 (Abstract View 페이지의 이름)jsp페이지가 아닌 추상view를 만들어서 객체에서 직접 다운받게한다.
		 mView.setViewName("fileDownView");
		 
		//페이지에서 다운로드 할수 있다.
		//	mView.setViewName("file/download");
		
		return mView;
	}
	
	@RequestMapping("/file/delete")
	public ModelAndView authDelete(HttpServletRequest request, @RequestParam int num){
		
		fileService.delete(request, num);
		
		return new ModelAndView("redirect:/file/list.do");
		
	}
}


























