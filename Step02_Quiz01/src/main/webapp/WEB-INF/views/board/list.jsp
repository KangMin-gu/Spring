<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/list.jsp</title>
</head>
<body>
<h3>글 목록 입니다.</h3>
<a href="insertform.do">글쓰기</a>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="tmp" items="${list }">
		<tr>
			<td>${tmp.num }</td>
			<td><a href="detail.do?num=${tmp.num }">${tmp.title }</a></td>
			<td>${tmp.writer }</td>
			<td>${tmp.regdate }</td>
			<td><a href="update.do?num=${tmp.num }">수정</a></td>
			<td><a href="delete.do?num=${tmp.num }">삭제</a></td>
		</tr> 
		</c:forEach>
	</tbody>
</table>
</body>
</html>