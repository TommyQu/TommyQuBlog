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
	<script src="http://cdn.ckeditor.com/4.5.2/standard-all/ckeditor.js"></script>
	<link rel="stylesheet" href="<%=path%>/css/newPost.css">
	<link rel="stylesheet" href="<%=path%>/css/bootstrap-multiselect.css">
</head>
<body>
	<%@ include file="global/header.jsp"%>
	<div class="container">
		<h2>New post:</h2>
		<form class="form-horizontal" role="form" id="new-post-form" action="javascript:newPost()">
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
					<select name="categorySelect" id="category-select" multiple="multiple">
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="post-content">Post content:</label>
				<div class="col-sm-10">
					<textarea name="postContent" id="post-content" rows="300" cols="80">
					</textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</form>
	</div>
	<%@ include file="global/footer.jsp"%>
	<script type="text/javascript" src="<%=path%>/js/global.js"></script>
	<script type="text/javascript" src="<%=path%>/js/bootstrap-multiselect.js"></script>
	<script type="text/javascript">
	CKEDITOR.replace( "post-content", {
		uiColor: "#F5F5F5",
		extraPlugins: 'autogrow',
		autoGrow_minHeight: 200,
		autoGrow_maxHeight: 600,
		autoGrow_bottomSpace: 50,
		removePlugins: 'resize'
	});
	
	$(document).ready(function(){
		var categoryInfoListJson = ${categoryInfoListJson};
 		var categorySelect = document.getElementById("category-select");
		for(var i=0;i<categoryInfoListJson.length;i++) {
			var option = document.createElement("option");
			option.value = JSON.stringify(categoryInfoListJson[i]);
			option.text = categoryInfoListJson[i].categoryName;
			categorySelect.appendChild(option);
		}
		$("#category-select").multiselect({
			maxHeight:200,
			numberDisplayed:5
		});
	});
	</script>
	<script type="text/javascript" src="<%=path%>/js/newPost.js"></script>
</body>
<%@ include file="global/footerLoginJS.jsp"%>
</html>
