
$(function(){
	
	//用户登录
	$(".login").click(function(){
		var username = $(".username").val();
		var password = $(".password").val();
		$.ajax({
			url: "/springmvc/user/login.action",
			type: "post",
			data:{
				"username": username,
				"password": password
			},
			success: function(data){
				var json = JSON.parse(data);
				if(json.status == 0){
					$(".show-msg").text(json.msg).css("color","red");
					return;
				}
				window.location.href="index.jsp";
			}
		});
	});
});
