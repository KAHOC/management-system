<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>用户登录</title>
	<link rel="stylesheet" href="css/base.css" />
	<link rel="stylesheet" href="css/login.css" />
	<script type="text/javascript" src="js/jquery.min.js" ></script>
	<script type="text/javascript">
		/*产生验证码*/
		function onYzm(){
			var strs=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','y','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'];
			var index1 = Math.floor(Math.random()*36);//得到0-35之间的整数
			var index2 = Math.floor(Math.random()*36);//得到0-35之间的整数
			var index3 = Math.floor(Math.random()*36);//得到0-35之间的整数
			var index4 = Math.floor(Math.random()*36);//得到0-35之间的整数
			var num = strs[index1]+strs[index2]+strs[index3]+strs[index4];
			return num;
		}
		
		$(function(){
			var num = onYzm(); //获取验证码			
			$(".yzm").html("<font color='red' size='5'>"+num+"</font>"); //在span中显示验证码
			
			$(".loginbtn").click(function(){
				var userYzm = $("#txtYzm").val();  //获取用户输入的验证码
				var yzm = $("#yzm").text(); //获取系统 产生的验证码
				if(userYzm != yzm){
					alert("验证码错误，请重新输入!!!");
					return;
				}
				else{   //如果验证码正确则提交表单
				    $("#form1").submit();
				}
			});
			
		})
	</script>
</head>
<body>
<div class="superlogin"></div>
<div class="loginBox">
	<div class="logo"><img src="images/logo_login.png"/></div>
	<div class="loginMain">
		<div class="tabwrap">
		<form action="Tb_managerServlet?f=login" method="post" id="form1">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr><td class="title">用户名：</td><td><input type="text" id="txtManName" name="txtManName" class="form-control txt" /></td></tr>
				<tr><td class="title">密   码：</td><td><input type="password" id="txtPwd" name="txtPwd" class="form-control txt" /></td></tr>
				<tr><td class="title">验证码：</td><td><input type="text" id="txtYzm" class="form-control txt txt2" /><span class="yzm" id="yzm"></span></td></tr>
				<tr class="errortd"><td>&nbsp;</td><td>&nbsp;</td></tr>		
				<tr><td>&nbsp;</td><td><input type="button" class="loginbtn" value="登录""/>
				<input type="button" class="resetbtn" value="重置""/></td></tr>		
				<tr><td>&nbsp;</td><td class="forgetpsw"></td></tr>	
			</table>
		</form>
		</div>
	</div>
</div>
<div class="footer">Copyright © 2015-2016 uimaker  All Rights Reserved.</div>
</body>
</html>
