<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
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
                <div class="row gx-5 justify-content-center">
                	페이지 내용
                
                </div>    
                <thread>
                
                </thread>
                 <c:forEach items="${list}" var="d">
                 
                 <h3>${departmentName}</h3>
                 </c:forEach>
                 </table>
                 <div>]
                 <!
                 /div>
    
                 
                 </c:forEach>  
			</div>
		</section>		
	</main>
	<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
</body>
</html>