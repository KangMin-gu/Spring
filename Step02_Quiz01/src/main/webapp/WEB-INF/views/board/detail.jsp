<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detail.do</title>
</head>
<body>
<h3>${dto.num } 번 글 상세 보기</h3>

<p>작성자: <strong>${dto.writer }</strong></p>
<p>제목: <strong>${dto.title }</strong></p>
<p>내용:
 <textarea name="content" id="content" cols="30" rows="10" disabled>${dto.content }</textarea></p>
<p>작성일: <strong>${dto.regdate }</strong></p>
<a href="updateform.do?num=${dto.num }">수정</a>
<a href="javascript:isDelete()">삭제</a>
<a href="list.do">목록으로</a>
<script>
	function isDelete(){
		var result=confirm("삭제할까요?");
		location.href="delete.do?num="+${dto.num };
	}
</script>
</body>
</html>