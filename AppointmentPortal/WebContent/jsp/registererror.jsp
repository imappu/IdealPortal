<%@ page language="java" isErrorPage="true" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #F0F8FF">

<div class="back">
<button type="button" id="back" onclick="goBack()" style="background-color: lightgray; color: white; border-radius: 8px;">Home</button>
		<script>
			function goBack() {
			window.open("../index.html");
			}
		</script>
</div>

<center>
<h2 ">Sorry ..</h2>
<p >Your registration is not completed</p>
<p >Please try again with valid credentials</p>
<table><tr><th><a href="../html/register.html"
style="
	width: 20%;
    background-color: #4CAF50;
    color: white;
    padding: 4px 3px;
    margin: 3px 0;
    border: none;
    border-radius: 3px;
    cursor: pointer; 
    text-decoration: none;
" 
target="_self">Try Again</a></th></tr></table>
</center>
</body>

</html>