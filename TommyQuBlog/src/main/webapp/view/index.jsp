<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
	<base href="<%=basePath%>">
	<title>Tommy Qu's Blog</title>
	<%@ include file="linker.jsp"%>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="intro-icon-div">
					<img alt="" src="img/person.png" height="82" width="82">
				</div>
				<div class="intro-text-div">
					<h3 class="intro-text-h3">Who I Am</h3>
					<p>I come from China</p>
				</div>
			</div>
			<div class="col-md-4">
				<div class="intro-icon-div">
					<img alt="" src="img/business.png" height="82" width="82">
				</div>
				<div class="intro-text-div">
					<h3 class="intro-text-h3">What I Do</h3>
				</div>
			</div>
			<div class="col-md-4">
				<div class="intro-icon-div">
					<img alt="" src="img/hobby.png" height="82" width="82">
				</div>
				<div class="intro-text-div">
					<h3 class="intro-text-h3">What I Like</h3>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=path%>/js/global.js"></script>
	<script type="text/javascript" src="<%=path%>/js/index.js"></script>
	<%@ include file="footer.jsp"%>
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
});
</script>
</html>
