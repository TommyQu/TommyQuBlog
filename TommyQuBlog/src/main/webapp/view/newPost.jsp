<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
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
	<title>New Post</title>
	<%@ include file="linker.jsp"%>
	<link rel="stylesheet" href="<%=path%>/css/newPost.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<h2>New post:</h2>
		<form class="form-horizontal" role="form" id="new-post-form" action="post/newPost.do">
			<div class="form-group">
				<label class="control-label col-sm-2" for="post-title" id="post-title-label">Post title:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="postTitle" id="post-title" placeholder="Enter post title">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="category-input" id="category-label">Categories:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="category-input">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="post-content">Post content:</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="5" id="post-content" name="postContent"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
