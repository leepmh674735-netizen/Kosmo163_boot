package com.winter.app.account;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드를 포함한 생성자 추가
@Builder // 빌더 패턴 적용 (객체 생성이 편리해짐)
public class AccountDTO {

    private String accountNum; // 계좌번호
    private String username; // 사용자명
    private Long productNum; // 상품 식별 번호

    // 1. 보안상 비밀번호는 String으로 관리하는 것이 일반적입니다 (암호화 대비)
    private String accountPw;

    // 2. 금액은 Long도 무관하나, 소수점이 필요한 외환/이자 계산 등을 고려한다면
    // BigDecimal을 쓰기도 합니다. 여기서는 일반 정수형 금액으로 유지합니다.
    private Long accountBalance;

    private LocalDate accountDate; // 개설일

}