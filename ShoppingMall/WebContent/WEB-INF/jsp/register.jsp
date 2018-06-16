<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<!-- <link rel="stylesheet" href="css/register.css" type="text/css" /> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.2.1.min.js"></script>
<style>
@CHARSET "UTF-8";

.register {
	font-family: sans-serif;
	width: 830px;
	height: 720px;
	background-color: #F0FFFF;
}

input {
	width: 200px;
}

h1 {
	text-align: center;
}

h4 {
	text-align: right;
}

.td {
	width: 300px;
}

.td2 {
	text-align: left;
}

/* .register {
	margin-left: 75px;
	text-align: center;
	width: 150px;
	height: 40px;
	background-color: #99CCFF;
	border: 0;
	color: #FFFFFF;
} */
.blank {
	height: 300px;
	width: 200px;
}
</style>
<title>注册界面</title>
</head>
<body>
	<div class="register">
		<br>
		<h4 style="text-align: right;">
			已有账号，直接<a href="login.jsp">登录</a>
		</h4>
		<br>
		<h1 style="text-align: center;">&emsp;华为手机购物商城</h1>
		<br> <br>

		<form action="User/register" method="post" name="registerForm">
			<table style="border: 0; width: %100; text-align: center;">
				<tr>
					<td class="td"></td>
					<td class="td2">手&nbsp;&nbsp;机&nbsp;&nbsp;号:<input type="text"
						id="tel" name="tel" class="tel" /><br> <br>
					</td>
				</tr>
				<tr>
					<td class="td"></td>
					<td><em style="color: red;" id="tel_error"></em></td>
				</tr>
				<tr>
					<td class="td"></td>
					<td class="td2">用&nbsp;&nbsp;户&nbsp;&nbsp;名:<input type="text"
						id="userName" name="userName" class="userName" /><br> <br>
					</td>
					<!-- <td><em style="color: red;" id="userName_error"></em></td> -->
				</tr>
				<tr>
					<td class="td"></td>
					<td><em style="color: red;" id="userName_error"></em></td>
				</tr>
				<tr>
					<td class="td"></td>
					<td class="td2">
						密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input
						id="password" type="password" name="password" class="password" /><br>
						<br>
					</td>
					<!-- <td><em style="color: red;" id="password_error"></em></td> -->
				</tr>
				<tr>
					<td class="td"></td>
					<td><em style="color: red;" id="password_error"></em></td>
				</tr>
				<tr>
					<td class="td"></td>
					<td class="td2">确认密码:<input type="password" name="repassword"
						id="repassword" /><br> <br>
					</td>
					<!-- <td><em style="color: red;" id="repassword_error"></em></td> -->
				</tr>
				<tr>
					<td class="td"></td>
					<td><em style="color: red;" id="repassword_error"></em></td>
				</tr>
				<tr>
					<td class="td"></td>
					<td class="td2">收货地址:<input type="text" name="address"
						id="address" class="address" /><br> <br>
					</td>
					<!-- <td><em style="color: red;" id="address_error"></em></td> -->
				</tr>
				<tr>
					<td class="td"></td>
					<td><em style="color: red;" id="address_error"></em></td>
				</tr>
				<tr>
					<td class="td"></td>
					<td class="td2">
						姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:<input
						type="text" name="name" class="name" id="name" /><br> <br>
					</td>
					<!-- <td><em style="color: red;" id="name_error"></em></td> -->
				</tr>
				<tr>
					<td class="td"></td>
					<td><em style="color: red;" id="name_error"></em></td>
				</tr>
				<tr>
					<td class="td"></td>
					<td class="td3"><input type="submit" value="注&emsp;&emsp;册"
						id="regist" style="margin-left: 65px" class="button" /></td>
				</tr>
			</table>
			<script>
				var submitBtn = document.getElementById("regist");
				submitBtn.onclick = function(event) {
					console.log(event)
					var flag = 1;
					if ($("#password").val() == "") {
						$("#password_error").html("&emsp;&emsp;请输入密码")
						flag = 0;
					}
					if ($("#repassword").val() == "") {
						$("#repassword_error").html("&emsp;&emsp;请确认密码")
						flag = 0;
					}
					if ($("#repassword").val() != ""
							&& $("#repassword").val() != $("#password").val()) {
						$("#repassword_error").html("&emsp;&emsp;两次输入的密码不一致")
						flag = 0;
					}
					if ($("#address").val() == "") {
						$("#address_error").html("&emsp;&emsp;收货地址不能为空")
						flag = 0;
					}
					if ($("#name").val() == "") {
						$("#name_error").html("&emsp;&emsp;收货人不能为空")
						flag = 0;
					}
					var error = 1;
					if ($("#userName").val() == "") {
						$("#userName_error").html("&emsp;&emsp;用户名不能为空");
						flag = 0;
						error = 0;
					}
					if ($("#userName").val() != ""
							&& $("#userName").val().length < 4
							|| $("#userName").val().length > 17) {
						$("#userName_error").html("&emsp;&emsp;用户名为4~17个字符");
						flag = 0;
						error = 0;
					}
					var name = $("#userName").val()
					var data = {
						"name" : name
					};
					$.ajax({
						url : 'User/validateUserName',
						type : 'POST',
						data : JSON.stringify(data),
						contentType : 'application/json; charset=utf-8',
						dataType : 'json',
						success : function(response) {
							var msg = response.msg;
							if (msg != "OK") {
								$("#userName_error").text(msg);
								flag = 0;
							} else {
								if (error == 1) {
									$("#userName_error").text("");
								}
							}
						},
						error : function(msg) {
							console.log(msg)
						}

					});
					var tel = $("#tel").val(); //获取手机号码输入框值
					console.log(tel != "")
					var reg = /^1[0-9]{10}$/; //   /^1[3|4|5|8][0-9]\d{4,8}$/
					if ($("#tel").val() == "") {
						$("#tel_error").text("手机号码不能为空");
						flag = 0;
					} else if (!reg.test(tel)) { //校验手机号码格式  
						$("#tel_error").html("&emsp;&emsp;请先输入正确的手机号！");
						flag = 0;
					} else {
						$("#tel_error").text("");
					}
					if (flag == 0) {
						return false;
					}

					return true;
				};
			</script>
		</form>

	</div>

</body>
</html>