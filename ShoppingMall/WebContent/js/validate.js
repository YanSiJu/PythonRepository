$(document).ready(function() {
	$("#sendmsg").click(function() {
		var mobile = $("#mobile").val();
		var data = {
			"mobile" : mobile
		};
		// jquery post方法同步提交
		// （提交地址； data：返回值）
		$.ajax({
			url : 'User/sendCode',
			type : 'POST',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function(data) {
				if (data != null && typeof (data) != "undefined") {
					var code = data.code; // 返回值为json格式
					if (code != null && typeof (code) != "undefined") {
						get_code_time(); // 发送成功则调用get_code_time（）函数
						//						
					} else {
						alert("短信验证码发送失败！请重新获取。");
					}
				}
			},
			error : function(msg) {

			}
		});

		

	})
})