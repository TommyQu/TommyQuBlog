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
	<div class="container">
		<h2>Blog List</h2>
		<div class="list-group" id="post-list-group">
<!-- 			<a href="#" class="list-group-item active">First item</a>
			<a href="#" class="list-group-item">Second item</a>
			<a href="#" class="list-group-item">Third item</a> -->
		</div>
	</div>
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
	var postListJson = ${postListJson};
	var postListGroup = document.getElementById("post-list-group");
	for(var i=0;i<postListJson.length;i++) {
		postListGroup.innerHTML+="<a href=\"#\" class=\"list-group-item\">"+postListJson[i].postTitle+"</a>";
	}
});
</script>
</html>
