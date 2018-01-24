<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file/list.do</title>
</head>
<body>
<a href="insertform.do">파일 올리기</a>
<h3>업로드된 파일 목록입니다.</h3>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>파일</th>
			<th>크기</th>
			<th>등록일</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="tmp" items="${list}">
			<tr>
				<td>${tmp.num }</td>
				<td>${tmp.writer }</td>
				<td>${tmp.title }</td>
				<td><a href="download.do?num=${tmp.num }">${tmp.orgFileName}</a></td>
				<td>${tmp.fileSize } <strong>bytes</strong></td>
				<td>${tmp.regdate }</td>
				<td>
					<c:if test="${id eq tmp.writer }"><!-- 세션저장된id와 작성자가 같을경우만 삭제링크 제공 -->
						<a href="javascript:deleteConfirm(${tmp.num })">삭제</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="${pageContext.request.contextPath}/">인덱스로가기</a>
<script>
	function deleteConfirm(num){
		var isDelete=confirm(num+" 번 글을 삭제 하시겠습니까?");
		if(isDelete){
			//javascript 로 이동 
			location.href="delete.do?num="+num;
		}
	}
</script>
</body>
</html>