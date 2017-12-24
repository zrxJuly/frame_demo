package com.zrxjuly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	// ��������url�����������ܷ�����ӳ�䡣�˴���.action����дҲ���Բ�д����������ӳ�����������.action��β��.
	@RequestMapping(value = "/index.action")
	public ModelAndView index() {
		
		// ����ModelAndView����������ݺ���ͼ.
		ModelAndView mav = new ModelAndView();
		
		// �������ݵ�ģ����.
		mav.addObject("test", "hello spring mvc");
		
		// ������ͼjsp����Ҫ������ͼ�������ַ.
		mav.setViewName("index");
		return mav;
	}
}
