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
<link rel="stylesheet" href="css/inform.css" type="text/css" />
<title>添加购物车成功</title>
</head>
<body>

	<%
		String userName = (String) session.getAttribute("userName");
	%>

	<div class="content">
		<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>

		<table>
			<tr>
				<td class="td"><img src="img/华为图标.jpg" class="img"></td>
				<td>
					<form
						action="${pageContext.request.contextPath }/Shoppingtrolley/queryTrolleyInfo">
						<input type="submit" value="购物车    >" class="submit" />
					</form>
				</td>

			</tr>
		</table>
		<hr class="hr">
		<table>
			<tr>
				<td><img src="img/勾号.jpg" class="true"></td>
				<td>
					<h3 class="h3">商品已成功加入购物车！</h3>
				</td>
			</tr>
		</table>

		<table class="lastTable">
			<tr>
				<td class="td1"><img src="img/华为荣耀10幻影蓝正面.png" class="blue"></td>
				<td class="td2">${name} 荣耀10全面屏AI摄影手机 ${type } 游戏手机 ${color}全网通 移动联通电信4G
					${capacity }<br> goodsId:${goodsId}
					<p>颜色：${color } 配置：${type } / 数量：${number }</p>
				</td>
				<td class="td3"><br> <br> <%-- <form  method="get"
						action="${pageContext.request.contextPath }/goods/goodsDetail?goodsId=${goodsId}">
						<input type="submit" value="查看商品详情" class="submit1" />
					</form> --%> <a
					href="${pageContext.request.contextPath }/goods/goodsDetail?goodsId=${goodsId}"
					class="submit1">查看商品详情 </a></td>
				<td class="td4"><br> <br>
					<form
						action="${pageContext.request.contextPath }/Shoppingtrolley/queryTrolleyInfo">
						<input type="submit" value="去购物车结算    >" class="submit2" />
					</form></td>
			</tr>
		</table>

	</div>
</body>
</html>