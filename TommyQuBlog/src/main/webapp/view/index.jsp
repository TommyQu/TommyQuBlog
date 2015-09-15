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
	<link rel="stylesheet" href="<%=path%>/css/index.css">
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
					<p class="intro-text-p">Hello, my name is Haotian Qu, you can call me Tommy. Currently, 
					I'm pursuing my master's degree of Computer Science in The George Washington University. 
					I like programming. Now, I'm focusing on mobile development.</p>
				</div>
			</div>
			<div class="col-md-4">
				<div class="intro-icon-div">
					<img alt="" src="img/business.png" height="82" width="82">
				</div>
				<div class="intro-text-div">
					<h3 class="intro-text-h3">What I Do</h3>
					<p class="intro-text-p">I have been studying programming for 5 years. I learned a lot of
					programming languages during the past years such as C, C++, C#, Java, HTML, CSS, JavaScript.
					Java is my favorite. Although I have more experience in web development, I'm eager to learn
					more about mobile development.</p>
				</div>
			</div>
			<div class="col-md-4">
				<div class="intro-icon-div">
					<img alt="" src="img/hobby.png" height="82" width="82">
				</div>
				<div class="intro-text-div">
					<h3 class="intro-text-h3">What I Like</h3>
					<p class="intro-text-p">Singing is my favorite hobby. When I was in college, I joined our
					college's chorus. I'm the bass minister. Playing computer games is another my favorite hobby.
					I like Warcraft3, Dota, Diablo. Speaking of Warcraft3, I have a deep emotion with this game.
					I have been playing it for about 10 years.</p>
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
