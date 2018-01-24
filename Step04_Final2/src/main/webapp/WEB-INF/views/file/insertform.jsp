<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file/insertform.jsp</title>
</head>
<body>
<h3>파일 업로드 폼 입니다.</h3>
<form action="insert.do" method="post" enctype="multipart/form-data">
	<!-- 전달되는 값들은 name 값들 insert를 눌렀을때 자동으로 dto에 들어가는 값은 title/file; 나머지는 내가 넣어줘야한다.
	orgfileName / saveFilename / fileSize 는 MultipartFile을 통해 작업하여 넣어줘야한다.  -->
	<label for="writer">작성자</label><!-- 작성자는 서버단에서 세션에서 얻어올것이다. -->
	<input type="text" id="writer" value="${id }" disabled/><br/>
	<label for="title">제목</label>
	<input type="text" name="title" id="title" /><br/>
	<label for="file">첨부파일</label>
	<input type="file" name="file" id="file" /><br/> <!-- fileDto의 MultipartFile -->
	<button type="submit">업로드</button>

</form>
</body>
</html>