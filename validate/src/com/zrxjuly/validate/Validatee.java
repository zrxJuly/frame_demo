package com.zrxjuly.validate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

public class Validatee extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ValidateCode v = new ValidateCode(width, height, codeCount, lineCount)
		//参数：width:验证码图片的宽；height：验证码图片的高；codeCount：验证码内容的个数；lineCount：干扰线的个数
		ValidateCode validateCode = new ValidateCode(95, 40, 4, 50);
		
		//验证码输出到前端.
		validateCode.write(response.getOutputStream());
		
		// 将随机验证码存放到session中，以便用户校验.
		request.getSession().setAttribute("vcode", validateCode.getCode());
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
