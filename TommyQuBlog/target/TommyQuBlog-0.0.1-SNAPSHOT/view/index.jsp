<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
	<base href="<%=basePath%>">
	<title>Tommy Qu's Blog</title>
	<%@ include file="linker.jsp"%>
</head>
<body>
	<%@ include file="header.jsp"%>
	<script type="text/javascript" src="<%=path%>/js/global.js"></script>
	<script type="text/javascript" src="<%=path%>/js/index.js"></script>
</body>
<script type="text/javascript">
$(document).ready(function(){
	var user = "${sessionScope.user}";
	if(user) {
		$("#sign-up-li").hide();
		$("#log-in-li").hide();
		$("#sign-out-li").show();
		$("#new-post-li").show();
	}
	else {
		$("#sign-out-li").hide();
		$("#new-post-li").hide();
	}
});
</script>
</html>
