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
	<%@ include file="global/linker.jsp"%>
</head>
<body>
	<%@ include file="global/header.jsp"%>
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
					<p>Mobile and web development</p>
				</div>
			</div>
			<div class="col-md-4">
				<div class="intro-icon-div">
					<img alt="" src="img/hobby.png" height="82" width="82">
				</div>
				<div class="intro-text-div">
					<h3 class="intro-text-h3">What I Like</h3>
					<p>Singing, Playing computer games</p>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="global/footer.jsp"%>
	<script type="text/javascript" src="<%=path%>/js/global.js"></script>
	<script type="text/javascript" src="<%=path%>/js/index.js"></script>
</body>
<%@ include file="global/footerLoginJS.jsp"%>
<script type="text/javascript">
</script>
</html>
