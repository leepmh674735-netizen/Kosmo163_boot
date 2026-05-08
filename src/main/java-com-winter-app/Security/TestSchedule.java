package com.winter.app.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Schduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class TestSchedule {

    @scheduled(fixedRateString = "2000", initialDelay = 1000)
    public void useFixRate() throws Exception {
        System.out.println("고정 간격으로 반복 할 코드");

    }

    @scheduled(fixeDelay = 2000, initialDelaySting = "2000")
    public void userFixDelay() throws Exception {
        System.out.println("고정 간격으로 반복 Delay");

    }
}