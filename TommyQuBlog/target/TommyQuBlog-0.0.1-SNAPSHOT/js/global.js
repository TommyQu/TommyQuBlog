/**
 * Project: TommyQuBlog
 * Comments: Global required javascript code
 * JDK Version Used: JDK 1.7
 * Author: Tommy Qu
 * Created Date: 08/20/2015
 * Modified By:
 * Modified Date:
 * Why is modified:
 */

var reponseText, arr;
var xmlhttp=null;

$(document).ready(function(){
	$(".navbar-nav > li").hover(
		function(){
			$(this).css({
				"background-color": "#222",
				"font-size": "16px",
				"text-shadow": "1px 1px 2px black, 0 0 25px white, 0 0 15px white"
			});
			
		}, function(){
			$(this).css({
				"background-color":"#222",
				"font-size":"14px",
				"text-shadow": ""
			});
	});
});

function userLogin() {
	var userLoginName = document.getElementById("user-login-name").value;
	var userPwd = document.getElementById("user-pwd").value;
	
	if(userLoginName == "" || userPwd == "")
		alert("Please fill required fields!");
	else {
		if (window.XMLHttpRequest) {
			xmlhttp=new XMLHttpRequest();
		}
		else {// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlhttp!=null) {
			xmlhttp.onreadystatechange=state_change;
			xmlhttp.open("post","user/login.do?userLoginName="+userLoginName+"&userPwd="+userPwd,false);
			xmlhttp.send();
		}
		else {
			alert("Your browser doesn't support XMLHttpRequest!");
		}
	}
}

function state_change() {
	if (xmlhttp.readyState==4 && xmlhttp.status==200) {
		reponseText = xmlhttp.responseText;
		if(reponseText == "true") {
			$("#loginModal").modal("hide");
			$("#sign-up-li").hide();
			$("#login-in-li").hide();
			$("#sign-out-li").show();
			$("#new-post-li").show();
			alert("Login successfully!");
			location.reload();
		}
		else
			alert("Incorrect login name or password!");
			
	}
}