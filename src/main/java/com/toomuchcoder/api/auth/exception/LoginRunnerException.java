package com.toomuchcoder.api.auth.exception;

/**
 * packageName   :   com.toomuchcoder.api.auth.exception
 * fileName      :   LoginRunnerException
 * author        :   JeongmyeongHong
 * date          :   2022-05-24
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-24      JeongmyoengHong     최초 생성
 */
public class LoginRunnerException extends RuntimeException {
    private static final long SerializableUID = 1L;

    public LoginRunnerException() {
        super();
    }

    public LoginRunnerException(String msg) {
        super(msg);
    }
}
