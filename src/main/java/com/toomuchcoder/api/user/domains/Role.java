package com.toomuchcoder.api.user.domains;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;

/**
 * packageName   :   com.toomuchcoder.api.auth.domains
 * fileName      :   Role
 * author        :   JeongmyeongHong
 * date          :   2022-05-23
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-23      JeongmyoengHong     최초 생성
 */
@Getter
@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    ADMIN("ROLE_ADMIN", "관리자권한"),
    USER("ROLE_USER", "사용자권한"),
    UNKNOWN_USER("ROLE_UNKNOWN_USER", "알수없는사용자권한")
    ;
    private final String code;

    public static Role of(String code) {
        return Arrays.stream(Role.values()).filter(i -> i.getCode().equals(code))
                .findAny().orElse(UNKNOWN_USER);
    }

    private final String description;

    @Override
    public String getAuthority() {
        return name();
    }
}
