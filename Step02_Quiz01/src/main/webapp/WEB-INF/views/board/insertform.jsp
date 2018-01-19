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
<h3>방명록을 작성하세요.</h3>
<form action="insert.do" method="post">
	<label for="writer">이름</label>
	<input type="text" id="writer" name="writer"/><br/>
	<label for="title">제목</label>
	<input type="text" id="title" name="title" /><br/>
	<label for="content">내용</label>
	<textarea name="content" id="content" cols="30" rows="10">내용을 입력하세요</textarea><br/>
	<button type="submit">보내기</button>
</form>
</body>
</html>