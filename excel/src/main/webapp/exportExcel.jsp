<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" id="exportExcel" value="导出到excel" />
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
		$(function () {
			$('#exportExcel').click(function() {
				// 在导出excel之前，需要判断是否有数据(根据给定的值从数据库查询),若有数据，执行导出操作，无数据，提示用户没有数据.
				// 在执行导出方法的时候要再次判断是否有数据，没有返回错误给出提示.
				window.location.href = 'exportexcel.do';
				/* $.ajax({
					type : "post",
					url : "exportexcel.do",
					data : {},
					dataType : 'text',
					success : function(data) {
						console.log(data);
					},
					error : function() {
						alert('失败~');
					}
				}); */
			});
		});
	</script>
</body>
</html>