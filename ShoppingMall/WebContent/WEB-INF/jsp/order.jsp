<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<script src="js/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function() {

		$("#add").click(function() {
			var n = $("#number").val();
			n = parseInt(n)
			$("#number").val(n + 1)
		})

		$("#pay_1").click(function() {
			document.getElementById("pay_1").style.backgroundColor = "#66FF33";
			document.getElementById("pay_2").style.backgroundColor = "#d0f7c1";
			document.getElementById("pay_3").style.backgroundColor = "#d0f7c1";
		})

		$("#pay_2").click(function() {
			document.getElementById("pay_2").style.backgroundColor = "#66FF33";
			document.getElementById("pay_1").style.backgroundColor = "#d0f7c1";
			document.getElementById("pay_3").style.backgroundColor = "#d0f7c1";
		})

		$("#pay_3").click(function() {
			document.getElementById("pay_3").style.backgroundColor = "#66FF33";
			document.getElementById("pay_2").style.backgroundColor = "#d0f7c1";
			document.getElementById("pay_1").style.backgroundColor = "#d0f7c1";
		})

		$("#minus").click(function() {
			var n = $("#number").val();
			n = parseInt(n)
			if (n > 0) {
				$("#number").val(n - 1)
			}
		})

	});
</script>
<title>订单结算页---华为商城</title>
<style>
.info {
	padding-left: 350px;
	padding-top: 150px;
}

img {
	float: left;
}

#pay_1, #pay_2, #pay_3 {
	display: inline-block;
	border: 1px solid #999999;
	margin: 2px;
	padding: 5px 10px;
	background-color: #d0f7c1;
	font: 20px/20px "幼圆", "楷体", "宋体", Arial, sans-serif;
	border-color: red;
	outline: red;
}

.price {
	text-align: right;
	color: red;
	font-size: 160%;
}

#addre:hover {
	background-color: #E8E8E8;
	width: 150px;
}

#submit {
	background-color: red;
	width: 120px;
	height: 50px;
	color: white;
	margin-left: 85%;
}

a {
	text-decoration: none;
}
</style>
</head>

<body>
	<p id="info" class="info">${user.name }&emsp;&emsp;&emsp;${user.tel}
		&emsp;&emsp;${user.address }
		<!--<a href="" id="edit">编辑</a>-->
		<br /> <br /> <br /> <img
			src="${pageContext.request.contextPath }/img/1.png" />
		${orderInfo.name } ${capacity }<br /> 前置摄像头:${front }&emsp;&emsp; <br />
		后置摄像头:${rear } <br /> ${orderInfo.type }&emsp;&emsp; <br />
		数&emsp;&emsp;量:${number } <br /> ${orderInfo.type }&emsp;&emsp;

		<!-- <button style="background-color: white" id="minus">-</button>
		<input value="1" id="number" style="width: 30px; text-align: center;" />
		<button style="background-color: white" id="add">+</button> -->
		<br /> <em style="color: red; font-size: 160%;">${price }</em> <br />
		<br /> <br />支付方式:
		<button id="pay_1">银行卡支付</button>
		&emsp;&emsp;&emsp;&emsp;<br> &emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;
		<button id="pay_2">支付宝支付</button>
		&emsp;&emsp;&emsp;<br> &emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;
		<button id="pay_3">微信支付</button>


		<br />商品金额: <em class="price">${price * number} </em> <br /> <br />
	<p style="margin-left: 600px; font-size: 165%;">
		总计:<em class="price">${price * number}</em> <br />
	<form action="Order/dealOrder" method="post">
		<input type="submit" value="提交订单" id="submit" />
	</form>


</body>
</html>