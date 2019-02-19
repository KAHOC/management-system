<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>超级系统网站后台</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/page.css">
	<!--[if lte IE 8]>
	<link href="css/ie8.css" rel="stylesheet" type="text/css"/>
	<![endif]-->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/modernizr.js"></script>

  </head>
  
  <body>
  <div class="defaultTab-T"><h5>&nbsp;&nbsp;&nbsp;当前位置：管理员信息管理>>>>>>管理员密码修改</h5></div>
  <form action="Tb_managerServlet?f=updata" method="post">
  <input type="hidden" name="id" value="${man.id }">
  <input type="hidden" name="pwdo" value="${man.pwd }">
   <div class="super-content">
		<div class="superCtab">
			<div class="publishArt">
				<h4>修改密码</h4>
				<div class="pubMain">
				<h5 class="pubtitle">用户名</h5>
					<div class="pub-txt-bar">
						<input type="text" class="shuruTxt2" value="${man.manName}" name="manName">
						
					</div>
					<h5 class="pubtitle">旧密码</h5>
					<div class="pub-txt-bar">
						<input type="password" class="shuruTxt2" name="opwd">
					</div>
					<h5 class="pubtitle">新密码<span>（数字、字母、符号组合，最少8个字符）</span></h5>
					<div class="pub-txt-bar">
						<input type="password" class="shuruTxt2" name="npwd">
					</div>
					<h5 class="pubtitle">确认密码</h5>
					<div class="pub-txt-bar">
						<input type="password" class="shuruTxt2" name="npwd2">
					</div>
					<div class="pub-btn">
						<input type="submit" value="确定" class="saveBtn">
						<input type="button" value="重置" class="resetBtn">
					</div>
				</div>
			</div>
		
		</div>
		<!--main-->
	</div>
	</form>
  </body>
</html>
