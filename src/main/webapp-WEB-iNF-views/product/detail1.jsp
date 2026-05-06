<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 상세 정보</title>
    <c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
</head>
<body id="page-top">
    <div id="wrapper">
        <c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>
                
                <div class="container-fluid">
                    <h1 class="h3 mb-4 text-gray-800">회원 정보 상세</h1>
                    
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">${member.name} 님의 프로필</h6>
                        </div>
                        <div class="card-body">
                            <c:choose>
                                <c:when test="${not empty member}">
                                    <div class="table-responsive">
                                        <table class="table table-bordered" width="100%" cellspacing="0">
                                            <tr>
                                                <th width="20%">이름</th>
                                                <td>${member.name}</td>
                                            </tr>
                                            <tr>
                                                <th>생년월일</th>
                                                <td>${member.birth}</td>
                                            </tr>
                                            <tr>
                                                <th>이메일</th>
                                                <td>${member.email}</td>
                                            </tr>
                                            <tr>
                                                <th>전화번호</th>
                                                <td>${member.phone}</td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="mt-3">
                                        <a href="./update?id=${member.id}" class="btn btn-primary">수정</a>
                                        <a href="./list" class="btn btn-secondary">목록으로</a>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <p class="text-center">회원 정보를 찾을 수 없습니다.</p>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
            <c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
        </div>
    </div>
    <c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
</body>
</html>