package com.toomuchcoder.api.auth.domains;

import lombok.Builder;
import lombok.Getter;

/**
 * packageName   :   com.toomuchcoder.api.security.domains
 * fileName      :   Messenger
 * author        :   JeongmyeongHong
 * date          :   2022-05-23
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-23      JeongmyoengHong     최초 생성
 */
@Getter @Builder
public class Messenger { //이 모듈은 스프링이 알면 안좋다. 보안이 안좋아짐. 그래서 @Component를 걸지 않아서 스프링이 모르게 한다.
    private String message, code;
    private int status;
}
