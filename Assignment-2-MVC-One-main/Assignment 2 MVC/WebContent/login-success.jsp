<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="login.LoginBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserOne's page</title>
</head>
<body>

	<p>Login Success</p>

	<%
	LoginBean bean = (LoginBean) request.getAttribute("bean");

	String userOne = bean.getName();

	out.print("Welcome! " + userOne);
	%>

</body>
</html>