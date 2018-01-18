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
<ul>
	<li><a href="member/list.do">회원정보</a></li>
	<li><a href="member/insert.do">회원정보 추가</a></li>
</ul>
<h4>공지사항</h4>
<ul>
	<c:forEach var="tmp" items="${news }">
		<li>${tmp }</li>
	</c:forEach>
</ul>
</body>
</html>