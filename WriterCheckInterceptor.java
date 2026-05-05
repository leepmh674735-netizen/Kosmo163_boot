package com.winter.app.interceptors;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.board.BoardDTO;
import com.winter.app.member.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WriterCheckInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        // 1. GET 방식이 아니거나 modelAndView가 null인 경우 체크 (예외 방지)
        if (modelAndView == null || request.getMethod().equalsIgnoreCase("POST")) {
            return;
        }

        HttpSession session = request.getSession();
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

        // 2. 로그인 여부 확인 (로그인 안 된 경우 대비)
        if (memberDTO == null) {
            modelAndView.setViewName("commons/result");
            modelAndView.addObject("result", "로그인이 필요합니다.");
            modelAndView.addObject("url", "/member/login"); // 로그인 경로로 수정
            return;
        }

        // 3. 모델 데이터 가져오기 및 널 체크
        Map<String, Object> model = modelAndView.getModel();
        BoardDTO boardDTO = (BoardDTO) model.get("dto");

        if (boardDTO == null) {
            log.warn("WriterCheckInterceptor: BoardDTO ('dto')가 모델에 존재하지 않습니다.");
            return;
        }

        // 4. 작성자 비교 로직
        String currentUsername = memberDTO.getUsername();
        String boardWriter = boardDTO.getBoardWriter();

        log.info("Current User: {}, Board Writer: {}", currentUsername, boardWriter);

        if (currentUsername == null || !currentUsername.equals(boardWriter)) {
            // 작성자가 아닐 경우 공통 결과 페이지로 전달
            modelAndView.setViewName("commons/result");
            modelAndView.addObject("result", "작성자만 접근 가능합니다.");
            modelAndView.addObject("url", "./list");
        }
    }
}