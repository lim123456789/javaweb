<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Todo List</title>
</head>
<body>
	<h1>Todo List</h1>
	<h2>${appname}</h2>
	<h2>${loginInfo}</h2>
	<h3>${loginInfo.mname}</h3>
	<ul>
		<c:forEach items="${dtoList}" var="dto">
			<li>
				<span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
				<span>${dto.title}</span>
				<span>${dto.dueDate}</span>
				<span>${dto.finished? "DONE": "NOT YET"}</span>
			</li>
		</c:forEach>
	</ul>
	
	<form action="/logout" method="post">
		<button>LOGOUT</button>
	</form>
</body>
</html>