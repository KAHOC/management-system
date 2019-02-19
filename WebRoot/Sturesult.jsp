<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
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
    	<div class="defaultTab-T"><h5>&nbsp;&nbsp;&nbsp;当前位置：考生成绩查询</h5></div>
    	
						<div class="defaultTab-T">
						 <form action="Tb_sturesultServlet?f=select" method="post" style="padding: 12">查询条件：&nbsp;&nbsp;
   							<select name="seltype" style="height: 30">
		     					<option value="1">准考证号</option>
		     					<option value="2">所属课程</option>
		     					<option value="3">考试时间</option>
		    				 </select>&nbsp;&nbsp;关键字:
		    				 <input type="text" name="select"><input type="submit" value="查询">
  						</form>
							<table border="0" cellspacing="0" cellpadding="0" class="defaultTable " >
								<tbody><tr><th class="t_8">准考证号</th>
								<th class="t_5">所属课程</th>
								<th class="t_8">考试时间</th>
								<th class="t_1">单选题分数</th>
								<th class="t_1">多选题分数</th>
								<th class="t_1">合计分数</th>
								
							</tbody></table>
						</div>
						<table border="0" cellspacing="0" cellpadding="0" class="defaultTable defaultTable2">
							<tbody>
							<c:forEach items="${srlist}" var="srlist">
							<tbody><tr><th class="t_8">${srlist.stuId}</th>
							<th class="t_5">${srlist.lson.name }</th>
							<th class="t_8">${srlist.joinTime }</th>
							<th class="t_1">${srlist.resSingle }</th>
							<th class="t_1">${srlist.resMore }</th>
							<th class="t_1">${srlist.resTotal }</th>
							</tr>
							</c:forEach>
						</tbody></table>
						<!--pages S-->
						<!--pages E-->
					</div>
					
  </body>
</html>
