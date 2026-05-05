package com.winter.app.account;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Optional;

@Mapper
public interface AccountMapper {

    /**
     * 새로운 계좌 생성
     * 
     * @param accountDTO 저장할 계좌 정보
     * @return 성공 시 1, 실패 시 0 반환
     */
    int insertAccount(AccountDTO accountDTO) throws Exception;

    /**
     * 계좌 번호로 특정 계좌 정보 조회
     * 
     * @param accountNum 조회할 계좌번호
     * @return 계좌 정보 (없을 수 있으므로 Optional 사용 권장)
     */
    AccountDTO getAccountDetail(String accountNum) throws Exception;

}