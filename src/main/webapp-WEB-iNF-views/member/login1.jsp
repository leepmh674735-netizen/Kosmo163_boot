<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Member Login</title>
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
                    <h1 class="h3 mb-4 text-gray-800">Login Page</h1>
                    
                    <div class="card shadow mb-4 col-lg-6">
                        <div class="card-body">
                            <!-- 1. enctype 제거: 파일 업로드가 없으므로 일반 전송 사용 -->
                            <!-- 2. action="./login": MemberController의 @PostMapping("login")으로 연결 -->
                            <form action="./login" method="post">
                                <div class="form-group">
                                    <label for="username">Username</label>
                                    <!-- value="user1"은 테스트용이므로 실제 운영시에는 제거 권장 -->
                                    <input type="text" name="username" class="form-control" id="username" placeholder="Enter ID" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" name="password" class="form-control" id="password" placeholder="Enter Password" required>
                                </div>                         
                                              
                                <button type="submit" class="btn btn-primary btn-block">Login</button>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="./join">Create an Account!</a>
                            </div>
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