<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
	<base href="<%=basePath%>">
	<title>About Me</title>
	<%@ include file="global/linker.jsp"%>
	<link rel="stylesheet" href="<%=path%>/css/aboutMe.css">
</head>
<body>
	<%@ include file="global/header.jsp"%>
	<div class="container">
		<br>
		<h3>About Me</h3>
		<br>
		<div class="row">
			<div class="col-md-3">
				<img alt="" src="img/myphoto-1.png" height="150px">
			</div>
			<div class="col-md-9" id="about-intro-div">
				<h4>Hey guys, welcome to my blog. </h4>
				<br>
				<h4>
					<img alt="" src="img/linkedin-logo.png" height="20px"> Linked in: 
					<a href="https://www.linkedin.com/in/haotianqu">
						https://www.linkedin.com/in/haotianqu
					</a>
				</h4>
				<h4><img alt="" src="img/github-logo.png" height="20px"> Github: 
					<a href="https://github.com/TommyQu">
						https://github.com/TommyQu
					</a>
				</h4>
			</div>
		</div>
		<br>
		<div class="row" id="sec-about-row">
			<p>My name is Haotian Qu, you can call me Tommy. Currently, I'm pursuing my master's degree 
					in The George Washington University major in Computer Science. I like programming. 
					I'm proficient in <b>web and mobile development</b>.</p>
			<p>I have been studying programming for 5 years. I learned a lot of
					programming languages during the past years such as C, C++, C#, Java, HTML, CSS, JavaScript.
					<b>Java and Objective-C</b> are my favorite programming languages. Although I have more 
					experience in web development, I'm eager to learn more about mobile development.</p>
			<p>Singing is my favorite hobby. When I was in college, I joined our
				college's chorus. I'm the bass minister. Playing computer games is another my favorite hobby.
				I like Warcraft3, Dota, Diablo. Speaking of Warcraft3, I have a deep emotion with this game.
				I have been playing it for about 10 years. On 2012's summer, I participated in WCG. However,
				I lost in the first round :(</p>
			<p>Here is one of my match I found on the YouTube. The blue Human with ID: SFC.sky8_XimiLu is me.
				However, Fzu_Galaxy is my commonly used Id.</p>
			<iframe width="640" height="360" src="https://www.youtube.com/embed/sZ8_1VnQtrI" frameborder="0" allowfullscreen></iframe>
		</div>
	</div>
	<%@ include file="global/footer.jsp"%>
	<script type="text/javascript" src="<%=path%>/js/global.js"></script>
</body>
<%@ include file="global/footerLoginJS.jsp"%>
<script type="text/javascript">
</script>
</html>