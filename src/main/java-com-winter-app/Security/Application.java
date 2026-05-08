package com.winter.app.schedule;

import org.springframework.boot.springApplication;
import org.springframework.boot.autonconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringBootApplication.run(AppApplication.class, args);

        System.out.println("스케줄러 애플리케이션이 시작되었습니다.")
    }
}