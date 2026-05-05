package com.winter.app.account;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.UUID;

@Service
@RequiredArgsConstructor // 1. 생성자 주입을 위한 Lombok 어노테이션
public class AccountService {

    // 2. final 키워드와 생성자 주입 (Autowired보다 권장되는 방식)
    private final AccountMapper accountMapper;

    @Transactional(rollbackFor = Exception.class) // 3. 트랜잭션 관리 추가
    public int create(AccountDTO accountDTO) throws Exception {
        
        // 4. 계좌번호 생성 로직 개선 (중복 방지 및 포맷팅)
        // 밀리초는 동시에 여러 요청이 올 경우 중복될 수 있으므로 랜덤 요소를 섞습니다.
        String timePart = String.valueOf(System.currentTimeMillis()).substring(8); // 시간 뒷자리
        String randomPart = UUID.randomUUID().toString().substring(0, 4); // 랜덤 4자리
        String accountNum = "110-" + timePart + "-" + randomPart;
        
        accountDTO.setAccountNum(accountNum);

        // 5. 기본값 보장 (잔액이 null일 경우 0으로 설정)
        if (accountDTO.getAccountBalance() == null) {
            accountDTO.setAccountBalance(0L);
        }

        // DB 저장 실행
        return accountMapper.create(accountDTO);
    }
}