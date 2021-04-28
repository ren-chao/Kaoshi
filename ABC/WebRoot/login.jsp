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
	  <form action="/ABC/jue?action=login" method="post" class="layui-form">
    	账号:<input type="text" name="username" class="username"><br>
    	密码:<input type="password" name="password" class="password"><br>
    <input type="submit" value="登录" id="tijaio">
  </form>

</body>
</html>
