<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax/test2.jsp</title>
<script src="../resources/js/jquery-3.2.1.js"></script>
</head>
<body>
<form action="signup.do" method="post" id="myForm">
	아이디 <input type="text" name="id" id="id" /> 
	<span id="checkResult"></span>
	<button id="checkBtn">중복확인</button>
	<br/>
	<button type="submit">가입</button>
</form>
<script>
	//중복 확인 버튼을 눌렀을때 실행할 함수 등록 
	$("#checkBtn").click(function(){
		//입력한 아이디를 읽어와서
		var inputId=$("#id").val();
		//서버에 ajax 요청을 통해서 보낸다음
		$.ajax({
			url:"checkId.do",
			method:"GET",
			data:{id:inputId},
			success:function(data){
				//사용가능 여부를 함수로 전달 받아서 처리 
				if(data.canUse){
					$("#checkResult").text("사용가능");
				}else{
					$("#checkResult").text("사용불가");
				}
			}
		});
		
		return false; //폼 제출 막기 
	});
</script>
</body>
</html>














