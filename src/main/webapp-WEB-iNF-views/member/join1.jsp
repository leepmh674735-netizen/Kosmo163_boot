<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Member Join</title>
    <!-- 공통 CSS 임포트 -->
    <c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
    
    <!-- Summernote CSS -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
</head>
<body id="page-top">
    <div id="wrapper">
        <c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>
                
                <div class="container-fluid">
                    <h1 class="h3 mb-4 text-gray-800">회원가입</h1>
                    
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <form action="./join" method="post" enctype="multipart/form-data" id="joinForm">
                                <div class="form-group">
                                    <label for="username">아이디</label>
                                    <input type="text" name="username" class="form-control" id="username" required>
                                </div>

                                <div class="form-group">
                                    <label for="password">비밀번호</label>
                                    <input type="password" name="password" class="form-control" id="password" required>
                                </div>

                                <div class="form-group">
                                    <label for="passwordCheck">비밀번호 확인</label>
                                    <!-- name 속성을 제거하여 서버로 중복 데이터가 전송되지 않게 합니다. -->
                                    <input type="password" class="form-control" id="passwordCheck" required>
                                </div>                                           
                                
                                <div class="form-group">
                                    <label for="name">이름</label>
                                    <input type="text" name="name" class="form-control" id="name" required>
                                </div>

                                <div class="form-group">
                                    <label for="phone">전화번호</label>
                                    <input type="tel" name="phone" class="form-control" id="phone">
                                </div>

                                <div class="form-group">
                                    <label for="email">이메일</label>
                                    <input type="email" name="email" class="form-control" id="email">
                                </div>                          

                                <div class="form-group">
                                    <label for="birth">생년월일</label>
                                    <!-- [수정] name="bith" -> name="birth" (DTO 필드명과 일치) -->
                                    <input type="date" name="birth" class="form-control" id="birth">
                                </div>

                                <div class="form-group">
                                    <label for="contents">자기소개</label>
                                    <!-- [추가] Summernote를 적용할 textarea 요소가 필요합니다. -->
                                    <textarea name="contents" id="contents" class="form-control"></textarea>
                                </div>
                                
                                <div class="form-group">
                                    <label>프로필 사진 첨부</label>
                                    <input type="file" name="attach" class="form-control">
                                </div>
                                
                                <!-- 검증(join.js)을 거쳐 전송하려면 type="button" 유지, 
                                     기본 전송을 원하면 type="submit"으로 변경 -->
                                <button type="button" id="joinBtn" class="btn btn-primary btn-block">회원가입</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
        </div>
    </div>
    
    <c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
    
    <!-- Summernote JS -->
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
    <script>
        // ID가 'contents'인 textarea에 에디터 적용
        $('#contents').summernote({
            placeholder: '자기소개를 입력해주세요.',
            tabsize: 2,
            height: 150
        });
    </script>
    <!-- 회원가입 유효성 검사 및 Submit 로직이 담긴 JS -->
    <script src="/js/member/join.js"></script>
</body>
</html>