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
	<%@ include file="global/linker.jsp"%>
	<script src="//cdn.ckeditor.com/4.5.3/standard/ckeditor.js"></script>
	<link rel="stylesheet" href="<%=path%>/css/singlePost.css">
</head>
<body>
	<%@ include file="global/header.jsp"%>
	<div class="container">
		<br>
		<h2>${postInfo.postTitle}</h2>
		<hr id="post-hr">
		<p class="post-subtitle" style="white-space:pre">By: ${postInfo.userName}    On: ${postInfo.postTime}</p>
		<textarea name="postContent" id="post-content" rows="10" cols="80" readonly>
			${postInfo.postContent}
		</textarea>
		<br>
	</div>
	<%@ include file="global/footer.jsp"%>
	<script type="text/javascript" src="<%=path%>/js/global.js"></script>
</body>
<%@ include file="global/footerLoginJS.jsp"%>
<script type="text/javascript">
CKEDITOR.replace( "post-content", {
	uiColor: "#F5F5F5"
});
$(document).ready(function(){
	CKEDITOR.on('instanceReady', function() {
		$("#cke_1_top").remove();
		$("#cke_1_bottom").remove();
	});
});
</script>
</html>
