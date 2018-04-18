<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="demo1" method="post" id="loginForm">
    	用户名:<input type="text" id="username" name="username"><br>
    	密码：<input type="password" id="password" name="password"><br>
    	爱好：<input type="checkbox" name="hobby" value="篮球">篮球<br>
    	<input type="checkbox" name="hobby" value="编程">编程
    	<input type="checkbox" name="hobby" value="乒乓球">乒乓球<br>
	    验证码：<input type="text" name="vcode"><img src="/validate/validatee" onclick="changeImg()" /><a href="javascript:changeImg()">看不清，换一张</a><br>
	    <br>
    	<input type="checkbox" id="remember" />记住密码
    	<br><br>
    	<input type="submit" value="提交">
    </form>
  </body>
  <script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
  <script type="text/javascript">
    function changeImg() {
        // 获取img节点
        var img = document.getElementsByTagName("img")[0];
        // 加time参数：若不加，点击的时候验证码不会改变，因为浏览器会有缓存
        img.src = "/validate/validatee?time=" + new Date().getTime();
    }
  </script>
  <script type="text/javascript">
  	// 记住密码操作方式一：使用HTML5新特性localStorage，将用户名和密码存储到localStorage中.
	/* $(function(){
		if (window.localStorage) {
  			console.log('浏览器支持localstorage');
  		} else {
  			console.log('浏览器不支持localstorage,无法记住密码');
  		}
		if (localStorage.getItem('username') == '' || localStorage.getItem('username') == null){
			$('#remember').attr('checked', false);
		} else {
			$('#username').val(localStorage['username']);
			$('#password').val(localStorage.password);
			$('#remember').attr('checked', true);
		}
		// 复选框选中,将name和pwd存到localStorage中;取消选中，清空localStorage
		$('#remember').click(function() {
			if ($('#remember').attr('checked') == true) {
				localStorage.setItem('username', $('#username').val());
				localStorage.setItem('password', $('#password').val());
				console.log('记住密码操作成功...');
			} else if ($('#remember').attr('checked') == false) {
				// 取消localStorage存储.
				localStorage.removeItem('username');
				localStorage.removeItem('password');
				console.log('取消记住密码...');
				// localStorage.clear();// 清空整个localStorage中的值
			}
		});
	}) */
  	// 记住密码操作方式二：使用cookie存储
  	$(function(){
  		// 页面初始化时，如果账号密码cookie存在则填充
		if(getCookie('username') != null && getCookie('password') != null) {
			$('#username').val(getCookie('username'));
			$('#password').val(getCookie('password'));
			$('#remember').attr('checked', true);
		} else {
			$('#remember').attr('checked', false);
		}
  		$('#remember').click(function() {
  			// 复选框勾选状态发生改变时，如果未勾选则清除cookie
			if ($('#remember').attr('checked') == true) {
				// 保存账号密码到cookie，有效期7天.
				setCookie('username', $('#username').val(),7);
				setCookie('password', $('#password').val(),7);
				console.log('记住密码操作成功,有效期7天...');
			} else {
				delCookie('username');
				delCookie('password');
				console.log('取消记住密码...');
			}
  		});
  		
  		// 设置Cookie ：名称-值-保存天数
  		function setCookie(name, value, day) {
  			var date = new Date();
  			date.setDate(date.getDate() + day);
  			document.cookie = name + '=' + value + ';expires=' + date;
  		}
  		// 获取cookie
  		function getCookie(name) {
  			var reg = RegExp(name + '=([^;]+)');
  			console.log(reg);
  			var arr = document.cookie.match(reg);
  			console.log(arr);
  			if(arr){
  				return arr[1];
  			} else {
  				return null;
  			}
  		}
  		// 删除cookie
  		function delCookie(name) {
  			setCookie(name,null,-1);
  		}
  	})
  </script>
</html>