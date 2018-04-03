<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${info }</h1>
	欢迎
	<shiro:hasRole name="admin">
		有admin角色的用户
	</shiro:hasRole>
	<shiro:hasPermission name="student:create">
		有student：create权限的用户
	</shiro:hasPermission>
</body>
</html>