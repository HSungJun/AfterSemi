<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/writeMsg" method="post">
	<table border="1" align="center">
		<tr>
			<th>Input</th>
		</tr>
		<tr>
			<td><input type="text" name="writer" placeholder="작성자 입력"> </td>
		</tr>
		<tr>
			<td><input type="text" name="message" placeholder="메세지 내용 입력"> </td>
		</tr>
		<tr>
				<td align="center"><input type="submit"><a href="/"><button
							type="button">Back</button></td>
			</tr>
	</table>
	</form>
</body>
</html>