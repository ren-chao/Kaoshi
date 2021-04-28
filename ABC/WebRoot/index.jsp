<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	if(request.getSession().getAttribute("zhi")==null){
			out.print("<script>location.href = '"  + "http://localhost:8080/ABC/sta?action=seleLeft'</script>");
	}

 %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Title</title>
 <link rel="stylesheet" href="<%=basePath %>layui/css/layui.css">
</head>
<body class="layui-layout-body">
<script type="text/javascript" src="lay/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>lib/layui-v2.5.5/layui.js"></script>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">layui 管理布局</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="">商品管理</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="">退了</a></li>
			</ul>
		</div>
		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<c:forEach items="${zhi}" var="i">
						<li class="layui-nav-item layui-nav-itemed">
						<c:if test="${i.type==1}">
								<a class="" href="javascript:;">${i.name}</a>

								<dl class="layui-nav-child">
									<c:forEach items="${zhi}" var="j">
										<c:if test="${i.id==j.fid}">
											<dd>
												<a href="javascript:;" onclick="cl('${j.path}',${j.fid},${j.id},'${j.mbth}')" layuimini-href="sjhjsahf" id="doSubmit1">${j.name}</a>
											</dd>
										</c:if>
									</c:forEach>
								</dl>
							</c:if></li>
					</c:forEach>


					<%--</dl>--%>
					<li class="layui-nav-item"><a href="">云市场</a></li>
					<li class="layui-nav-item"><a href="">发布商品</a></li>
				</ul>
			</div>
		</div>
		<div class="layui-body" id="di">
			<!-- 内容主体区域 -->
			<!-- <table class="layui-hide" id="test"></table> -->
		
	</div>
	</div>
	<%-- <c:if></c:if> --%>
	
	</body>
	<div style="height: 400px; overflow: auto; display: none;" id="dtree1" >
	  <ul id="dataTree3" class="dtree" data-id="0"></ul>
</div>
 <c:if test="${us==null}">
 	<jsp:forward page="login.jsp"></jsp:forward>
 </c:if>
<script src="lay/left.js"></script>
