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
	<title>New Post</title>
	<%@ include file="global/linker.jsp"%>
	<link rel="stylesheet" href="<%=path%>/css/newPost.css">
	<link rel="stylesheet" href="<%=path%>/css/bootstrap-multiselect.css">
</head>
<body>
	<%@ include file="global/header.jsp"%>
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
					<!-- <input type="text" class="form-control" id="category-input"> -->
					<select id="category-select" multiple="multiple">
						<option value="1">Option 1</option>
						<option value="2">Option 6</option>
					</select>
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
		<%-- <p>${sessionScope.user.userName}</p> --%>
	</div>
	<%@ include file="global/footer.jsp"%>
	<script type="text/javascript" src="<%=path%>/js/global.js"></script>
	<script type="text/javascript" src="<%=path%>/js/bootstrap-multiselect.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#category-select").multiselect({
			maxHeight:200,
			numberDisplayed:5
		});
	});
	</script>
</body>
<%@ include file="global/footerLoginJS.jsp"%>
</html>
