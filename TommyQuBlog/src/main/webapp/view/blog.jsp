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
	<%@ include file="global/linker.jsp"%>
	<link rel="stylesheet" href="<%=path%>/css/blog.css">
</head>
<body>
	<%@ include file="global/header.jsp"%>
	<div class="container">
		<h2>Blog List</h2>
		<div class="list-group" id="post-list-group">
		</div>
		<div class="page-div">
			<ul class="pagination page-ul">
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
	<%@ include file="global/footer.jsp"%>
	<script type="text/javascript" src="<%=path%>/js/global.js"></script>
</body>
<%@ include file="global/footerLoginJS.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	var postSimpleInfoListJson = ${postSimpleInfoListJson};
	var postListGroup = document.getElementById("post-list-group");
	for(var i=0;i<postSimpleInfoListJson.length;i++) {
		postListGroup.innerHTML+="<a href=\"page/showSinglePostPage.do?postId="+postSimpleInfoListJson[i].postId+"\" class=\"list-group-item\"><h4 class=\"list-group-item-heading\">"+postSimpleInfoListJson[i].postTitle+"</h4><p class=\"list-group-item-text\">By: "+postSimpleInfoListJson[i].userName+"    On: "+postSimpleInfoListJson[i].postTime+"</p></a>";
	}
});
</script>
</html>
