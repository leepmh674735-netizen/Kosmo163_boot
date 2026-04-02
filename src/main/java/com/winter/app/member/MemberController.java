package com.winter.app.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//annotation 설명 + 기능
@Controller
@RequestMapping("/member/*") // 
public class MemberController {

	@RequestMapping("join")
	public String join() {
		System.out.println("회원가입 페이지");

		return "member/join";
	}

	@RequestMapping("login")
    public String login() {
    	return "member/login";
    }
