package com.toomuchcoder.api.auth.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * packageName   :   com.toomuchcoder.api.config
 * fileName      :   WebSecurityConfig
 * author        :   JeongmyeongHong
 * date          :   2022-05-23
 * desc          :  외부 보안.
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-23      JeongmyoengHong     최초 생성
 */
@Configuration
public class AuthConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "*/**") //antMatchers  **는 폴더(디렉토리 이름) *는 파일 이름
                .antMatchers("/"); //홈은 보안 허용해줌.
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();//csrf가 뚫려서 막아버림.
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 우리는 무상태로 갈꺼다.
        http.authorizeRequests()
                .antMatchers("/users/join").permitAll()
                .antMatchers("/users/login").permitAll() // 이 두개 경로로 오는것은 허용 해준다.
                .anyRequest().authenticated(); // 나머지 요청들은 인가된것만 들어온다.
        http.exceptionHandling().accessDeniedPage("/users/login"); //그 외 전부 로그인 화면으로 보내버림.
    }
}
