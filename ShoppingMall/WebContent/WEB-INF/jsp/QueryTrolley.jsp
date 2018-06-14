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
<link rel="stylesheet" href="css/shoppingCar.css" type="text/css" />
<style>
.table3 {
	border: 1;
	border-color: black;
	/* width: 1000px; */
}
</style>
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function add(id) {
		//根据id得到库存
		var quantity = $("#" + id).val();
		console.log("库存");
		console.log(quantity);  
		//得到原来的数量n
		var n = $("#quantity" + id).text();
		n = parseInt(n);
		
		console.log("原来的数量n:");
		console.log(n);
		
		//判断n+1是否超过库存决定是否+1
		var number = n+1;
		if (number <= quantity) {
			//$(".price").val(n + 1);
			$("#quantity" + id).text(number);
		}
		var trolleyId = $("#trolleyId").val();
		modifyNumber(id,trolleyId,number);
	}
	
	function modifyNumber(goodsId,trolleyId,number){
		var price = $("#price" + goodsId).text();
		var data ={
				"goodsId":parseInt(goodsId),
				"trolleyId":parseInt(trolleyId),
				"number":parseInt(number),
				"price":parseFloat(price)
		};
		$.ajax({
			url : 'Shoppingtrolley/updateQuantity',
			type : 'POST',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function(response) {
				console.log(response);
			},
			error : function(msg) {
				console.log(msg)
			}

		});
	}

	function minus(id) {
		//得到原来的数量n
		
		var n = $("#quantity" + id).text();
		n = parseInt(n)
		console.log("\nminus:")
		console.log(n)
		//判断n-1是否 > 0决定是否+1
		if (n - 1 > 0) {
			$("#quantity" + id).text(n-1);
		}
		var number = n-1;
		var trolleyId = $("#trolleyId").val();
		modifyNumber(id,trolleyId,number);
	}
	
	
	function deleteEle(id){
		//在页面动态删除
		$("#tr" + id).remove();
		//获取购物车id
		var trolleyId = $("#trolleyId").val();
		//构造json对象
		var data ={
				"goodsId":parseInt(id),
				"trolleyId":parseInt(trolleyId)
		};
		$.ajax({
			url : 'Shoppingtrolley/deleteGoods',
			type : 'POST',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function(response) {
				console.log(response);
			},
			error : function(msg) {
				console.log(msg)
			}

		});
	}
	
	
</script>
<title>购物车</title>
</head>
<body>
	<div class="content">
		<table class="table">
			<tr>
				<td class="first">&nbsp;&nbsp;<img src="img/首页图标.png"
					class="indexSrc"><a href="index.jsp"
					style="text-decoration: none;">&nbsp;&nbsp;华为首页</a></td>
				<td class="second">&nbsp;&nbsp;<img src="img/位置图标.png"
					class="addressSrc">&nbsp;&nbsp;长沙
				</td>
				<td class="third"></td>
			</tr>
		</table>

		<table class="table1">
			<tr class="tr2">
			</tr>
		</table>
		<table class="table2">
			<tr>
				<td class="check"><input type="checkbox" />全选</td>
				<td class="tdg" colspan="3">商品</td>
				<td class="td">单价</td>
				<td class="td">数量</td>
				<td class="td">小计</td>
				<td class="td">操作</td>
			</tr>
		</table>
		<br>
		<hr>
		<br> <br> <br> <input type="hidden" id="trolleyId"
			value="${shoppingtrolleyId }" />
		<table class="table3">
			<c:forEach var="g" items="${goodsInTrolley }" varStatus="sts">
				<input type="hidden" id="${g.goodsId }"
					value="${quantities[sts.count-1]}" />
				<tr id="tr${g.goodsId }">
					<td class="check"><input type="checkbox" /></td>
					<td class="picture"><img src="img/华为荣耀10海鸥灰正面.png"
						class="phone"></td>
					<td class="intro">${names[sts.count-1]}<br>
						前置摄像头:${g.frontFacingCamera } <br> 后置摄像头:${g.rearCamera }<br>
						电池容量:${g.batteryCapacity }<br> 配置:${g.type }
					</td>
					<td class="version">￥ <span id="price${g.goodsId }">
							${prices[sts.count-1]} </span> <br></td>
					<td class="price">
						<p>
							<button style="background-color: white" id="minus"
								onclick="minus(${g.goodsId })">-</button>
							<span id="quantity${g.goodsId }">${g.quantity }</span>
							<button style="background-color: white" id="add"
								onclick="add(${g.goodsId })">+</button>
						</p>
					</td>
					<!-- <td class="count">2</td> -->
					<td class="finalPrice"><b style="color: red;">￥${g.amount }</b></td>
					<td class="delete"><button onclick="deleteEle(${g.goodsId })"
							style="text-decoration: none;">删除</button></td>
				</tr>
			</c:forEach>

		</table>
		<hr>
		<hr>
		<div class="operation">
			<input type="checkbox" />全选
			<c:forEach begin="0" end="25" var="i">&nbsp;</c:forEach>
			总计<b class="imp">${totalQuantity }</b>件商品
			<c:forEach begin="0" end="10" var="i">&nbsp;</c:forEach>
			总价:<b class="imp" style="color: red;">￥${totalPrice }</b>
			<form action="" method="post">
				<input type="submit" value="去结算" class="button" />
			</form>
			<form action="" method="post">
				<input type="submit" value="清空购物车" class="button" />
			</form>

		</div>
	</div>
</body>
</html>