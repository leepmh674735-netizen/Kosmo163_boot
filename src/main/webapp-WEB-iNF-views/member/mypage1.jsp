<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지 - ${member.name}님</title>
    <c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
</head>
<body id="page-top">
    <div id="wrapper">
        <c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>
                
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">내 정보 확인</h1>
                    
                    <div class="card shadow mb-4 col-lg-8">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">${member.username}님의 프로필</h6>
                        </div>
                        <div class="card-body">
                            <!-- 데이터가 있을 때만 출력하는 조건문 추가 -->
                            <c:if test="${not empty member}">
                                <div class="row mb-3">
                                    <div class="col-sm-3 font-weight-bold">이름</div>
                                    <div class="col-sm-9">${member.name}</div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3 font-weight-bold">생년월일</div>
                                    <div class="col-sm-9">${member.birth}</div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3 font-weight-bold">이메일</div>
                                    <div class="col-sm-9">${member.email}</div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3 font-weight-bold">전화번호</div>
                                    <div class="col-sm-9">${member.phone}</div>
                                </div>
                                
                                <hr>
                                <div class="mt-4">
                                    <a href="./update" class="btn btn-warning">정보 수정</a>
                                    <a href="/" class="btn btn-secondary">홈으로</a>
                                </div>
                            </c:if>
                            
                            <!-- 세션 정보가 없을 경우 안내 -->
                            <c:if test="${empty member}">
                                <div class="text-center py-5">
                                    <p class="lead text-gray-800 mb-5">로그인 정보가 없습니다.</p>
                                    <a href="./login" class="btn btn-primary">로그인 하러 가기</a>
                                </div>
                            </c:if>
                        </div>
                    </div>

                </div>
                <!-- End Page container-fluid -->
                
            </div>
            <!-- End page Content -->
            <c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
        </div>
        <!-- End Content wrapper -->
    </div>
    <!-- End Wrapper -->
    
    <c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
</body>
</html>