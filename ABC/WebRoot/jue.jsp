<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WRC
  Date: 2021/1/21
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="css/dtree.css"  media="all">
   <link rel="stylesheet" href="<%=basePath %>layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath %>css/dtreefont.css">
	<link rel="stylesheet" href="<%=basePath %>css/public.css" media="all" />
	<link rel="stylesheet" href="<%=basePath %>dtree/dtree.css">
  	<link rel="stylesheet" href="<%=basePath %>dtree/font/dtreefont.css">
    
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
		


<script type="text/javascript" src="lay/dtree.js"></script>
<script type="text/javascript" src="lay/dtree.js"></script>
<!-- <script type="text/javascript" src="lay/userlist.js"></script> -->
<script type="text/javascript" src="lay/jquery-1.12.4.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
		
		<div id="di">
		<div id="toolbarDemo" style="display: none;">
			<c:forEach items="${zhi}" var="i"> 
				${i.mbth}
			</c:forEach>
		</div>  
		<table id="test"  lay-filter="newsList"></table>
		</div>
		
	

</body>

</html>
