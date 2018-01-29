package com.gura.step04.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.shop.dao.OrderDao;
import com.gura.step04.shop.dao.ShopDao;
import com.gura.step04.shop.dto.ShopDto;

@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopDao shopDao;
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public ModelAndView getList() {
		List<ShopDto> list = shopDao.getList();
		ModelAndView mView = new ModelAndView();
		mView.addObject("list", list);
		return mView;
	}

	@Override
	public ModelAndView buy(ShopDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
