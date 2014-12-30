
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
	
	//获取所有用户
	$.ajax({
		url: "/springmvc/user/list.action",
		type: "post",
		success: function(data){
			var json = JSON.parse(data);
			var show = $(".userlist");
			if(json.status == 0){
				$(show).text(json.msg).css("color","red");
				return;
			}
			var tpl = tpls.userList;
			var html = juicer(tpl, json);
			$(show).html(html);
			
			//用户表格的增删改
			$(".tb tr > td > a").on("click",function(event){
				var _this = $(event.target);
				var userId = _this.parents("tr").attr("data-userid");
				var operate = _this.attr("class");
				
				if(operate == "add")	addUser(_this);
				else if(operate == "edit")	editUser(_this,userId);
				else if(operate == "del"){
					if(confirm("是否真的要删除该条记录?")) delUser(_this,userId);
				}
			});
		}
	});
	
	//增加用户
	function addUser(e){
		$.ajax({
			url: "/springmvc/user/add.action",
			type: "post",
			data:{
				teamId: 1,
				name: "test",
				account: "test",
				password: "ptest",
				gender: 0,
				birthday: "1990-09-22",
				status: 1
			},
			success: function(data){
				var json = JSON.parse(data);
				if(json.status == 0){
					alert(json.msg)
					return;
				}
				alert(json.msg)
			}
		});
	}
	
	//编辑用户
	function editUser(e,id){
		$.ajax({
			url: "/springmvc/user/update.action",
			type: "post",
			data:{
				id:id,
				teamId: 1,
				name: "test",
				account: "test",
				password: "ptest",
				gender: 0,
				birthday: "1990-09-22",
				status: 1
			},
			success: function(data){
				var json = JSON.parse(data);
				if(json.status == 0){
					alert(json.msg)
					return;
				}
				alert(json.msg)
			}
		});
	}
	
	//删除用户
	function delUser(e,id){
		$.ajax({
			url: "/springmvc/user/del.action",
			type: "post",
			data:{"id": id},
			success: function(data){
				var json = JSON.parse(data);
				if(json.status == 0){
					alert(json.msg)
					return;
				}
				e.parents("tr").remove();
				alert(json.msg)
			}
		});
	}
});
