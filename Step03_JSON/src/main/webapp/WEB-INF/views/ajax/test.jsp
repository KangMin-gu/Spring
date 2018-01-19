<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax/test.jsp</title>
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.js"></script>
</head>
<body>
<h3>ajax 테스트 페이지 </h3>
<button id="getBtn">회원정보 받아오기</button>

<p>번호 : <strong id="num"></strong></p>
<p>이름 : <strong id="name"></strong></p>
<p>주소 : <strong id="addr"></strong></p>

<script>

	//버튼을 눌렀을대 실행할 함수 등록 
	$("#getBtn").click(function(){
		//ajax 요청 하기 
		$.ajax({
			url:"getInfo.do",
			method:"GET",
			success:function(data){
				//서버가 응답하는 데이터 콘솔에 출력해보기
				console.log(data);
				// Strong 요소의 text 에 출력해 보기 
				$("#num").text(data.num);
				$("#name").text(data.name);
				$("#addr").text(data.addr);
			}
		})
	});
</script>
</body>
</html>