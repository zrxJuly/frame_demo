package com.zrxjuly.shiro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.zrxjuly.shiro.util.CryptographyUtil;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login doGet");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("login doPost");
		String username = request.getParameter("username");
		String password = CryptographyUtil.md5(request.getParameter("password"), username+"java");
		Subject sub = SecurityUtils.getSubject();
		System.out.println(password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			sub.login(token);
			Session session = sub.getSession();
			System.out.println(session.getId());
			System.out.println(session.getHost());
			System.out.println(session.getTimeout());
			session.setAttribute("info", "session-info");
			response.sendRedirect("success.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "用户名密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
