<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>文章发布</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/page.css">
	<!--[if lte IE 8]>
	<link href="css/ie8.css" rel="stylesheet" type="text/css"/>
	<![endif]-->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/modernizr.js"></script>
  </head>
  
  <body>
    <div class="Mian-cont-wrap" style="margin-top:20">
    	<div class="defaultTab-T"><h5>&nbsp;&nbsp;&nbsp;当前位置：管理员信息管理</h5></div>
						<div class="defaultTab-T">
							<table border="0" cellspacing="0" cellpadding="0" class="defaultTable">
								<tbody><tr><th class="t_1">管理员ID</th><th class="t_2">管理员用户名</th><th class="t_4">操作</th></tr>
							</tbody></table>
						</div>
						<table border="0" cellspacing="0" cellpadding="0" class="defaultTable defaultTable2">
							<tbody>
							<c:forEach items="${mlist}" var="mlist">
							<tr>
								<td class="t_1">${mlist.id }</td>
								<td class="t_2"><a href="#">${mlist.manName}</a></td>
								<c:if test="${mlist.manName eq sessionScope.manager.manName}">
								<td class="t_4"><div class="btn"><a href="Tb_managerServlet?f=select&id=${mlist.id }" class="modify">修改</a><a href="#" class="delete">删除</a></div></td>
								</c:if>
							</tr>
							</c:forEach>
						</tbody></table>
						<!--pages S-->
						
						<!--pages E-->
					</div>
  </body>
</html>
