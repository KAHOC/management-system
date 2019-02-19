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
	<script>
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
		    	$(this).prop("href","Tb_taotiServlet?f=del&id="+chkValue);
		    	return true;
		    });
	  });
	
	</script>
  </head>
  
  <body>
    <div class="Mian-cont-wrap" style="margin-top:20">
    	<div class="defaultTab-T"><h5>&nbsp;&nbsp;&nbsp;当前位置：管理员信息管理</h5></div>
						<div class="defaultTab-T">
							<table border="0" cellspacing="0" cellpadding="0" class="defaultTable">
								<tbody><tr><th class="t_1">套题名称</th><th class="t_2">所说课程</th><th class="t_3">加入时间</th><th class="t_4">修改</th><th class="t_4">选项</th></tr>
							</tbody></table>
						</div>
						<table border="0" cellspacing="0" cellpadding="0" class="defaultTable defaultTable2">
							<tbody>
							<c:forEach items="${daolist}" var="daolist">
							<tr>
								<td class="t_1">${daolist.name }</td>
								<td class="t_2">${daolist.les.name}</td>
								<td class="t_3">${daolist.joinTime}</td>
								<td class="t_4"><a href="Tb_taotiServlet?f=sel&id=${daolist.id}" class="modify">修改</a></td>
								<td class="t_4"><input type="checkbox" name="chkInfo" value="${daolist.id}" ></td>
								
							</tr>
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
