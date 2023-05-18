
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
			<th colspan="3">Message List</th>
		</tr>
		<c:forEach var="i" items="${list}">
			<tr>
				<td>${i.seq }</td>
				<td>${i.writer}</td>
				<td>${i.message}</td>
			</tr>

		</c:forEach>
		<tr>
			<td colspan="3" align="center">
			<input type="text" id="delseq" placeholder="삭제할 메세지 seq">
				<button id="delete">삭제하기</button></td>
		</tr>
		<form action="/modifyMsg" method="post">
			<tr>
				<td colspan="3">
					<input type="text" name="seq" placeholder="수정할 메세지 seq"><br> 
					<input type="text" name="writer" placeholder="수정할 메세지 작성자"><br> 
					<input type="text" name="message" placeholder="수정할 메세지 내용">
					<button>수정하기</button></td>
			</tr>
		</form>
	</table>

	<script>
		$("#delete").on("click", function() {
			location.href = "/deleteByseq?delseq=" + $("#delseq").val();
		})
	</script>
</body>
</html>