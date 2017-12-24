package com.zrxjuly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	// 定义请求url到处理器功能方法的映射。此处的.action可以写也可以不写，但是请求映射过来的是以.action结尾的.
	@RequestMapping(value = "/index.action")
	public ModelAndView index() {
		
		// 创建ModelAndView用来存放数据和视图.
		ModelAndView mav = new ModelAndView();
		
		// 设置数据到模型中.
		mav.addObject("test", "hello spring mvc");
		
		// 设置视图jsp，需要设置视图的物理地址.
		mav.setViewName("index");
		return mav;
	}
}
