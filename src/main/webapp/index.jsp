<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ taglib  uri="http://java.sun.com/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>MyBatis 整合  Spring 3.0.5</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/springmvc/main.css" />
  </head>
  
  <body>
  		<h3>MyBatis 3.0.4  整合  Spring 3.0.5</h3>
    	<a href="account/list.shtml">查询所有</a><br/>
    	<a href="account/add.shtml?username=abcdef&password=123132&status=2&flag=1111">添加</a><br/>
    	<a href="account/get.shtml?id=50649">查询</a><br/>
    	<a href="user/list">查询</a><br/>
    	
    	<h3>用户管理</h3>
    	<div class="userlist"></div>
  </body>
<script type="text/javascript" src="/springmvc/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/springmvc/js/juicer.js"></script>
<script type="text/javascript" src="/springmvc/js/tool.js"></script>
<script type="text/javascript" src="/springmvc/js/template.js"></script>
</html>
