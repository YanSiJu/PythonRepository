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
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	var wait = 120;
	function get_code_time() {
		if (wait == 0) {
			$("#sendmsg").removeAttr("disabled"); // 移除获取验证码按钮的disabled属性
			$("#sendmsg").val("获取验证码");
			wait = 120;
		} else {
			$("#sendmsg").attr("disabled", true); // 设置获取验证码按钮为不可触发
			$("#sendmsg").val("剩(" + wait + ")秒");
			console.log(wait);
			wait--;
			setTimeout("get_code_time()", 1000);
		}
	}
</script>
<script src="js/validate.js"></script>
<title>会员注册</title>
</head>
<body>
	<div style="padding: 360px;360px;" id="regist">
		<form name="regitform">
			手机号码:<input type="text" id="mobile" />&emsp; <input type="button"
				id="sendmsg" value="发送验证码" style="background-color: orange;" /> <br />
			<em style="color: red;" id="mobile_error"></em> <br />
			<script type="text/javascript">
				var submitBtn = document.getElementById("sendmsg");
				submitBtn.onclick = function(event) {
					var tel = $("#mobile").val(); //获取手机号码输入框值  
					var reg = /^1[0-9]{10}$/; //   /^1[3|4|5|8][0-9]\d{4,8}$/
					if (!reg.test(tel)) { //校验手机号码格式  
						$("#mobile_error").text("请先输入您的正确手机号！");
						document.regitform.focus();
						return false;
					} else {
						$("#mobile_error").text("");
						return true;
					}
				}
			</script>
			<br /> 验证码: <input type="text" id="validateCode" />
		</form>
		<br /> <br />
		<form action="#" method="get">
			&emsp;&emsp;&emsp;&emsp;<input type="button"
				style="text-decoration: none; background-color: #AAAAAA; width: 80px; height: 30px;"
				value="注&emsp;&emsp;册" />
		</form>
	</div>
</body>
</html>