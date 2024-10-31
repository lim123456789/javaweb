<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Modify</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<c:import url="/WEB-INF/views/header.jsp" />
		<div class="row content">
			<div class="col">
				<div class="card">
					<div class="card-header">Modify</div>
					<div class="card-body">
						<form action="/todo/modify" method="post">
						
							<div class="input-group mb-3">
								<span class="input-group-text">TNO</span> <input type="text"
									class="form-control" name="tno"
									value=<c:out value="${dto.tno}"></c:out> readonly>
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text">Title</span> <input type="text"
									name="title" class="form-control"
									value='<c:out value="${dto.title}"></c:out>'>
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text">DueDate</span> <input type="date"
									name="dueDate" class="form-control"
									value=<c:out value="${dto.dueDate}"></c:out>>
							</div>
							<div class="input-group mb-3">
								<span class="input-group-text">Writer</span> <input type="text"
									name="writer" class="form-control"
									value=<c:out value="${dto.writer}"></c:out> readonly>
							</div>
							<div class="form-check">
								<label class="form-check-label"> Finished &nbsp; </label> <input
									class="form-check-input" type="checkbox" name="finished"
									${dto.finished?"checked":"" }>
							</div>
							<div class="my-4">
								<div class="float-end">
									<button type="button" class="btn btn-danger">Remove</button>
									<button type="button" class="btn btn-primary">Modify</button>
									<button type="button" class="btn btn-secondary">List</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/footer.jsp" />
	</div>
	<script>
		const formObj = document.querySelector("form")
		document.querySelector(".btn-danger").addEventListener("click",
				function(e) {
					e.preventDefault()
					e.stopPropagation()

					formObj.action = `/todo/remove?${pageRequestDTO.link}`

					formObj.method = "post"
					formObj.submit()
				}, false);

		document.querySelector(".btn-primary").addEventListener("click",
				function(e) {
					e.preventDefault()
					e.stopPropagation()
					formObj.action = "/todo/modify"

					formObj.method = "post"
					formObj.submit()
				}, false)
		document.querySelector(".btn-secondary").addEventListener("click",
				function(e) {

					e.preventDefault()
					e.stopPropagation()
					self.location = `/todo/list?${pageRequestDTO.link}`
				}, false)
	</script>
	<script>
		const serverValidResult = {}
		<c:forEach items="${errors}" var="error">
		serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
		</c:forEach>
		console.log(serverValidResult)
	</script>
</body>
</html>