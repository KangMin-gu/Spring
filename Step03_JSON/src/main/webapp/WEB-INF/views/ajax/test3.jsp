<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax/test3.jsp</title>
<script src="../resources/js/jquery-3.2.1.js"></script>
</head>
<body>
<h3>ajax 예제</h3>
<button id="getMembers">회원 목록 보기</button>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
		</tr>
	</thead>
	<tbody>

	</tbody>
</table>
</body>
<script>
	$("#getMembers").click(function(){
		$.ajax({
			url:"getMembers.do",
			method:"GET",
			success:function(data){
				console.log(data);
				// data 는 배열이다. 
				for(var i=0; i<data.length; i++){
					var tmp = data[i]; //tmp 는 object
					
					var td1=$("<td/>").text(tmp.num);
					var td2=$("<td/>").text(tmp.name);
					var td3=$("<td/>").text(tmp.addr);
					
					$("<td/>").append(td1).append(td2).append(td3).appendTo("tbody");
				}
			}
		});
	});
</script>
</html>