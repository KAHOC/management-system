<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sp.services.* " %>
<%@ page import="com.sp.entity.* " %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <head>
    <link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/page.css">
	<!--[if lte IE 8]>
	<link href="css/ie8.css" rel="stylesheet" type="text/css"/>
	<![endif]-->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/modernizr.js"></script>
  	<script type="text/javascript" >
	
	$(function(){
	  $("#selAll").click(function(){
		  if(this.checked){
			  $('input[type=checkbox][name=chkInfo]').prop("checked",true);
			  }else{
				  $('input[type=checkbox][name=chkInfo]').prop("checked",false);
				  }
		  });
		  
	  $('[name=chkInfo]:checkbox').click(function(){
		  var $tmp=$('[name=chkInfo]:checkbox');
		  $("#selAll").prop('checked',$tmp.length==$tmp.filter(':checked').length);
		  });
	  
	  $("#send").click(function(){
		  $('[name=chkInfo]:checkbox').each(function() {
            this.checked=!this.checked;
        });
    });
		  
		    
	  });
	
	</script>

  </head>
  </head>
   <body>
    <div class="Mian-cont-wrap" style="margin-top:20">
    	<div class="defaultTab-T"><h5>&nbsp;&nbsp;&nbsp;当前位置：考生信息管理</h5></div>
						<div class="defaultTab-T">
							<table border="0" cellspacing="0" cellpadding="0" class="defaultTable " >
								<tbody><tr><th class="t_5">所属课程</th><th class="t_7">套题名称</th><th class="t_6">考试题目</th><th class="t_8">考试类型</th><th class="t_9">修改</th><th class="t_9">选项</th></tr>
							</tbody></table>
						</div>
						<table border="0" cellspacing="0" cellpadding="0" class="defaultTable defaultTable2">
							<tbody>
							<c:forEach items="${tbq }" var="t">
							<tbody><tr>
							
							<th class="t_5">${t.tbl.name }</th>
							<th class="t_7">${t.tbt.name }</th>
							<th class="t_6">${t.subject }</th>
							<th class="t_8">${t.type }</th>
							<th class="t_9"><a href="Tb_questionsServlet?f=detail&id=${t.id  }">修改</a></th>
							<th class="t_9"><input type="checkbox" name="chkInfo" value="${t.id }"/></th></tr>
							</c:forEach>
							
						</tbody></table>
						
						<!--pages S-->
						
						<!--pages E-->
					</div>
					<div align="right" class="defaultTable defaultTable2">
					<input type="checkbox" id="selAll">全选
					<a href="#" id="send">反选</a>
					<a href="#" id="del">删除</a>
					</div>
  </body>
 
</html>
