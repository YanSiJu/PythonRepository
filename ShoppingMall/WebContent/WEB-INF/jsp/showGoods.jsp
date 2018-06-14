<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
	
	});
	
	function changeType(id){
		var price = $("#type"+id).val();
		$("#span_price").text(price);
		var type = $(".type"+id).val();
		var quantity = $(".num"+id).val();
		
		console.log("库存:");
		console.log(quantity);
		console.log(price);
		console.log(type);
		
		$("#quantity").val(quantity);
		$("#goodsType").val(type);
		$("#goodsPrcs").val(price);
		$("#trolleyType").val(type);
		$("#trolleyPrice").val(price);
		var n = $("#number").val();
		if(n > quantity){
			$("#number").val(quantity);
		}
		
	}
	
	function changeColor(id){
		var color = $("#"+id).val();
		$("#goodsColor").val(color);
		$("#trolleyColor").val(color);
	}
	
	function submitForm(){
			var n = $("#number").val();
			$("#goodsNumber").val(n);
			var type = $("#goodsType").val();
			var price = $("#goodsPrcs").val();
			var color = $("#goodsColor").val();
			if(type == "" || price == "" || color == ""){
				alert("请选择类型和颜色");
			}else{
				$("#buy").submit();	
			}
			
	}
	
	function  add() {
		var n = $("#number").val();
		n = parseInt(n)
		var quantity = $("#quantity").val();
		if(n+1 <= quantity){
			$("#number").val(n + 1)	
		}
		
	}
	
	/*对html标签进行反转义*/
    function htmlDecode(value){  
        return $('<span/>').html(value).text();     
    }
	
	
	function  minus() {
		var n = $("#number").val();
		n = parseInt(n)
		if (n-1 > 0) {
			$("#number").val(n - 1)
		}
	}
	 /*对html标签进行转义*/
    function htmlEncode(value){   
        return $('<span/>').text(value).html(); 
    }
     
	
	function appendComment(id){
		var n = $("<tr ></tr>");
		var a = $("<td class=\"pic\"></td>");
		a.html("<img src=\"img/user.jpg\" class=\"userHead\">");
		n.html(a);
		var c = $("<td class=\"comment\"></td>");
		//var txt = $("#commentContent").val();
		var txt = htmlEncode($("#commentContent").val());
		c.text(txt)
		n.append(c);				
		//$(".commentTable").prepend(n);
		sendAjax(id,txt,n);
	}
	
	function sendAjax(goodsId,content,n){
		
		var data ={
			"goodsId":parseInt(goodsId),
			"content":content
		}
		$.ajax({
			url : 'goods/commentGoods',
			type : 'POST',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function(response) {
				var m = response.msg;
				if(m != "OK"){
					alert(m);
				}else{
					$(".commentTable").prepend(n);
					$("#commentContent").val("");
				}
				console.log(response);
			},
			error : function(msg) {
				console.log(msg)
			}
		});
	}
	
</script>
<!-- <link rel="stylesheet" href="css/showGoods.css" type="text/css" /> -->
<style type="text/css">
@CHARSET "UTF-8";

.content {
	font-family: sans-serif;
	width: 1050px;
	height: 1500px;
	background-color: white;
}

.right {
	margin-left: 550px;
	color: white;
}

.index {
	color: white;
	margin-left: 20px;
}

.table {
	border: 0;
}

.href {
	color: white;
}

.imgSrc {
	height: 400px;
	width: 220px;
	margin-left: 50px;
	margin-right: 60px;
}

.tr1 {
	background-color: #FF5151;
	border-color: #F0F0F0;
	color: white;
	height: 30px;
	border: 0;
}

.tr2 {
	height: 500px;
	margin-left: 60px;
}

h4 {
	margin-left: 60px;
	text-align: center;
}

.price {
	color: #FF0000;
}

.back {
	background-color: #F0F0F0;
}

.button {
	width: 130px;
	height: 50px;
	border: 0;
	background-color: red;
	color: white;
	margin-left: 50px;
	font-size: large;
}

.color, .type {
	margin-left: 10px;
	width: 100px;
	height: 30px;
	border-color: #F0F0F0;
	background-color: #F0F0F0;
	border: 0;
}

.techNum {
	height: 30px;
	width: 1000px;
	background-color: #F0F0F0;
}

.in {
	height: 30px;
	width: 90px;
	background-color: #F5DEB3;
	color: black;
	text-align: center;
}

.table2 {
	border: 0;
}

.t {
	width: 300px;
}

.userHead {
	height: 80px;
	width: 80px;
}

.comment {
	width: 600px;
}

.commentTable {
	margin-left: 20px;
}

.pic {
	width: 200px;
}
</style>
<title>${param.name}</title>
</head>
<body>
	<div class="content">

		<input type="hidden" id="quantity" value="${prices[0].quantity}"/>
		<table class="table">
			<tr class="tr1">

				<td><a href="index.jsp" class="index"
					style="text-decoration: none;">首页</a></td>

				<td>
					<div class="right">
						<a href="${pageContext.request.contextPath }/User/regist"
							style="text-decoration: none;" class="href">注册</a> &nbsp;|&nbsp;
						<a href="${pageContext.request.contextPath }/User/loginSkip"
							style="text-decoration: none; margin-right: 30px" class="href">登录</a>
					</div>

				</td>

			</tr>


			<tr class="tr2">

				<td><img src="${image[0].imgSrc }" class="imgSrc"></td>

				<td>
					<h2>${goods[0].name}&emsp;<span id="type">${prices[0].type }</span>&emsp;
						${image[0].color}
					</h2> <br> <br>


					<h2 class="back">
						价格：<b class="price"> <span id="span_price">${prices[0].price}</span>
						</b>
					</h2> <br>


					<h3>
						选择颜色:
						<c:forEach var="i" items="${image }" varStatus="sts">
							<button class="color" onclick="changeColor(${recd[sts.count-1]})">${i.color }</button>
							<input type="hidden" id="${recd[sts.count-1]}"
								value="${i.color }" />
						</c:forEach>
					</h3> <br>

					<h3>
						<!-- record -->
						选择配置:
						<c:forEach var="p" items="${prices }" varStatus="sts">
							<%-- index:${record[sts.count-1]} --%>
							<button class="type" onclick="changeType(${record[sts.count-1]})"
								id="btn+${record[sts.count-1]}">${p.type }</button>
							<input type="hidden" id="type${record[sts.count-1]}"
								value="${p.price}" />
							<input type="hidden" class="type${record[sts.count-1]}"
								value="${p.type}" />
							<input type="hidden" class="num${record[sts.count-1]}"
								value="${p.quantity}" />
						</c:forEach>


						<br> 数&emsp;&emsp;量
						<button style="background-color: white" id="minus"
							onclick="minus()">-</button>
						<input value="1" id="number"
							style="width: 30px; text-align: center;" />
						<button style="background-color: white" id="add" onclick="add()">+</button>



					</h3> <br> <br>
					<form action="Shoppingtrolley/addGoods" method="post" id="trolley">
						<!-- onclick="submitForm()" -->
						<input type="hidden" id="trolleyPrice" name="price" /> <input
							type="hidden" id="trolleyType" name="type" /> <input
							type="hidden" id="trolleyColor" name="color" /> <input
							type="hidden" id="trolleyNumber" name="number" /> <input
							type="hidden" id="trolleyRear" name="rear" /> <input
							type="hidden" id="trolleyFront" name="front" /> <input
							type="hidden" id="trolleyCapacity" name="capacity" /> <input
							type="hidden" name="goodsId" value="${goods[0].id}" /> <input
							type="submit" value="加入购物车" class="button" />
					</form> <script>
				var submitBtn = document.getElementById("trolley");
				submitBtn.onclick = function(event) {
					var n = $("#number").val();
					$("#trolleyNumber").val(n);
					var type = $("#trolleyType").val();
					var price = $("#trolleyPrice").val();
					var color = $("#trolleyColor").val();
					var capacity = $("#batteryCapacity").text();
					var front = $("#frontFacingCamera").text();
					var rear = $("#rearCamera").text();
					$("#trolleyRear").val(rear);
					$("#trolleyFront").val(front);
					$("#trolleyCapacity").val(capacity);
					
					if(type == "" || price == "" || color == ""){
						alert("请选择类型和颜色");
						return false;
					}else{
						return true;	
					}	

				};
			</script> <br>

					<form action="Order/order" method="post" id="buy">
						<!-- onclick="submitForm()" -->
						<input type="submit" value="立即购买" class="button" /> <input
							type="hidden" id="goodsPrcs" name="price" /> <input
							type="hidden" id="goodsType" name="type" /> <input type="hidden"
							id="goodsColor" name="color" /> <input type="hidden"
							id="goodsNumber" name="number" /> <input type="hidden" id="rear"
							name="rear" /> <input type="hidden" id="front" name="front" />
						<input type="hidden" id="capacity" name="capacity" /> <input
							type="hidden" name="goodsId" value="${goods[0].id}" />
					</form> <script>
				var submitBtn = document.getElementById("buy");
				submitBtn.onclick = function(event) {
					var n = $("#number").val();
					$("#goodsNumber").val(n);
					var type = $("#goodsType").val();
					var price = $("#goodsPrcs").val();
					var color = $("#goodsColor").val();
					var capacity = $("#batteryCapacity").text();
					var front = $("#frontFacingCamera").text();
					var rear = $("#rearCamera").text();
					/* alert(front);
					alert(rear);
					alert(capacity); */
					$("#rear").val(rear);
					$("#front").val(front);
					$("#capacity").val(capacity);
					
					if(type == "" || price == "" || color == ""){
						alert("请选择类型和颜色");
						return false;
					}else{
						return true;	
					}	

				};
			</script> <br> <br>
				</td>

			</tr>
		</table>
		<div class="techNum">
			<h3 class="in">技术参数</h3>

		</div>
		<br> <br>
		<table class="table2">
			<tr>
				<td class="t">电池容量: <span id="batteryCapacity">${goods[0].batteryCapacity}</span></td>
				<td class="t">前置摄像头像素: <span id="frontFacingCamera">${goods[0].frontFacingCamera}</span></td>
				<td class="t">后置摄像头像素: <span id="rearCamera">${goods[0].rearCamera}</span></td>
			</tr>
		</table>
		<br>
		<div class="techNum">
			<h3 class="in">商品评价</h3>

		</div>
		<hr>
		<table class="commentTable">
			<c:forEach var="c" items="${comments }">
				<tr>
					<td class="pic"><img src="img/user.jpg" class="userHead"></td>
					<td class="comment">${c.content }</td>
				</tr>
			</c:forEach>
			<!-- <tr>
				<td class="pic"><img src="img/user.jpg" class="userHead"></td>
				<td class="comment">这手机着实好用，支持国产机，支持华为，下次再来！</td>
			</tr> -->

			<!-- <tr>
				<td class="pic"><img src="img/user.jpg" class="userHead"></td>
				<td class="comment">早知道就买iPhone了，但是买了iPhone就要吃土，先用着华为吧！</td>
			</tr>

			<tr>
				<td class="pic"><img src="img/user.jpg" class="userHead"></td>
				<td class="comment">拍照杠杠的，安卓机最爱华为，下台手机依旧华为！</td>
			</tr> -->

		</table>
		<hr>
		<p style="margin-left: 250px">评论:</p>
		<textarea id="commentContent" cols="55" rows="15"
			style="margin-left: 250px"></textarea>
		<br>
		<button
			style="margin-left: 500px; width: 70px; height: 30px; background-color: white;"
			onclick="appendComment(${goods[0].id})">提交评论</button>
	</div>


</body>
</html>