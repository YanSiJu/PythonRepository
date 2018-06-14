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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/login.css" type="text/css" />
<script src="js/jquery-3.2.1.min.js"></script>
<title>登录界面</title>
</head>
<body>

	<div class="login">
		<div class="login">
			<br>
			<h4>
				没有账号，立即<a href="${pageContext.request.contextPath }/User/regist">注册</a>
			</h4>
			<br>
			<h1>
				<a href="${pageContext.request.contextPath }/goods/displayGoods"
					style="text-decoration: none">华为手机购物商城</a>
			</h1>
			<br> <br>

			<form action="${pageContext.request.contextPath }/User/login"
				method="post">
				<table width="100%" border="0">

					<tr>
						<td class="td"></td>
						<td class="td2">用&nbsp;&nbsp;户&nbsp;&nbsp;名:<input
							type="text" name="userName"  value="${userName}" id="userName" class="userName" /> <br>
							<br>
						</td>
					</tr>
					<tr>
						<td></td>
						<td style="color: red;" id="userName_error"><br></td>

					</tr>
					<tr>
						<td class="td"></td>
						<td class="td2">
							密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input
							type="password" name="password" id="password"  value="${pwd}" class="password" /><br>
							<br>
						</td>
					</tr>
					<tr>
						<td></td>
						<td style="color: red;" id="password_error"></td>
					</tr>
					<tr>
						<td></td>
						<td style="color: red;">&emsp;&emsp;&emsp;&emsp;${errorMsg }</td>
					</tr>
					<tr>
						<td class="td"></td>
						<td class="td3"><input type="submit" value="登录" id="submit"
							class="button" /></td>
					</tr>
				</table>
			</form>

			<script>
				var submitBtn = document.getElementById("submit");
				submitBtn.onclick = function(event) {
					var flag = 1;
					if ($("#password").val() == "") {
						/*$("#password_error").text("&emsp;&emsp;&emsp;&emsp;请输入密码")*/
						$("#password_error").html(
								"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;请输入密码")
						flag = 0;
					}
					if ($("#userName").val() == "") {
						$("#userName_error").html(
								"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;请输入用户名");
						flag = 0;
					}
					if (flag == 0) {
						return false;
					}
					return true;
				};
			</script>

		</div>
	</div>
</body>
</html>