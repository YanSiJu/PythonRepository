<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/orderInfo.css" type="text/css" />
<title>订单界面</title>
<style>

</style>
</head>
<body>


	<%
		String userName = (String) session.getAttribute("userName");
	%>
	
	<div class="content">

		<table class="table">
			<tr>
				<td class="first">&nbsp;&nbsp;<img src="img/首页图标.png"
					class="indexSrc"><a href="goods/displayGoods"
					style="text-decoration: none;">&nbsp;&nbsp;华为首页</a></td>
				<td class="second">&nbsp;&nbsp;<img src="img/位置图标.png"
					class="addressSrc">&nbsp;&nbsp;长沙
				</td>



				<td class="forth"><c:choose>
						<c:when test="${empty userName}">您好，请<a href="User/loginSkip"
								style="text-decoration: none;">登录</a>&nbsp;&nbsp;<a
								href="User/regist" style="text-decoration: none;">免费注册</a>
						</c:when>
						<c:otherwise>欢迎您，${userName}</c:otherwise>
					</c:choose></td>
			</tr>


		</table>

		<div class="order">我的订单</div>

		<table class="table2">
			<tr>
				<td class="tdg" colspan="3">订单详情</td>
				<td class="td">收货人</td>
				<td class="td">金额</td>
				<td class="td">评价状态</td>

			</tr>
		</table>
		<br>
		<hr>
		<br>
		<c:forEach var="i" begin="0" end="${sessionScope.num}">
			<table class="table">
				<tr>

					<td colspan="6" class="d">${sessionScope.orderInfo[i].time }&nbsp;&nbsp;&nbsp;&nbsp;
						订单号：${sessionScope.orderInfo[i].orderId }<c:forEach begin="0"
							end="15" var="i">&nbsp;</c:forEach>华为手机购物商城
					</td>

				</tr>

				<tr>
					<td class="picture"><img
						src="${sessionScope.imgList[i].imgSrc}" class="phone"></td>
					<td class="intro">${sessionScope.goodsNameList[i] }
						${sessionScope.gioList[i].type} ${sessionScope.imgList[i].color }
			</td>
					<td class="count">×${sessionScope.orderInfo[i].amount}</td>
					<td class="name">${sessionScope.orderInfo[i].name}</td>
					<td class="price">￥${sessionScope.orderInfo[i].amount * sessionScope.priceList[i]}</td>
					<td class="operate"><c:choose>
							<c:when test="${empty sessionScope.commentList[i]}">
								<form action="comment.jsp" method="post">
									<input type="submit" value="去评价" class="comment" />

								</form>
							</c:when>
							<c:otherwise>已评价</c:otherwise>
						</c:choose></td>
				</tr>
			</table>
			<hr>
		</c:forEach>
	</div>
</body>
</html>