package com.toomuchcoder.api.auth.exception;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * packageName   :   com.toomuchcoder.api.auth.exception
 * fileName      :   SecurityRuntimeException
 * author        :   JeongmyeongHong
 * date          :   2022-05-24
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-24      JeongmyoengHong     최초 생성
 */


@Getter
@RequiredArgsConstructor
public class SecurityRuntimeException extends RuntimeException{
    private static final long SerializableUID = 1L;

    private final String msg;
    private final HttpStatus httpStatus;
}
