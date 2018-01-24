<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users/delete.do</title>
</head>
<body>
<script>
	alert(${id }+"님의 모든 정보가 삭제 되었습니다.");
	location.href="${pageContext.request.contextPath}/";
</script>
</body>
</html>