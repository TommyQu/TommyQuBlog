<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
	<base href="<%=basePath%>">
	<title>About Me</title>
	<%@ include file="global/linker.jsp"%>
</head>
<body>
	<%@ include file="global/header.jsp"%>
	<div class="container">
		<h3>About Me</h3>
		<p></p>
	</div>
	<%@ include file="global/footer.jsp"%>
	<script type="text/javascript" src="<%=path%>/js/global.js"></script>
</body>
<%@ include file="global/footerLoginJS.jsp"%>
<script type="text/javascript">
</script>
</html>