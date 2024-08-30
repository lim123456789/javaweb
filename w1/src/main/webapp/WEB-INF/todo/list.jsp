<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
<h1>List Page</h1>

<ul>
	<c:forEach var="dto" items="${list}">
		<li>${dto}</li>
	</c:forEach>
</ul>

</body>
</html>