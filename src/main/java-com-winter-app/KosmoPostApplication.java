package com.winter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class KosmoPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(KosmoPostApplication.class, args);
	}

}