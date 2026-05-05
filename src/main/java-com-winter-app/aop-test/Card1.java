package com.winter.app.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class Card {

    // 1. Pointcut 표현식: (리턴타입 패키지.클래스.메서드(파라미터))
    // Transport 클래스의 take로 시작하는 모든 메서드를 대상으로 합니다.
    @Around("execution(* com.winter.app.aop.test.Transport.take*(..))")
    public Object cardCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // [전처리] 타겟 메서드 실행 전 로직
        log.info("======= 승차: 카드 체크 =======");

        // 매개변수 확인 (Arrays.toString을 사용하면 배열 내용을 가독성 있게 출력 가능)
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("전달 인자(Args): {}", Arrays.toString(args));

        Object result = null;
        try {
            // [타겟 실행] 실제 메서드(takeBus, takeSubway 등) 호출
            result = proceedingJoinPoint.proceed();

            // [후처리] 정상 종료 시 실행
            log.info("반환 값(Return): {}", result);
        } catch (Throwable e) {
            // [예외 처리] 에러 발생 시 로그 남기기
            log.error("이용 중 에러 발생: {}", e.getMessage());
            throw e; // 예외를 다시 던져서 비즈니스 로직에 전달
        } finally {
            // [공통 후처리] 성공/실패 여부와 상관없이 항상 실행 (하차 처리 보장)
            log.info("======= 하차: 카드 체크 =======");
        }

        return result;
    }
}