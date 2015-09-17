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
		<br>
		<div class="row">
			<div class="col-md-3">
					<h2 id="category-h2"><img alt="" src="img/category.png"> Category List</h2>
				<div class="list-group" id="category-list-group">
					<a href="#" class="list-group-item active">All</a>
				</div>
			</div>
			<div class="col-md-9">
				<h2>Blog List</h2>
				<div class="list-group" id="blog-list-group">
				</div>
			</div>
		</div>

		<div class="page-div">
			<ul class="pagination page-ul" id="page-ul">
				<li><a href="page/showBlogPage.do?pageNum=1">1</a></li>
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
	var categoryNameListJson = ${categoryNameListJson};
	var totalPageNum = ${totalPageNum};
	var currentPageNum = ${currentPageNum};
	
	var blogListGroup = document.getElementById("blog-list-group");
	var categoryListGroup = document.getElementById("category-list-group");
	var pageUl = document.getElementById("page-ul");
	
	for(var i=0;i<postSimpleInfoListJson.length;i++) {
		blogListGroup.innerHTML+="<a href=\"page/showSinglePostPage.do?postId="+postSimpleInfoListJson[i].postId+"\" class=\"list-group-item\"><h4 class=\"list-group-item-heading\">"+postSimpleInfoListJson[i].postTitle+"</h4><p class=\"list-group-item-text\">By: "+postSimpleInfoListJson[i].userName+"    On: "+postSimpleInfoListJson[i].postTime+"</p></a>";
	}
	for(var i=0;i<categoryNameListJson.length;i++) {
		categoryListGroup.innerHTML+="<a href=\"#\" class=\"list-group-item\">"+categoryNameListJson[i]+"</a>";
	}
	for(var i=2;i<=totalPageNum;i++) {
		pageUl.innerHTML+="<li><a href=\"page/showBlogPage.do?pageNum="+i+"\">"+i+"</a></li>";
	}
	
	//Active current page li
	$("#page-ul li:nth-child("+currentPageNum+")").addClass("active");
	
});
</script>
</html>
