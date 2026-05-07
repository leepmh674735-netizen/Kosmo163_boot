package com.winter.yubin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

// 1. 정적 리소스 보안 제외 (성능 최적화)
@Bean
public WebSecurityCustomizer webSecurityCustomizer() {
return (web) -> web.ignoring()
.requestMatchers("/css/**", "/images/**", "/js/**", "/vendor/**", "/files/**", "/fileDown/**");
}

// 2. 인증 및 인가 상세 설정
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
http
.csrf(csrf -> csrf.disable()) // CSRF 비활성화
.authorizeHttpRequests(auth -> auth
// 공지사항 관리: ADMIN만 가능
.requestMatchers("/notice/create", "/notice/update", "/notice/delete").hasRole("ADMIN")

// Q&A 관리: EMEMBER만 가능
.requestMatchers("/qua/detail", "/qua/create", "/qua/update", "/qua/delete").hasRole("EMEMBER")

// 상품 관리: ADMIN 또는 MANAGER 권한 필요 (hasAnyRole 사용)
.requestMatchers("/product/create", "/product/update", "/product/delete").hasAnyRole("ADMIN", "MANAGER")

// 마이페이지 관련: 권한 상관없이 '로그인'만 하면 접근 가능
.requestMatchers("/member/mypage", "/member/logout", "/member/update").authenticated()

// 그 외 모든 페이지: 누구나 접근 가능
.anyRequest().permitAll()
)

// 3. 로그인 설정 (중복 제거 및 오타 수정)
.formLogin(form -> form
.loginPage("/member/login") // 사용자 정의 로그인 페이지
.loginProcessingUrl("/member/login") // POST 로그인 처리 URL
.defaultSuccessUrl("/") // 성공 시 이동 경로
.failureUrl("/member/login?error=true") // 실패 시 이동 경로
.permitAll()
)

// 4. 로그아웃 설정
.logout(logout -> logout
.logoutUrl("/member/logout")
.logoutSuccessUrl("/")
.invalidateHttpSession(true)
.deleteCookies("JSESSIONID")
);

return http.build();
}

// 5. 패스워드 암호화 빈
@Bean
public PasswordEncoder passwordEncoder() {
return new BCryptPasswordEncoder();
}
}