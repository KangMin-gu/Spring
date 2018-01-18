<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/updateform.jsp</title>
</head>
<body>
<h3>회원 정보 수정 페이지</h3>
<form action="update.do" method="post">
	<input type="hidden" name="num" value="${dto.num }"/>
	번호 <input type="text" value="${dto.num }" disabled/><br/>
	이름 <input type="text" name="name" value="${dto.name }" /><br/>
	주소 <input type="text" name="addr" value="${dto.addr }" /><br/>
	<button type="submit">수정확인</button>
</form>
</body>
</html>