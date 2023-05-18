
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>
</head>
<body>

	<table border="1" align="center">
		<tr>
			<th colspan="3">Movie List
		</tr>
		<c:forEach var="i" items="${list}">
			<tr>
				<td>${i.id }</td>
				<td>${i.title }</td>
				<td>${i.genre }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3" align="center"><input type="text" id="delid"
				placeholder="삭제할 영화 ID">
			<button id="delete">삭제하기</button></td>
		</tr>
		<form action="/modifyMovie" method="post">
			<tr>
				<td colspan="3">
					<input type="text" name="id" placeholder="수정할 영화 ID"><br>
					<input type="text" name="title" placeholder="수정할 영화 제목"><br> 
					<input type="text" name="genre" placeholder="수정할 영화 장르">
					<button>수정하기</button></td>
			</tr>
		</form>

	</table>

	<script>
		$("#delete").on("click", function() {
			location.href = "/deleteById?delid=" + $("#delid").val();
		})
	</script>

</body>
</html>