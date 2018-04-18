package com.zrxjuly.validate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Vcode extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String vcode = req.getParameter("vcode");
		System.out.println(vcode);
		String code = (String) req.getSession().getAttribute("vcode");
		if (vcode.equalsIgnoreCase(code)) {
			out.write("success");
			out.flush();
			out.close();
		} else {
			out.write("err");
			out.flush();
			out.close();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
