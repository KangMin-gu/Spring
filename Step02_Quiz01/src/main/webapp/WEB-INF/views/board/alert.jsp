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
<h3>알림메세지입니다.</h3>
<p>${msg }</p>
<a href="${pageContext.request.contextPath }/board/list.do">리스트로 돌아가기</a>
</body>
</html>