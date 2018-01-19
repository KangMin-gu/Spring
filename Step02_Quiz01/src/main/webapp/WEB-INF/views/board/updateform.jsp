<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>방명록 수정하세요~</h3>
<form action="update.do" method="post">
	<input type="hidden" name="num" value="${dto.num }"/>
	번호 <input type="text" value="${dto.num }" disabled/><br/>
	작성자 <input type="text" name="writer" value="${dto.writer }"/><br/>
	제목 <input type="text" name="title" value="${dto.title }"/><br/>
	내용 <textarea name="content" cols="30" rows="10">${dto.content }</textarea>
	<br/>
	<button id="sumbit" type="submit">수정 확인</button>
</form>
</body>
<script>
</script>
</html>