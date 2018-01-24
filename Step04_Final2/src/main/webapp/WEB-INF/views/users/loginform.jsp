<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users/loginform.do</title>
</head>
<body>
<h3>로그인 폼 입니다.</h3>
<form action="login.do" method="post">
	<!-- 로그인 후 이동할 url 대한 정보 -->
	<input type="hidden" name="url" value="${url }" />
	<label for="id">아이디</label>
	<input type="text" name="id" id="id" /><br/>
	<label for="pwd">비밀번호</label>
	<input type="password" name="pwd" id="pwd" /><br/>
	<button type="submit">로그인</button>
	<p>${url }</p>
</form>
<a href="${pageContext.request.contextPath}/">인덱스로가기</a>
</body>
</html>