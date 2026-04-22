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
					<div>
						<table class="table">
							<thead>
								<tr>
									<th>부서번호</th>
									<th>부서명</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${requestScope.list}" var="d">
									<tr>
										<td>${pageScope.d.departmentId}</td>
										<td><a href="./detail?departmentId=${d.departmentId}">${d.departmentName}</a></td>
									</tr>
									<!-- 
						getter의 이름 : getter메서드에서
						get을 빼고 () 빼고
						첫글자를 소문자로 바꾼거
						ex) getName() => name
					-->



								</c:forEach>
							</tbody>
						</table>
						
						<div>
						     <a href="">학과등록</a>
						</div>
						
						</div>
						</div>
						
						
						
						
					</div>
					
					<a class="btn btn-primary" href="./create">부서등록</a>

				</div>
			</div>
		</section>
	</main>
	<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
</body>
</html>