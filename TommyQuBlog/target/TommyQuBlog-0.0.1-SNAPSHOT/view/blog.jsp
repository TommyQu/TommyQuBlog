<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	var postSimpleInfoListJson = ${postSimpleInfoListJson};
	var postListGroup = document.getElementById("post-list-group");
	for(var i=0;i<postSimpleInfoListJson.length;i++) {
		postListGroup.innerHTML+="<a href=\"page/showSinglePostPage.do?postId="+postSimpleInfoListJson[i].postId+"\" class=\"list-group-item\"><h4 class=\"list-group-item-heading\">"+postSimpleInfoListJson[i].postTitle+"</h4><p class=\"list-group-item-text\">By: "+postSimpleInfoListJson[i].userName+"    On: "+postSimpleInfoListJson[i].postTime+"</p></a>";
	}
});
</script>
</html>
