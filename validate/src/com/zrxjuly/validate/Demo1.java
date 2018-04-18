package com.zrxjuly.validate;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class Demo1 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决post方式提交乱码.
		request.setCharacterEncoding("utf-8");
		
		// request.getParameterMap()方法获取表单值.
		test1(request); 
		// request.getParameterNames()方法获取表单值.
		test2(request);
		// 使用框架
		test3(request);
	}
	
	/*
	 * 使用框架(最简单)，需要导入的jar包：commons-beanutils-XXX.jar(用于封装数据)和commons-logging.jar(用于输出日志)
	 */
	private void test3(HttpServletRequest request) {
		System.out.println("---------------------使用框架---------------");
		try {
			User user = new User();
			System.out.println("封装数据前：" + user);
			
			BeanUtils.populate(user, request.getParameterMap());
			
			System.out.println("封装数据后：" + user);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * request.getParameterNames()方法获取表单值.
	 */
	private void test2(HttpServletRequest request) {
		System.out.println("---------------------request.getParameterNames()方法获取表单值.---------------");
		Enumeration names = request.getParameterNames();
		while (names.hasMoreElements()) {
			// 获取前端name值
			String name = (String)names.nextElement();
			// 将值以数组形式保存
			String[] values = request.getParameterValues(name);
			// 遍历
			for (int i = 0; values != null && i < values.length; i ++) {
				System.out.println(name + "\t" + values[i]);
			}
		}
	}
	
	/*
	 * request.getParameterMap()方法获取表单值.
	 */
	private void test1(HttpServletRequest request) {
		System.out.println("---------------------request.getParameterMap()方法获取表单值.---------------");
		User user = new User();
		System.out.println("封装数据前：" + user);
		// 得到表单提交的所有的值.
		Map<String, String[]> map = request.getParameterMap();
		for (Map.Entry<String, String[]> m : map.entrySet()) {
			// 得到map中的键
			String name = m.getKey();
			// 得到map中的值
			String[] value = m.getValue();
			// 创建一个属性描述器
			try {
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
				// 得到setter属性
				Method setter = pd.getWriteMethod();
				if (value.length == 1) { //给单个变量赋值
					setter.invoke(user, value[0]); // 给一个值的变量赋值
				} else {
					setter.invoke(user, (Object)value); // 给复选框赋值
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 下面的代码是检查用户填写的验证码是否正确(在Validatee.java中将随机验证码存到session中了)
		System.out.println("验证码" + request.getSession().getAttribute("vcode"));
		if (user.getVcode() != null && user.getVcode().equalsIgnoreCase((String) request.getSession().getAttribute("vcode"))) {
			System.out.println("验证码正确！");
		} else {
			System.out.println("验证码错误！");
		}
		
		System.out.println("封装数据后：" + user);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
