package com.toomuchcoder.api.auth.domains;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * packageName   :   com.toomuchcoder.api.security.domains
 * fileName      :   SecurityToken
 * author        :   JeongmyeongHong
 * date          :   2022-05-23
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-23      JeongmyoengHong     최초 생성
 * 2022-05-24      JeongmyoengHong     토큰 발급 작성
 */
@Log
public class AuthToken {
    private String token;
    private String key;

    public AuthToken(String key) {
        this.key = key;
        this.token = createToken();
    }

    private String createToken() {
        try {
            Map<String, Object> headers = new HashMap<>();
            headers.put("typ", "JWT");
            headers.put("alg", "HS256");
            Map<String, Object> payload = new HashMap<>();
            payload.put("data", "blab-la");
            payload.put("", "");
            Date exp = new Date();
            exp.setTime(exp.getTime() + 1000 * 60L * 10L);

            return Jwts.builder() // JWT는 header, payload(sub, iss, iat, exp), signature 3개로 이뤄진다.
                    .setHeader(headers)
                    .setClaims(payload)
                    .setSubject("user") // sub, iss, iat, exp 4개가 합쳐서 payload 이다. payload 요소의 이름을 claim 이라고 한다.
                    .setIssuer("TMC")
                    .setIssuedAt(new Date())
                    .setExpiration(exp)
                    .signWith(SignatureAlgorithm.HS256, key.getBytes())
                    .compact();
        }catch (SecurityException e){log.info("SecurityException JWT");}
        catch (MalformedJwtException e){log.info("MalformedJwtException JWT");}
        catch (ExpiredJwtException e){log.info("ExpiredJwtException JWT");}
        catch (UnsupportedJwtException e){log.info("UnsupportedJwtException JWT");}
        catch (IllegalAccessError e){log.info("IllegalAccessError JWT");}
        return null;
    }
}
