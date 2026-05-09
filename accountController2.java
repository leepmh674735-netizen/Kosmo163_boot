package com.winter.app.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/account/*")
public class AccountController {

    @Autowired
    private AccountService accountService; // 변수명은 소문자로 시작 (AccountService -> accountService)

    // 1. 계좌 개설 페이지 이동
    @GetMapping("create")
    public void create() throws Exception {
        // 리턴 타입이 void이므로 /WEB-INF/views/account/create.jsp 등으로 연결됨
    }

    // 2. 계좌 개설 처리
    @PostMapping("create")
    public String create(AccountDTO accountDTO, HttpSession session) throws Exception {
        // 세션에서 로그인한 사용자 정보 가져오기
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

        // 로그인 상태 확인 (방어 코드)
        if (memberDTO == null) {
            return "redirect:/member/login";
        }

        // 계좌 객체에 현재 로그인한 사용자의 ID 세팅
        accountDTO.setUsername(memberDTO.getUsername());

        // DB 저장 서비스 호출
        int result = accountService.create(accountDTO);

        return "redirect:/";
    }
}