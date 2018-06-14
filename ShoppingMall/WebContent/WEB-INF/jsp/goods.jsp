<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" type="text/css" href="css/Navigation.css" />
<head>
<title>华为商城</title>
<style>
#param {
	border: 1px solid #090;
	margin-left: 530px;
	height: 25px;
}

#div_2 {
	background-color: #FF6600;
}

a {
	text-decoration: none;
}
</style>

</head>
</head>

<body>

	<ul style="width: 840px;">
		<li><a href="#home">主页</a></li>
		<li><a href="#home" class="active">我的订单</a></li>
		<li><a href="${pageContext.request.contextPath }/Shoppingtrolley/queryTrolleyInfo">我的购物车</a></li>
		<c:if test="${not empty user }">
			<li><a href="${pageContext.request.contextPath }/User/logout">注销</a></li>
		</c:if>
		<c:if test="${empty user }">
			<li><a href="${pageContext.request.contextPath }/User/loginSkip">登录</a></li>
			<li><a href="${pageContext.request.contextPath }/User/regist">注册</a></li>
		</c:if>

	</ul>
	<form action="${pageContext.request.contextPath }/goods/queryGoods">
		<input type="text" id="param" name="param" /> <input type="submit"
			value="搜索" />
	</form>
	<br />
	<table>
		<tr>

			<th>品牌:</th>
			<td><a href="">荣耀</a></td>
			<td><a href="">Mate</a></td>
			<td><a href="">nova</a></td>
			<td><a href="">畅玩</a></td>
		</tr>

		<tr>
			<th>颜色:</th>
			<td><a href="">黑色</a></td>
			<td><a href="">金色</a></td>
			<td><a href="">白色</a></td>
		</tr>

		<tr>
			<th>容量:</th>
			<td><a href="">4G+32G</a></td>
			<td><a href="">6G+128G</a></td>
			<td><a href="">6G+64G</a></td>
		</tr>
		<tr>
			<th>排序方式:</th>
			<td><a
				href="${pageContext.request.contextPath }/goods/displayGoodsBySalesVolume">销量+</a></td>
			<td><a
				href="${pageContext.request.contextPath }/goods/displayGoodsByPrices">价格+</a></td>
			<td><a
				href="${pageContext.request.contextPath }/goods/displayGoodsBySalesVolumeDecline">销量-</a></td>
			<td><a
				href="${pageContext.request.contextPath }/goods/displayGoodsByPricesDecline">价格-</a></td>
		</tr>
		<c:forEach items="${img}" var="i" varStatus="status">
			<c:if test="${status.count eq 1 || (status.count-1) % 5 eq 0}">
				<tr>
			</c:if>
			<!-- <td>&emsp;&emsp;&emsp;</td> -->
			<td>&emsp;&emsp;&emsp;</td>
			<td><a
				href="${pageContext.request.contextPath }/goods/goodsDetail?goodsId=${goods[status.count-1].id}"
				target="_black"> <img alt="" src="${i.imgSrc}"
					style="width: 100px">
			</a> <br>
				<p>
					<big style="color: red;">￥${prices[status.count-1].price}0</big> <br>
					${goods[status.count-1].name} <br>
					销量:${prices[status.count-1].salesVolume}
				</p></td>
			<!-- <td>&emsp;&emsp;&emsp;</td> -->
			<br>
			<c:if test="${status.count % 5 eq 0 || status.count eq 5}">
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<div></div>



</body>
</html>
