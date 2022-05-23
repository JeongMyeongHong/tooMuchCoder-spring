package com.toomuchcoder.api.security.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

/**
 * packageName   :   com.toomuchcoder.api.config
 * fileName      :   SecurityConfig
 * author        :   JeongmyeongHong
 * date          :   2022-05-23
 * desc          :  내부 보안
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-23      JeongmyoengHong     최초 생성
 */
@RequiredArgsConstructor
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> { //어댑터 내부는 공개 안함. 해커가 공격할꺼임.. 뚫리면 바꿔줘야 한다. 어댑터만 바꿔버리면 새로운 보안시스템이 된다.
//    private final

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        super.configure(builder);
    }
}
