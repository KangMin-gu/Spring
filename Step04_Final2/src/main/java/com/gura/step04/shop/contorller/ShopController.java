package com.gura.step04.shop.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.shop.service.ShopService;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	//@RequestMapping("/shop/list")
	@RequestMapping(value="/shop/list", method=RequestMethod.GET)
	public ModelAndView list(){
		
		ModelAndView mView = shopService.getList();
		
		mView.setViewName("shop/list");
		
		return mView;
	}
}
