package com.green.Security.Test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//이 클래스에서 시큐리티의 인증 및 인가에 대한 설정
@Configuration //클래스에 대한 객체 생성 어노테이션
@EnableWebSecurity //해당 클래스가 Security 설정 클래스임을 인지
public class SecurityConfig {

   /*

     인증 및 인가에 대한 설정 진행하는 메서드
     이러한 메서드는 공식문서에 가이드에 설명된 내용을 토대로 구현

     프로젝트 생성 시 security 를 사용하겠다고 선언만 하면
     우리가 만든 모든 요청에 대해서 인증을 받도록 기본 설정이 되어 있어
     어떠한 페이지로도 접근할 수 없다.

     아래 메서드에서 이증 및 인가 설정을 하게 되면 기본적으로 모든 요청을 막던
     설정이 우리가 작성한 코드의 설정대로 진행하게 된다.

     @Bean 어노테이션은 지금까지와의 어노테이션과 다르게 메서드 위에 작성한다.
     이 어노테이션은 메서드의 리턴 데이터를 객체로 생성하는 기능

   */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        //csrf - Cross-site Request Forgery
        //csrf 공격에 대한 방어기재를 사용하지 않겠다.
        // jwt 로그인은 csrf 공격에 상대적으로 안전하기 떄문에 사용 안 함
        httpSecurity.csrf(auth -> auth.disable());

        //인증 및 인가 설정
        httpSecurity.authorizeHttpRequests(
            auth -> auth.requestMatchers(
                    "/",
                            "/member/loginForm",
                            "/member/joinForm").permitAll() // "/" 요청은 누구나 접근 가능
                    .anyRequest().authenticated() // 나머지 요청은 인증 받아야 접근 가능
        );

        return httpSecurity.build();

    }



}
