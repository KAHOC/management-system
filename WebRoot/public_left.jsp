<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class=" js csstransforms3d"><head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>公共侧边栏</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/page.css">
	<!--[if lte IE 8]>
	<link href="css/ie8.css" rel="stylesheet" type="text/css"/>
	<![endif]-->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/modernizr.js"></script>
	<!--[if IE]>
	<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
</head>

<body>
	<!--side S-->
	<div class="super-side-menu">
		<div class="logo"><a href="public_super_cg.html" target="_parent"><img src="images/logo.png"></a></div>
		
		<div class="side-menu">
			<ul>
				<li class=""><a href="Tb_managerServlet?f=list" target="Mainindex"><i class="ico-1"></i>管理员信息管理</a></li>
				<li><a href="Tb_studentServlet?f=list" target="Mainindex"><i class="ico-2"></i>考生信息管理</a></li>
				<li class=""><a href="Tb_sturesultServlet?f=list" target="Mainindex"><i class="ico-3"></i>考生成绩查询</a></li>
				<li><a href="Tb_lessonServlet?f=list" target="Mainindex"><i class="ico-4"></i>课程信息管理</a></li>
				<li><a href="Tb_taotiServlet?f=list" target="Mainindex"><i class="ico-5"></i>套题信息管理</a></li>
				<li><a href="Tb_questionsServlet?f=show" target="Mainindex"><i class="ico-6"></i>考试题目管理</a></li>
				<li><a href="Tb_managerServlet?f=exit" target="_parent" ><i class="ico-7"></i>退出后台设置</a></li>
			</ul>
		</div>
	</div>
	<!--side E-->

<script type="text/javascript">
	$(function(){
		$('.side-menu li').click(function(){
			$(this).addClass('on').siblings().removeClass('on');
		})
	})
</script>

</body></html>
