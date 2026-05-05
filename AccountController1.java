package com.springinpractice.ch04.web;

import javax.validation.Valid;
import org.springframework.stereotype.Controller; // C 대문자
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; // v 소문자
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder; // W 대문자
import org.springframework.web.bind.annotation.InitBinder; // Binder 오타 수정
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // @Component 대신 @Controller 사용
@RequestMapping("/users")
public class AccountController {

    private static final String VN_REG_FORM = "users/registrationForm";
    private static final String VN_REG_OK = "redirect:/users/registration_ok"; // 경로 수정

    // 1. Binder 설정: 허용된 필드만 바인딩 (보안: 파라미터 변조 방지)
    @InitBinder
    public void initBinder(WebDataBinder binder) { // 클래스 선언이 아닌 메서드여야 함
        binder.setAllowedFields(new String[] {
                "username", "password", "confirmPassword", "firstName",
                "lastName", "email", "marketingOk", "acceptTerms"
        });
    }

    // 2. 등록 폼 보여주기 (GET)
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getRegistrationForm(Model model) {
        model.addAttribute("account", new AccountForm());
        return VN_REG_FORM;
    }

    // 3. 등록 처리 (POST)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postRegistrationForm(
            @ModelAttribute("account") @Valid AccountForm form, // from -> form 오타 수정
            BindingResult result) {

        convertPasswordError(result);

        if (result.hasErrors()) {
            return VN_REG_FORM;
        }

        // 실제 비즈니스 로직(예: 서비스 호출)이 여기에 들어갑니다.
        return VN_REG_OK;
    }

    // 비밀번호 불일치 에러를 특정 필드 에러로 변환하는 헬퍼 메서드
    private void convertPasswordError(BindingResult result) {
        for (ObjectError error : result.getGlobalErrors()) {
            String msg = error.getDefaultMessage();
            if ("account.password.mismatch.message".equals(msg)) {
                if (!result.hasFieldErrors("password")) {
                    result.rejectValue("password", "error.mismatch", "비밀번호가 일치하지 않습니다.");
                }
            }
        }
    }
}