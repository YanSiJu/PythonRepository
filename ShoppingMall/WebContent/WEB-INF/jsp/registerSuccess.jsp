<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
</head>
<body>
	<script>
		var t = 5;//设定跳转的时间 
		setInterval("refer()", 1000); //启动1秒定时 
		function refer() {
			if (t == 0) {
				location = "${pageContext.request.contextPath }/User/loginSkip"; //#设定跳转的链接地址 
			}
			document.getElementById('show').innerHTML = "" + t + "秒后跳转至登录页面"; // 显示倒计时 
			t--; // 计数器递减 
			//本文转自： 
		}
	</script>
	<span id="show"></span>
	<br>
	<a href="${pageContext.request.contextPath }/User/loginSkip"
		style="text-decoration: none;">登录</a>
</body>
</html>