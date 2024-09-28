<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
	<form action="/todo/register" method="post">
		<div>
			Title: <input type="text" name="title">
		</div>
		<div>
			DueDate: <input type="date" name="dueDate" value="2022-12-25">
		</div>
		<div>
			Writer: <input type="text" name="writer">
		</div>
		<div>
			Finished: <input type="checkbox" name="finished">
		</div>
		<div>
			<button type="submit">Register</button>
		</div>
	</form>
</body>
</html>