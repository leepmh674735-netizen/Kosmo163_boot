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
    private AccountService accountService;

    // 1. 단순 페이지 이동은 void보다 String 권장
    @GetMapping("create")
    public String create() throws Exception {
        return "account/create"; 
    }

    @PostMapping("create")
    public String create(AccountDTO accountDTO, HttpSession session) throws Exception {
        // 2. 세션 로그인 정보 체크 (NPE 방지)
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

        if (memberDTO == null) {
            // 로그인 안 된 상태면 로그인 페이지로 유도
            return "redirect:/member/login";
        }

        // 3. 사용자 ID 설정
        accountDTO.setUsername(memberDTO.getUsername());

        // 4. 서비스 로직 실행 결과에 따른 분기 처리 (선택 사항)
        int result = accountService.create(accountDTO);

        if (result > 0) {
            return "redirect:/"; // 성공 시 메인
        } else {
            return "account/create"; // 실패 시 다시 작성 폼
        }
    }
}