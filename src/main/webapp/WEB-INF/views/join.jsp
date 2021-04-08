<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->
<link rel="stylesheet" href="css/bootstrap.css"> <!-- 참조  -->
<title>JSP 게시판 웹 사이트</title>
</head>
<body>    
    <div class="container">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <div class ="jumbotron" style="padding-top:20px;">
                <form method = "post" action="userJoin">
                    <h3>회원가입</h3>
                    <div class ="form-group">
                        <input type ="text" class="form-control" placeholder="이름" name ="userName" maxlength='20'>
                    </div>
                    <div class ="form-group">
                        <input type ="text" class="form-control" placeholder="아이디" name ="userId" maxlength='20'>
                    </div>
                    <div class ="form-group">
                        <input type ="password" class="form-control" placeholder="비밀번호" name ="userPassword" maxlength='20'>
                    </div>
                    <input type="submit" class="btn btn-primary form-control" value="회원가입">
					<a href="/spring_board">취소</a> 
                </form>
            </div> 
        </div> 
        <div class="col-lg-4"></div>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>