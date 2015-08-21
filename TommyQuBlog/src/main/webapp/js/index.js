/**
 * 
 */
var reponseText, arr;
var xmlhttp=null;

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
			alert("Login successfully!");
		}
		else
			alert("Incorrect login name or password!");
			
	}
}