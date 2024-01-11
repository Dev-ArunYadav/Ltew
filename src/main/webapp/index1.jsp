<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	display: grid;
	place-items: center;
	font-family: "sans-serif";
	background: #0f344f;
	position: relative;
}

h1 {
	position: relative;
	top: 12vh;
	font-size: 72px;
	text-transform: uppercase;
	background: linear-gradient(90deg, #4776e6 0%, #e954e2 75%);
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
}

h2 {
	position: relative;
	top: 0;
	font-size: 30px;
	background: aqua;
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
}

button {
	position: relative;
	top: 20vh;
	font-size: 28px;
	width: 200px;
	height: 60px;
	border-radius: 20px;
	background: Green;
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
}
</style>
</head>
<body>
	<div class="app-logo">
		<img alt="" src="image/logo.png">
	</div>
	<h1>LTEW</h1>
	<h2>For Hunger</h2>
	<a href="index.jsp" class="button"><button>Get Started</button></a>
</body>
</html>