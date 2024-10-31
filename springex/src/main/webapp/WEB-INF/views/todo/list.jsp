<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<!-- <h1>Hello, world!</h1>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script> -->
	<div class="container-fluid">
		<c:import url="/WEB-INF/views/header.jsp" />
		<div class="row content">
			<div class="col">
				<div class="card">
					<div class="card-body">
						<h5 class = "card-title">Search</h5>
						<form action="/todo/list" method="get">
							<input type="hidden" name="size" value="${pageRequestDTO.size}">
							<div class="mb-3">
								<input type="checkbox" name="finished" <c:if test="${pageResponseDTO.finished }">disabled</c:if>  >완료여부
							</div>
							<div class="mb-3">
								<input type="checkbox" name="types" value="t" <c:if test="${pageResponseDTO.checkType('t') }">disabled</c:if> >제목
								<input type="checkbox" name="types" value="w" <c:if test="${pageResponseDTO.checkType('w') }">disabled</c:if> >작성자
								<input type="text" name="keyword" class="form-control" value='<c:out value="${pageRequestDTO.keyword }"/>'>
							</div>
							<div class="input-group mb-3 dueDateDiv">
								<input type="date" name="from" class="form-control" value="${pageRequestDTO.from}">
								<input type="date" name="to" class="form-control" value="${pageRequestDTO.to}">
							</div>
							<div class="input-group mb-3">
								<div class="float-end">
									<button class="btn btn-primary" type="submit">Search</button>
									<button class="btn btn-info clearBtn" type="reset">Clear</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="row content">
			<div class="col">
				<div class="card">
					<div class="card-header">Featured</div>
					<div class="card-body">
						<h5 class="card-title">Special title treatment</h5>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Tno</th>
									<th scope="col">Title</th>
									<th scope="col">Writer</th>
									<th scope="col">DueDate</th>
									<th scope="col">Finished</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${responseDTO.dtoList}" var="dto">
									<tr>
										<th scope="row"><c:out value="${dto.tno}"></c:out></th>
										<td><a
											href="/todo/read?tno=${dto.tno}&${pageRequestDTO.link}"
											class="text-decoration-none" data-tno="${dto.tno}"> <c:out
													value="${dto.title}">
												</c:out>
										</a></td>
										<td><c:out value="${dto.writer}"></c:out></td>
										<td><c:out value="${dto.dueDate}"></c:out></td>
										<td><c:out value="${dto.finished}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="float-end">
							<ul class="pagination flex-wrap">
								<c:if test="${responseDTO.prev}">
									<li class="page-item"><a class="page-link"
										data-num="${responseDTO.start -1 }">Previous</a></li>
								</c:if>
								<c:forEach begin="${responseDTO.start}"
									end="${responseDTO.end }" var="num">
									<li class="page-item ${responseDTO.page == num? "active" : ""} ">
										<a class="page-link" data-num="${num}">${num}</a>
									</li>
								</c:forEach>
								<c:if test="${responseDTO.next}">
									<li class="page-item"><a class="page-link"
										data-num="${responseDTO.end +1 }">Next</a></li>
								</c:if>
							</ul>
						</div>
						<script>
    							document.querySelector(".pagination").addEventListener("click", function(e){
    								e.preventDefault()
    								e.stopPropagation()
    								
    								const target = e.target
    								
    								if(target.tagName !== 'A'){
    									return
    								}
    								const num = target.getAttribute("data-num")
    								
    								const formObj = document.querySelector("form")
    								
    								formObj.innerHTML += `<input type='hidden' name='page' value='\${num}'>`
    								
    									formObj.submit();
    								
    								//self.location = `/todo/list?page=\${num}`
    							},false)
    							
    							document.querySelector(".clearBtn").addEventListener("click", function(e){
    								e.preventDefault()
    								e.stopPropagation()
    							
    								self.location ='/todo/list'
    							},false)
    					</script>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/footer.jsp" />
</body>
</html>