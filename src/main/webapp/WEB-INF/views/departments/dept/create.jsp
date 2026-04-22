<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/temp/nav.jsp"></c:import>

		<section class="py-5">
			<div class="container px-5 mb-5">
				<div class="text-center mb-5">
					<h1 class="display-5 fw-bolder mb-0">
						<span class="text-gradient d-inline">Projects</span>
					</h1>
				</div>

				<div class="row gx-5 justify-content-center">
					<form action="./create" method="post">
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">부서명</label> <input
								type="text" class="form-control" id="departmentNo"
								id="exampleInputEmail1" name="departmentName"
								aria-describedby="emailHelp">
						</div>
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">관리자ID</label>
							<input type="text" class="form-control" id="exampleInputEmail1"
								name="managerId" aria-describedby="emailHelp">
						</div>
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">지역ID</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								name="locationId" aria-describedby="emailHelp">
						</div>]
						<form method="post">
						<div class="form-group">
						
						</div>
						
						</form>
                         <div class= "form-group">
                         <label for= "yes">OPEN</label>
                         <input type="radio" name="openYn" value="Y" class 
                         </div>


						<button type="submit" class="btn btn-primary">Submit</button>
					</form>

				</div>
			</div>
		</section>
	</main>
	<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
</body>
</html>