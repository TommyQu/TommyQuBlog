<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
	<base href="<%=basePath%>">
	<title>View Blogs</title>
	<%@ include file="linker.jsp"%>
</head>
<body>
	<%@ include file="header.jsp"%>
	<script type="text/javascript" src="<%=path%>/js/global.js"></script>
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
