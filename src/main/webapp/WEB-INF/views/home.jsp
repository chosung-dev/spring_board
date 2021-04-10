<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
	<a href="/spring_board/board/create">글 작성</a>
<%} %>

	<table>
	<tr><th>글 제목</th></tr>
	<c:forEach items="${boardList}" var="list">
	<tr>
		<td>${list}<td>
	</tr>
	</c:forEach>
	</table>
	<c:if test="${1 ne startNum}">
		<a href="/spring_board/board/page/${startNum-1}"><</a>
	</c:if>
	<c:forEach var="i" begin="${startNum}" end="${startNum+4}">
		<c:choose>
			<c:when test="${pageNum ne i}">
				<a href="/spring_board/board/page/${i}">${i}</a>
			</c:when>
			<c:when test="${pageNum eq i}">
				<p style="display:inline">${i}</p>
			</c:when>
		</c:choose>
	</c:forEach>
	<c:if test="${10 eq fn:length(boardList)}">
		<a href="/spring_board/board/page/${startNum+5}">></a>
	</c:if>
	

</body>
</html>