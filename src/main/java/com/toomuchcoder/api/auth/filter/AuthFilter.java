package com.toomuchcoder.api.auth.filter;

import com.toomuchcoder.api.auth.configs.AuthProvider;
import com.toomuchcoder.api.auth.exception.SecurityRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName   :   com.toomuchcoder.api.auth.filter
 * fileName      :   AuthFilter
 * author        :   JeongmyeongHong
 * date          :   2022-05-25
 * desc          :  필터는 프로바이더가 발급한 토큰을 알고있다.
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-25      JeongmyoengHong     최초 생성
 */

@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {
    private final AuthProvider provider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = provider.resolveToken(request);
        try{
            if(token != null && provider.validateToken(token)){
                Authentication auth = provider.getAuthentication(token);
                SecurityContextHolder.clearContext();
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }catch (SecurityRuntimeException ex) {
            //this is very important, since it guarantees the user is not authenticated at all
            SecurityContextHolder.clearContext();
            response.sendError(ex.getHttpStatus().value(), ex.getMessage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        filterChain.doFilter(request, response);
    }
}
