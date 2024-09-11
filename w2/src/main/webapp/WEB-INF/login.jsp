<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
	<c:if test="${param.result=='error'}">
		<h1>로그인 에러</h1>		
		<h2>${loginInfo}</h2>
		<h3>${loginInfo.mname}</h3>
	</c:if>
	<form action="/login" method="post">
		<input type="text" name="mid">
		<input type="text" name="mpw">
		<button type="submit">LOGIN</button>
	</form>
</body>
</html>