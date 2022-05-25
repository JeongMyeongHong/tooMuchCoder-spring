package com.toomuchcoder.api.auth.filter;

import com.toomuchcoder.api.auth.domains.Messenger;
import com.toomuchcoder.api.auth.exception.ErrorCode;
import com.toomuchcoder.api.auth.exception.LoginRunnerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * packageName   :   com.toomuchcoder.api.auth.filter
 * fileName      :   AuthException
 * author        :   JeongmyeongHong
 * date          :   2022-05-25
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-25      JeongmyoengHong     최초 생성
 */
@Slf4j // 로그 찍기 롬복꺼. @Log 와 같음.
@ControllerAdvice // 컨트롤러보다 먼저 동작.
public class AuthExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Messenger> handleRuntimeException(RuntimeException e){
        log.info("handleRuntimeException", e);

        return new ResponseEntity<>(Messenger.builder()
                .code("teat")
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(SecurityException.class)
    protected ResponseEntity<Messenger> handleSecurityException(SecurityException e){
        log.info("handleSecurityException",e);

        return new ResponseEntity<>(Messenger.builder()
                .code(ErrorCode.AUTHENTICATION_FAILED.getCode())
                .message(e.getMessage())
                .status(ErrorCode.AUTHENTICATION_FAILED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(LoginRunnerException.class)
    protected ResponseEntity<Messenger> handleLoginRunnerException(LoginRunnerException e){
        log.info("handleLoginRunnerException",e);

        return new ResponseEntity<>(Messenger.builder()
                .code(ErrorCode.LOGIN_FAILED.getCode())
                .message(ErrorCode.LOGIN_FAILED.getMsg())
                .status(ErrorCode.LOGIN_FAILED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<Messenger> handleBadCredentialsException(BadCredentialsException e){
        log.info("handleBadCredentialsException",e);

        return new ResponseEntity<>(Messenger.builder()
                .code(ErrorCode.ACCESS_DENIED.getCode())
                .message(ErrorCode.ACCESS_DENIED.getMsg())
                .status(ErrorCode.ACCESS_DENIED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<Messenger> handleAccessDeniedException(AccessDeniedException e){
        log.info("handleAccessDeniedException",e);

        return new ResponseEntity<>(Messenger.builder()
                .code(ErrorCode.ACCESS_DENIED.getCode())
                .message(ErrorCode.ACCESS_DENIED.getMsg())
                .status(ErrorCode.ACCESS_DENIED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    protected ResponseEntity<Messenger> handleInsufficientAuthenticationException(InsufficientAuthenticationException e){
        log.info("handleAInsufficientAuthenticationException",e);

        return new ResponseEntity<>(Messenger.builder()
                .code(ErrorCode.AUTHENTICATION_FAILED.getCode())
                .message(ErrorCode.AUTHENTICATION_FAILED.getMsg())
                .status(ErrorCode.AUTHENTICATION_FAILED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }
}
