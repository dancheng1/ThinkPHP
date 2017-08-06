$(function(){
	//1.得到所有错误信息，循环遍历之。调用一个方法来确定是否显示错误信息
	$(".labelError").each(function(){
		showError($(this));    //遍历每一个元素，使用每一个元素来调用showError方法
	});
	//2.切换注册按钮的图片
	$("#submit").hover(
		function() {
			$("#submit").attr("src", "/goods/images/regist2.jpg");	
		},
		function() {
			$("#submit").attr("src", "/goods/images/regist1.jpg");
		}
	);
	//3.输入框得到焦点隐藏错误信息
	$(".input").focus(function(){
		var labelId = $(this).attr("id") + "Error";   //通过输入框找到label的Id
		$("#" + labelId).text("");    //吧label的内容清空
		showError($("#" + labelId).text(""));    //隐藏没有信息lable
	});
	//4.输入框失去焦点进行校验
	$(".input").blur(function(){
		var id = $(this).attr("id");            //获取当前输入框的id
		var funName = "validate" + id.substring(0,1).toUpperCase() + id.substring(1) + "()";
		eval(funName);                         //eval函数中的参数是，一段可执行的字符串，执行函数调用
	});
	//5.表单提交时进行校验
	$("#registForm").submit(function(){
		var bool = true;
		if(!validateLoginname()){
			bool = false;
		}
		if(!validateLoginpass()){
			bool = false;
		}
		if(!validateReloginpass()){
			bool = false;
		}
		if(!validateEmail()){
			bool = false;
		}
		if(!validateVerifyCode()){
			bool = false;
		}
		return bool;
	});
});
//判断当前元素是否存在内容，如果存在显示，页面不显示！
function showError(ele) {
	var text = ele.text();    //获取元素的内容
	if(!text){              //如果没有内容
		ele.css("display", "none");    //隐藏元素
	} else {                   //如果有内容
		ele.css("display", "");     //显示元素
	}
}
//登录名校验方法
function validateLoginname(){
	var id = "loginname";
	var value = $("#" + id).val();   //获取输入框内容
	//1.非空校验
	if(!value) {
		//1.获取对应的label
		//2.添加错误信息
		//3.显示label
		$("#" + id + "Error").text("用户名不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	//2.长度校验
	if(value.length < 3 || value.length >20) {
		//1.获取对应的label
		//2.添加错误信息
		//3.显示label
		$("#" + id + "Error").text("用户名长度必须在3~20之间！");
		showError($("#" + id + "Error"));
		return false;
	}
	//3.是否注册校验
	$.ajax({
		url:"/goods/UserServlet",
		data:{method:"ajaxValidateLoginname", loginname:value},  //给服务器的参数
		type:"POST",
		dataType:"json",
		async:false,   //是否是异步请求，如果是异步，那么不会等服务器返回，这个函数就向下运行了；
		cache:false,
		success:function(result){
			if(!result) {//如果校验失败
				$("#" + id + "Error").text("用户名已被注册！");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});  
	return true;
}
//登录密码校验方法
function validateLoginpass(){
	var id = "loginpass";
	var value = $("#" + id).val();   //获取输入框内容
	//1.非空校验
	if(!value) {
		//1.获取对应的label
		//2.添加错误信息
		//3.显示label
		$("#" + id + "Error").text("密码不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	//2.长度校验
	if(value.length < 3 || value.length >20) {
		//1.获取对应的label
		//2.添加错误信息
		//3.显示label
		$("#" + id + "Error").text("密码长度必须在3~20之间！");
		showError($("#" + id + "Error"));
		return false;
	}
	return true;
}
//确认密码校验方法
function validateReloginpass(){
	var id = "reloginpass";
	var value = $("#" + id).val();   //获取输入框内容
	//1.非空校验
	if(!value) {
		//1.获取对应的label
		//2.添加错误信息
		//3.显示label
		$("#" + id + "Error").text("确认密码不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	//2.两次输入是否一致
	if(value != $("#loginpass").val()) {
		//1.获取对应的label
		//2.添加错误信息
		//3.显示label
		$("#" + id + "Error").text("两次输入不一致！");
		showError($("#" + id + "Error"));
		return false;
	}
	return true;
}
//Email校验方法
function validateEmail(){
	var id = "email";
	var value = $("#" + id).val();   //获取输入框内容
	//1.非空校验
	if(!value) {
		//1.获取对应的label
		//2.添加错误信息
		//3.显示label
		$("#" + id + "Error").text("email不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	//2.email格式校验
	if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(value)) {
		//1.获取对应的label
		//2.添加错误信息	
		//3.显示label
		$("#" + id + "Error").text("错误的email格式！");
		showError($("#" + id + "Error"));
		return false;
	}
	//3.是否注册校验
	$.ajax({
		url:"/goods/UserServlet",
		data:{method:"ajaxValidateEmail", email:value},  //给服务器的参数
		type:"POST",
		dataType:"json",
		async:false,   //是否是异步请求，如果是异步，那么不会等服务器返回，这个函数就向下运行了；
		cache:false,
		success:function(result){
			if(!result) {//如果校验失败
				$("#" + id + "Error").text("Email已被注册！");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});  	
	return true;
}
//验证码校验方法
function validateVerifyCode(){
	var id = "verifyCode";
	var value = $("#" + id).val();   //获取输入框内容
	//1.非空校验
	if(!value) {
		//1.获取对应的label
		//2.添加错误信息
		//3.显示label
		$("#" + id + "Error").text("验证码不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	//2.长度校验
	if(value.length != 4) {
		//1.获取对应的label
		//2.添加错误信息
		//3.显示label
		$("#" + id + "Error").text("错误的验证码！");
		showError($("#" + id + "Error"));
		return false;
	}	
	$.ajax({
		url:"/goods/UserServlet",
		data:{method:"ajaxValidateVerifyCode", verifyCode:value},  //给服务器的参数
		type:"POST",
		dataType:"json",
		async:false,   //是否是异步请求，如果是异步，那么不会等服务器返回，这个函数就向下运行了；
		cache:false,
		success:function(result){
			if(!result) {//如果校验失败
				$("#" + id + "Error").text("验证码错误！");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});  	
	return true;
}

//换一张验证码
function _hyz(){
	//1.获取<img>元素
	//2.重新设置他的src
	//3.使用毫秒来添加参数
	$("#vCode").attr("src", "/goods/VerifyCodeServlet?" + new Date().getTime());
}


