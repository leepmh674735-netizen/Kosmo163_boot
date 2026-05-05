package com.winter.app.aop.test;

import org.springframework.stereotype.Component;

@Component
public class Transport {

    // 1. 매개변수와 리턴값이 모두 있는 케이스 (Before, AfterReturning, Around 테스트용)
    public int takeBus(int num) {
        System.out.println(">>> [핵심 로직] " + num + "번 버스 운행 중...");
        return 2000;
    }

    public String takeSubway(String color) {
        System.out.println(">>> [핵심 로직] " + color + "선 지하철 운행 중...");
        return "subway";
    }

    // 2. 리턴값이 없는 케이스
    public void useTaxi() {
        System.out.println(">>> [핵심 로직] 택시 이용 중");
    }

    // 3. 예외(Exception) 발생 케이스 (AfterThrowing 테스트를 위해 추가 권장)
    public void walk() {
        System.out.println(">>> [핵심 로직] 걷는 중...");
        // 테스트용 예외 발생 시나리오 (예: 가다가 넘어짐)
        // if(true) { throw new RuntimeException("도보 중 에러 발생!"); }
    }
}