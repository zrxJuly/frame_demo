package com.zrxjuly.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zrxjuly.shiro.entity.User;
import com.zrxjuly.shiro.util.MD5Utils;

@Controller
@RequestMapping("/user")
public class UserController {
	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) {
		String password = MD5Utils.encrypt(user.getUsername(), user.getPassword());
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), password);
		try {
			subject.login(token);
			Session session = subject.getSession();
			System.out.println("sessionId:" + session.getId());
			System.out.println("sessionHost:" + session.getHost());
			System.out.println("sessionTimeout:" + session.getTimeout());
			session.setAttribute("info", "session的数据");
			return "redirect:/success.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "index";
		}
	}
}
