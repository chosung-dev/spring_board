<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Main</h1>
<% String userName = (String) request.getAttribute("userName"); %>
<% if ( userName == null ) { %>
	<a href="/spring_board/join">Join</a> &nbsp;&nbsp; <a href="/spring_board/login">Login</a>
<%} else {%>
	<p>${userName}님 반갑습니다</p> <a href="/spring_board/userLogout">LogOut</a>
<%} %>
</body>
</html>