<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/spring_board/">홈으로</a>
	<h2>${board.getTitle()}</h2>
	<p>${board.getContent()}</p>
	<hr>
	<c:forEach items="${board.getComments()}" var="list">
		<p>${list.getContent()}</p>
	</c:forEach>

	<form method="post" action="${board.getId()}/createComment">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="덧글"
				name="content" maxlength='20'> <input type="submit"
				class="btn btn-primary form-control" value="작성">
		</div>
	</form>

</body>
</html>