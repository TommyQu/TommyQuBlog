<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
	<base href="<%=basePath%>">
	<title>Single Post</title>
	<%@ include file="linker.jsp"%>
	<link rel="stylesheet" href="<%=path%>/css/singlePost.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<h2>${postInfo.postTitle}</h2>
		<p class="post-subtitle" style="white-space:pre">By: ${postInfo.userName}    On: ${postInfo.postTime}</p>
		<input type="text" value="3" class="field left" readonly>
	</div>
	<script type="text/javascript" src="<%=path%>/js/global.js"></script>
</body>
<script type="text/javascript">
$(document).ready(function() {
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
