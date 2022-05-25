package com.toomuchcoder.api.user.services;

import com.toomuchcoder.api.auth.configs.AuthProvider;
import com.toomuchcoder.api.auth.domains.Messenger;
import com.toomuchcoder.api.auth.exception.SecurityRuntimeException;
import com.toomuchcoder.api.common.lambdas.Lambda;
import com.toomuchcoder.api.user.domains.Role;
import com.toomuchcoder.api.user.domains.UserDTO;
import com.toomuchcoder.api.user.repositories.UserRepository;
import com.toomuchcoder.api.user.domains.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.toomuchcoder.api.common.lambdas.Lambda.longParse;
import static com.toomuchcoder.api.common.lambdas.Lambda.string;

/**
 * packageName   :   com.toomuchcoder.api.services
 * fileName      :   UserServiceImpl
 * author        :   JeongmyeongHong
 * date          :   2022-05-03
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-03      JeongmyoengHong     최초 생성
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final AuthProvider provider;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO login(User user) {
        try {
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            User findUser = repository.findByUsername(user.getUsername()).orElse(null);
            String pw = repository.findByUsername(user.getUsername()).get().getPassword();
            boolean checkPassword = encoder.matches(user.getPassword(), pw);
            String username = user.getUsername();
            List<Role> roles = findUser.getRoles();
            String token = checkPassword ? provider.createToken(username, roles) : "Wrong Password";
            userDTO.setToken(token);
            return userDTO;
        } catch (Exception e) {
            throw new SecurityRuntimeException("유효하지 않은 아이디/비밀번호", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Messenger count() {
        return Messenger.builder().message(string(repository.count())).build();
    }

    @Override
    public Messenger update(User user) {
        return Messenger.builder().message("Update").build();
    }

    @Override
    public Messenger delete(User user) {
        repository.delete(user);
        return Messenger.builder().message("Bye").build();
    }

    @Override
    public Messenger save(User user) {
        String res = "";
        if (repository.findByUsername(user.getUsername()).isEmpty()) {
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            repository.save(User.builder()
                    .password(encoder.encode(user.getPassword()))
                    .roles(list)
                    .build());
            res = "SUCCESS";
        }else{
            res = "FAIL";
        }
        return Messenger.builder().token(res).build();
    }

    @Override
    public Optional<User> findById(String userid) {
        return repository.findById(0L); // userid 타입이 다름
    }

    @Override
    public Messenger existsById(String userid) {
        return repository.existsById(longParse(userid)) ?
                Messenger.builder().message("EXIST").build()
                : Messenger.builder().message("NOT_EXIST").build();
    }


    //custom
    @Override

    public List<User> listFindByUserName(String name) {
        List<User> ls = repository.findAll();
        Map<String, User> box = new HashMap<>();
        return null;
    }
}
