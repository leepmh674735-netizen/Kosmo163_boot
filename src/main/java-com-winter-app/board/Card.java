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

    // 1. Pointcut을 상수로 분리하거나 메서드로 선언하면 재사용성이 좋아집니다.
    // 2. execution 문법: (리턴타입 패키지.클래스.메서드(파라미터))
    @Around("execution(* com.winter.app.aop.test.Transport.take*(..))")
    public Object cardCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // [전처리] 타겟 메서드 실행 전 로직
        log.info("======= 승차: 카드 체크 =======");

        // 매개변수 확인 (Arrays.toString을 사용하면 배열 내용을 예쁘게 출력 가능)
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("전달 인자(Args): {}", Arrays.toString(args));

        Object result = null;
        try {
            // [타겟 실행] 실제 메서드(takeBus 등) 호출
            result = proceedingJoinPoint.proceed();

            // [후처리] 정상 종료 시 실행
            log.info("반환 값(Return): {}", result);
        } catch (Throwable e) {
            // [예외 처리] 에러 발생 시 로그 남기기
            log.error("이용 중 에러 발생: {}", e.getMessage());
            throw e; // 에러를 다시 던져서 서비스 로직에 알림
        } finally {
            // [공통 후처리] 성공/실패 여부와 상관없이 항상 실행
            log.info("======= 하차: 카드 체크 =======");
        }

        return result;
    }
}