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
	<h3>인덱스 페이지 입니다.</h3>

	<ul>
		<li><a href="json01.do">json 응답1</a></li> {}
		<li><a href="json02.do">json 응답2</a></li> []
		<li><a href="json03.do">json 응답3</a></li> [{},{},{}....]
		<li><a href="json04.do">json 응답4</a></li> [{},{},{}....]
		<li><a href="ajax/test.do">ajax 요청 테스트</a></li>
		<li><a href="ajax/test2.do">ajax 아이디 중복 확인</a></li>
		<li><a href="ajax/test3.do">ajax Example</a></li>
	</ul>

</body>
</html>