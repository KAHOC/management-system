<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/page.css">
	<!--[if lte IE 8]>
	<link href="css/ie8.css" rel="stylesheet" type="text/css"/>
	<![endif]-->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/modernizr.js"></script>
	

  </head>
  
  <body><form action="Tb_taotiServlet?f=update" method="post">
  		<div align="center">
  			套题名称：<input type="text" value="${taoti1.name }" name="taoName"><br><br>
  			<input type="hidden" name="id" value="${taoti1.id }">
  			所属课程： 
  			
  			<select name="lesName" style="height: 30">
  			<c:forEach items="${lesName }" var="lesName" >
  			<c:choose>
  			<c:when test="${taoti1.les.name eq lesName.name }">
  			<option value="${lesName.id }" selected="selected">${lesName.name }</option>
  			</c:when>
  			<c:otherwise>
  			<option value="${lesName.id }">${lesName.name }</option>
  			</c:otherwise>
  			</c:choose>
  			</c:forEach>
  			</select> 
  			<br><br>
  			<input type="submit" value="保存">&nbsp;&nbsp;&nbsp; <a href="Tb_taotiServlet?f=list"><input type="button" value="取消"></a>&nbsp;&nbsp;&nbsp;  <a href="Tb_taotiServlet?f=list"><input type="button" value="返回" ></a>
  			
  		</div>  
  		</form>
  </body>
</html>
