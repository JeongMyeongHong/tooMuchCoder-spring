package com.toomuchcoder.api.auth.services;

import com.toomuchcoder.api.user.domains.User;
import com.toomuchcoder.api.user.repositories.UserRepository;
import com.toomuchcoder.api.auth.domains.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.security.domains
 * fileName      :   UserDetailsServiceImpl
 * author        :   JeongmyeongHong
 * date          :   2022-05-23
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-23      JeongmyoengHong     최초 생성
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException(username + "에 해당하는 객체가 존재하지 않습니다.")) ;
        return Auth.build(user.get());
    }
}
