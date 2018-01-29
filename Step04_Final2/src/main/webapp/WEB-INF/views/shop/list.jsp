<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shop/list.jsp</title>
</head>
<body>
<h3>상품 목록 입니다.</h3>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>가격</th>
			<th>남은수량</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="tmp" items="${list }">
			<tr>
				<td>${tmp.num }</td>
				<td>${tmp.name }</td>
				<td>${tmp.price }</td>
				<td>${tmp.remainCount }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>