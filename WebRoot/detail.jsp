<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sp.services.* " %>
<%@ page import="com.sp.entity.* " %>
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
  <script type="text/javascript">
  $(function(){
  		window.onload=function(){
  		var sel = $("#sel").val();
					if(sel=='单选题'){
						$("#dan").css("display","block");
						$("#duo").css("display","none");
					}
					else if(sel=='多选题'){
						$("#dan").css("display","none");
						$("#duo").css("display","block");
					}
  		};		
  		$("#sel").click(function(){
  		var sel = $(this).val();
					if(sel=='单选题'){
						$("#dan").css("display","block");
						$("#duo").css("display","none");
					}
					else if(sel=='多选题'){
						$("#dan").css("display","none");
						$("#duo").css("display","block");
					}
  		});
  		$("#refact").click(function(){
		    	var chk = $("input[name='answer']:checked");
		    	var chkValue = "";
		    	$(chk).each(function(){
		    		chkValue += $(this).val() +","; 
		    	});
		    	$("#f1").prop("href","Tb_questionsServlet?f=refact&answer="+chkValue);
		    	$("#f1").submit();
		    	//return true;
		    });
   
  });
  
  </script>

  </head>
  
   <body>
   <form action="Tb_questionsServlet?f=refact" id="f1" method="post">
    <div class="Mian-cont-wrap" style="margin-top:20">
    	<div class="defaultTab-T"><h5>s&nbsp;&nbsp; 当前位置：考试题目修改</h5></div>
						
						<table border="0" cellspacing="0" cellpadding="0" class="defaultTable defaultTable2">
							<tbody>
							
							<c:forEach items="${tbq}" var="t">
							<tbody>
							<input type="hidden" name="id" value="${t.id }">
							<tr>
							<td>所属课程：${t.tbl.name }${t.id }</td>
							</tr>
							<tr>
							<td>所属套题：${t.tbt.name }</td>
							</tr>
							<tr>
							<td>考试题目：<input type="text" name="title" value="${t.subject }"></td>
							</tr>
							<tr>
							<td>试题类型：
							<select name="subject" id="sel" >
							<c:if test="${t.type eq '单选题'}">
							<option value="单选题" selected="selected" >单选题</option>
							<option value="多选题">多选题</option>
							</c:if>
							<c:if test="${t.type eq '多选题'}">
							<option value="多选题" selected="selected">多选题</option>
							<option value="单选题">单选题</option></c:if>
							</select>
							</td>
							</tr>
							<tr>
							<td>选项A:<input type="text" name="optionA" value="${t.optionA }"></td>
							</tr>
							
							<tr>
							<td>选项b:<input type="text" name="optionB" value="${t.optionB }"></td>
							</tr>
							
							<tr>
							<td>选项c:<input type="text" name="optionC" value="${t.optionC }"></td>
							</tr>
							
							<tr>
							<td>选项d:<input type="text" name="optionD" value="${t.optionD }"></td>
							</tr>
							
							<tr>
							<td>正确答案：
							
							<div id="duo">
							<c:choose>
									<c:when test="${t.answerA eq true}">
										<input type="checkbox" value="A" id="answer" name="answers" checked="checked">A
									</c:when>
									<c:otherwise>
										<input type="checkbox" value="A" id="answer" name="answers">A
									</c:otherwise>
								</c:choose>
							    <c:choose>
									<c:when test="${t.answerB eq true}">
										<input type="checkbox" value="B" id="answer" name="answers" checked="checked">B
									</c:when>
									<c:otherwise>
										<input type="checkbox" value="B" id="answer" name="answers">B
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${t.answerC eq true}">
										<input type="checkbox" value="C" id="answer" name="answers" checked="checked">C
									</c:when>
									<c:otherwise>
										<input type="checkbox" value="C" id="answer" name="answers">C
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${t.answerD eq true}">
										<input type="checkbox" value="D" id="answer" name="answers" checked="checked">D
									</c:when>
									<c:otherwise>
										<input type="checkbox" value="D" id="answer" name="answers">D
									</c:otherwise>
								</c:choose>
								</div>
								
							<div id="dan" >
							<select id="one" name="answer">
								<c:choose>
									<c:when test="${t.answerA eq true}">
										<option selected="selected" value="A">A</option>
									</c:when>
									<c:otherwise>
										<option value="A">A</option>
									</c:otherwise>
								</c:choose>
									<c:choose>
									<c:when test="${t.answerB eq true}">
										<option selected="selected" value="B">B</option>
									</c:when>
									<c:otherwise>
										<option value="B">B</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${t.answerC eq true}">
										<option selected="selected" value="C">C</option>
									</c:when>
									<c:otherwise>
										<option value="C">C</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${t.answerD eq true}">
										<option selected="selected" value="D">D</option>
									</c:when>
									<c:otherwise>
										<option value="D">D</option>
									</c:otherwise>
								</c:choose>
								</select>
							</div>
							
							</td>
							</tr>
							
							<tr>
							<td>备注：<input type="text" name="note" value="${t.note }"></td>
							</tr>
							
							<tr>
							<td>
							<input type="submit" value="保存">
							<input type="reset" value="取消">
							<input type="button" value="返回">
							</td>
							</tr>
							</tbody>
							</c:forEach>
						</table>
						
						<!--pages S-->
						
						<!--pages E-->
					</div>
					</form>
  </body>
</html>
