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
				<div class="text-center mb-5">
                        <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Projects</span></h1>
                </div>
                
                <div class="row gx-5 justify-content-center">
                	  <!-- 상세 정보 카드 -->
            <div class="card">
                <div class="card-header text-center py-3">
                    <h4 class="mb-0">부서 상세 정보</h4>
                </div>
                <div class="card-body p-4">
                    
                    <!-- 부서 번호 -->
                    <div class="row mb-3 border-bottom pb-2">
                        <div class="col-sm-4 label-text">부서 번호</div>
                        <div class="col-sm-8 value-text">${dto.departmentId}</div>
                    </div>

                    <!-- 부서명 -->
                    <div class="row mb-3 border-bottom pb-2">
                        <div class="col-sm-4 label-text">부서명</div>
                        <div class="col-sm-8 value-text text-primary"><strong>${dto.departmentName}</strong></div>
                    </div>

                    <!-- 관리자 ID -->
                    <div class="row mb-3 border-bottom pb-2">
                        <div class="col-sm-4 label-text">관리자 ID</div>
                        <div class="col-sm-8 value-text">${dto.managerId}</div>
                    </div>

                    <!-- 지역 ID -->
                    <div class="row mb-3 pb-2">
                        <div class="col-sm-4 label-text">지역 ID</div>
                        <div class="col-sm-8 value-text">
                            <span class="badge bg-info text-dark">${dto.locationId}</span>
                        </div>
                    </div>

                </div>
                
                <!-- Page Heading -->
                <h1 class= "h3 mb-4 text-gray-800">Detail Page</h1>
                <div>
                      <h3>${d.departmentName}</h3>
                      <h3>${d.category}</h3>
                      <h3>${d.capacity}</h3>
                </div> 
                
                      
                      
                
           </div>
                <div class="card-footer bg-white text-center py-3">
                    <button type="button" class="btn btn-outline-secondary me-2" onclick="history.back();">목록으로</button>
                    <button type="button" class="btn btn-warning" onclick="alert('수정 페이지로 이동');">정보 수정</button>
                </div>
            </div>
                
                </div>        
			</div>
		</section>		
	</main>
	<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
</body>
</html>