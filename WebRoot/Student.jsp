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
		   $("#del").click(function(){
		    	var chk = $("input[name='chkInfo']:checked");
		    	var chkValue = "";
		    	$(chk).each(function(){
		    		chkValue += $(this).val() +","; 
		    	});
		    	$(this).prop("href","Tb_studentServlet?f=del&id="+chkValue);
		    	return true;
		    });
	  });
	
	</script>
  

  </head>
  
  <body>
    <div class="Mian-cont-wrap" style="margin-top:20">
    	<div class="defaultTab-T"><h5>&nbsp;&nbsp;&nbsp;当前位置：考生信息管理</h5></div>
						<div class="defaultTab-T">
							<table border="0" cellspacing="0" cellpadding="0" class="defaultTable " >
								<tbody><tr><th class="t_5">准考证号</th><th class="t_1">考生名字</th><th class="t_7">性别</th><th class="t_8">加入时间</th><th class="t_1">密码问题</th><th class="t_5">身份证号</th><th class="t_7">选项</th></tr>
							</tbody></table>
						</div>
						<table border="0" cellspacing="0" cellpadding="0" class="defaultTable defaultTable2">
							<tbody>
							<c:forEach items="${slist}" var="slist">
							<tbody><tr><th class="t_5">${slist.id}</th>
							<th class="t_1">${slist.name }</th>
							<th class="t_7">${slist.sex }</th>
							<th class="t_8">${slist.joinTime }</th>
							<th class="t_1">${slist.question }</th>
							<th class="t_5">${slist.cardNo }</th>
							<th class="t_7"><input type="checkbox" name="chkInfo" value="${slist.id}"/></th></tr>
							</c:forEach>
						</tbody></table>
						<!--pages S-->
						<!--pages E-->
					</div>
					<div align="right" style="padding-right: 20">
					<input type="checkbox" id="selAll">[全选/全不选] <a href="#" id="send">[反选]</a>&nbsp;&nbsp;<a href="#" id="del">[删除] &nbsp;&nbsp;</a>
					</div>
  </body>
</html>
