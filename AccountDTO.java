package com.winter.app.account;

import java.time.LocalDateTime; // 개설 시간까지 기록하기 위해 변경 권장

import lombok.Getter;
import lombok.Setter;
import lombok.ToString; // 디버깅을 위해 추가 권장

@Setter
@Getter
@ToString // 객체의 내용을 로그로 편하게 확인하기 위해 추가
public class AccountDTO {

    private String accountNum; // 계좌번호 (0으로 시작하거나 하이픈이 있을 수 있어 String 유지)
    private String username; // 계좌 소유자 ID
    private Long productNum; // 가입 상품 번호
    private String accountPw; // 비밀번호 (보통 숫자로만 구성되나, 처리 편의상 String 권장)
    private Long accountBalance; // 계좌 잔액
    private LocalDateTime accountDate; // accountData -> accountDate로 오타 수정 및 시간 포함

}