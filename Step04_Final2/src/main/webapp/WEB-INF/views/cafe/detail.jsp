<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 보기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<script src="${pageContext.request.contextPath}/SmartEditor/js/HuskyEZCreator.js"></script>
<style>
	textarea{resize:none;}
	#content{display:none;width:100%;height:300px;}
</style>
</head>
<body>
<div class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath }/home.do">Acorn</a>
		</div>
		<a class="btn btn-warning btn-xs navbar-btn pull-right" href="${pageContext.request.contextPath}/users/logout.do">로그아웃</a>
		<p class="navbar-text pull-right"><a class="navbar-link" href="${pageContext.request.contextPath }/users/info.do"><strong>${id }</strong></a>님 로그인중... </p>
	</div>
</div>
<div class="container">
	<!-- breadcrumb UI 제공하기 -->
	<ul class="breadcrumb">
		<li><a href="${pageContext.request.contextPath}/home.do">Home</a></li>
		<li><a href="${pageContext.request.contextPath}/cafe/list.do">Cafe</a></li>
		<li class="active">상세 보기</li>
	</ul>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg }</div>
	</c:if>
	   <%-- 로그인한 회원이 작성한 글이라면  수정, 삭제 링크를 출력한다. --%>
   <c:if test="${dto.prevNum ne 0 }">
   	<a class="btn btn-default btn-sm" href="detail.do?num=${dto.prevNum}&condition=${condition}&keyword=${keyword}"><i class="glyphicon glyphicon-chevron-up"></i></a>
   </c:if>
   <c:if test="${dto.nextNum ne 0 }">
   	<a class="btn btn-default btn-sm" href="detail.do?num=${dto.nextNum}&condition=${condition}&keyword=${keyword}"><i class="glyphicon glyphicon-chevron-down"></i></a>
   </c:if>
   	<h1><strong>${dto.title }</strong></h1>
	<p>${dto.regdate} <em>By</em> <strong>${dto.writer}</strong></p>   
	<hr/>
    <div class="content">${dto.content }</div>
    <hr/>
    <a class="btn btn-default btn-xs" href="${pageContext.request.contextPath}/cafe/list.do">리스트로 가기</a>
    <c:if test="${id eq dto.writer }">
    <a class="btn btn-default btn-xs" href="updateform.do?num=${dto.num }">수정</a>
    <a class="btn btn-default btn-xs" href="javascript:deleteCheck()">삭제</a>
    </c:if>
</div>
<script>
	function deleteCheck(){
		var isDelete=confirm("삭제 하시겠습니까?");
		if(isDelete){
			location.href="delete.do?num=${dto.num}";
		}
	}
</script>
</body>
</html>