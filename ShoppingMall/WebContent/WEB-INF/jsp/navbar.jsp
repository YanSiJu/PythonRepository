<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航栏</title>
</head>
<body>
	<table class="table">
			<tr>
				<td class="first">&nbsp;&nbsp;<img src="img/首页图标.png"
					class="indexSrc"><a href="index.jsp"
					style="text-decoration: none;">&nbsp;&nbsp;华为首页</a></td>
				<td class="second">&nbsp;&nbsp;<img src="img/位置图标.png"
					class="addressSrc">&nbsp;&nbsp;长沙
				</td>
				
				<td class="third"><a href="showOrder/getOrderInfo" style="text-decoration:none;">我的订单</a></td>
				
				
				<td class="forth">
				<c:choose>
						<c:when test="${empty userName}">您好，请<a href="login.jsp"
								style="text-decoration: none;">登录</a>&nbsp;&nbsp;<a
								href="register.jsp" style="text-decoration: none;">免费注册</a>
						</c:when>
						<c:otherwise>欢迎您，${userName}</c:otherwise>
					</c:choose></td>
			</tr>


		</table>
</body>
</html>