var reponseText, arr;
var xmlhttp=null;

function newPost() {
	var postTitle = document.getElementById("post-title").value;
	var categorySelect = document.getElementById("category-select");
	var postContent = document.getElementById("post-content").value;
	var categoryString = "";
	
	for(var i=0;i<categorySelect.length;i++) {
		if(categorySelect.options[i].selected) {
			categoryString += categorySelect.options[i].value+",";
		}
	}
	if(categoryString == "")
		categoryString += "1";
	if(postTitle == "" || postContent == "")
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
			xmlhttp.open("post","post/newPost.do?postTitle="+postTitle+"&postContent="+postContent+"&categoryString="+categoryString,false);
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
			alert("Create new post successfully!");
			window.location.href = "page/showBlogPage.do?pageNum=1&categoryId=";
		}
		else
			alert("Create new post failed!");
			
	}
}