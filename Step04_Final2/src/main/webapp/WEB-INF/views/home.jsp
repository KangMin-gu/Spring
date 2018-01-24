<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
<h3>인덱스페이지입니다.</h3>
<c:choose>
	<c:when test="${empty id }">
		<a href="users/loginform.do">로그인</a>
		<a href="users/signup_form.do">회원가입</a><br/>
		<a href="users/info.do?name=gura&addr=nrg">테스트 유저정보 보기 링크</a><br/>

	</c:when>
	<c:otherwise>
		<p><strong><a href="users/info.do">${id }</a></strong> 님 로그인 중 ...</p>
		<a href="users/logout.do">로그아웃</a>
	</c:otherwise>
</c:choose>

<ul>
	<li><a href="file/list.do">자료실 목록보기</a></li>
</ul>


<h4>공지사항</h4>
<ul>
	<c:forEach var="tmp" items="${news }">
		<li>${tmp }</li>
	</c:forEach>
</ul>
</body>
</html>