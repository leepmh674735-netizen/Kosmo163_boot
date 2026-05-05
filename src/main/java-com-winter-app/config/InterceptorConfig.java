package com.winter.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.winter.app.interceptors.LoginCheckInterceptor;
import com.winter.app.interceptors.WriterCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private LoginCheckInterceptor loginCheckInterceptor;

	@Autowired
	private WriterCheckInterceptor writerCheckInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// member로 시작하는 모든 url, login, join
		// qna list를 제외한 나머지들은 회원만 사용 가능
		// 적용할 Interceptor등로
		// Interceptor를 사용할 URL 패턴 작성, addPathPatterns 여러번 호출 가능
		// Interceptor를 제외할 URL 패턴 작성, excludePathPatterns 여러번 호출 가능
		registry.addInterceptor(loginCheckInterceptor)
				.addPathPatterns("/member/*")
				.addPathPatterns("/qna/*")
				.excludePathPatterns("/member/login", "/member/join")
				.excludePathPatterns("/qna/list");

		registry.addInterceptor(writerCheckInterceptor)
				.addPathPatterns("/notice/update", "/qna/update");

	}

}