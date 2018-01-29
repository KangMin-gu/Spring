<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<div class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath }/home.do">Acorn</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="file/list.do">자료실 목록보기</a></li>
			<li><a href="cafe/list.do">카페 글 목록보기</a></li>
		</ul>
		<c:choose>
			<c:when test="${not empty id }">
				<a class="btn btn-warning btn-xs navbar-btn pull-right" href="${pageContext.request.contextPath}/users/logout.do">로그아웃</a>
				<p class="navbar-text pull-right"><a class="navbar-link" href="${pageContext.request.contextPath }/users/info.do"><strong>${id }</strong></a>님 로그인중... </p>
			</c:when>
			<c:otherwise>
				<a class="navbar-text navbar-link pull-right" href="${pageContext.request.contextPath }/users/loginform.do?url=${pageContext.request.contextPath}/file/list.do">로그인</a>
			</c:otherwise>
		</c:choose>
				<a href="${pageContext.request.contextPath }/users/signup_form.do">회원가입</a>
		
	</div>
</div>

<h4>공지사항</h4>
<ul>
	<c:forEach var="tmp" items="${news }">
		<li>${tmp }</li>
	</c:forEach>
</ul>
</body>
</html>