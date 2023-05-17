<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input Form</title>
</head>
<body>
	<form action="/inputProc" method="post">
		<table border="1" align="center">
			<tr>
				<th colspan="2">Input</th>
			</tr>
			<tr>
				<td><input type="text" name="title" placeholder="영화제목">
			</tr>
			<tr>
				<td><input type="text" name="genre" placeholder="영화장르">
			</tr>
			<tr>
				<td align="center"><input type="submit"><a href="/"><button
							type="button">Back</button></td>
			</tr>

		</table>
	</form>

</body>
</html>