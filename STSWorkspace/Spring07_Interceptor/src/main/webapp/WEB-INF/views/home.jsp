<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interceptor Practice</title>
</head>
<body>
	<c:choose>
		<c:when test="${loginId != null }">
			${loginId }님 환영합니다	
		</c:when>
		<c:otherwise>
			로그인 안함
		</c:otherwise>
	</c:choose>
	<br><hr>
	<a href="/member/login">로그인</a><br>
	<a href="/member/logout">로그아웃</a>
	<hr>
	<a href="/guest"><button>Guest</button></a>
	<a href="/member"><button>Members Only</button></a>
	
	
	
</body>
</html>