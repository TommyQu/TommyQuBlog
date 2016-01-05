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
					<a href="page/showBlogPage.do?pageNum=1&categoryId=" class="list-group-item active" id="all-list-item">All</a>
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
				<li><a href="page/showBlogPage.do?pageNum=1&categoryId=">1</a></li>
			</ul>
		</div>
	</div>
	<%@ include file="global/footer.jsp"%>
	<script type="text/javascript" src="<%=path%>/js/global.js"></script>
	<script type="text/javascript" src="<%=path%>/js/blog.js"></script>
</body>
<%@ include file="global/footerLoginJS.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	
	var query = window.location.search.substring(1);
	query = query.substring(query.indexOf("&"), query.length);
	var categoryId = query.substring(query.indexOf("=")+1, query.length);
	
	var postSimpleInfoListJson = ${postSimpleInfoListJson};
	var categoryInfoListJson = ${categoryInfoListJson};
	var totalPageNum = ${totalPageNum};
	var currentPageNum = ${currentPageNum};
	
	var blogListGroup = document.getElementById("blog-list-group");
	var categoryListGroup = document.getElementById("category-list-group");
	var pageUl = document.getElementById("page-ul");
	
	for(var i=0;i<postSimpleInfoListJson.length;i++) {
		blogListGroup.innerHTML+="<a href=\"page/showSinglePostPage.do?postId="+postSimpleInfoListJson[i].postId+"\" class=\"list-group-item\"><h4 class=\"list-group-item-heading\">"+postSimpleInfoListJson[i].postTitle+"</h4><p class=\"list-group-item-text\">By: "+postSimpleInfoListJson[i].userName+"    On: "+postSimpleInfoListJson[i].postTime+"</p></a>";
	}
	
	//Based on category active according list item
	for(var i=0;i<categoryInfoListJson.length;i++) {
		if(categoryInfoListJson[i].categoryId == categoryId) {
			$("#all-list-item").removeClass("active");
			categoryListGroup.innerHTML+="<a href=\"page/showBlogPage.do?pageNum=1&categoryId="+categoryInfoListJson[i].categoryId+"\" class=\"list-group-item active\">"+categoryInfoListJson[i].categoryName+"</a>";
		}
		else {
			categoryListGroup.innerHTML+="<a href=\"page/showBlogPage.do?pageNum=1&categoryId="+categoryInfoListJson[i].categoryId+"\" class=\"list-group-item\">"+categoryInfoListJson[i].categoryName+"</a>";
		}
	}
	for(var i=2;i<=totalPageNum;i++) {
		pageUl.innerHTML+="<li><a href=\"page/showBlogPage.do?pageNum="+i+"\">"+i+"</a></li>";
	}
	
	//Active the a specific category list item
	
	//Active current page li
	$("#page-ul li:nth-child("+currentPageNum+")").addClass("active");

	
});
</script>
</html>
