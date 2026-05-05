package com.winter.app.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // 1. 세션에서 로그인 정보 가져오기
        HttpSession session = request.getSession();
        Object member = session.getAttribute("member");

        // 2. 로그인 되어 있다면 컨트롤러로 진행
        if (member != null) {
            return true;
        }

        // 3. 로그인 안 되어 있을 경우 처리
        // AJAX 요청인지 확인 (옵션: 프론트엔드 처리를 위해 필요할 수 있음)
        String xmlHttpRequest = request.getHeader("X-Requested-With");

        if ("XMLHttpRequest".equals(xmlHttpRequest)) {
            // 비동기 요청일 경우 리다이렉트 대신 403 에러 등을 보냄
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else {
            // 일반 요청일 경우 로그인 페이지로 리다이렉트
            // contextPath를 고려하여 경로를 설정하는 것이 안전합니다.
            response.sendRedirect(request.getContextPath() + "/member/login");
        }

        return false;
    }
}