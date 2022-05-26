package com.toomuchcoder.api.user.services;

import com.toomuchcoder.api.auth.configs.AuthProvider;
import com.toomuchcoder.api.auth.domains.Messenger;
import com.toomuchcoder.api.auth.exception.SecurityRuntimeException;
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

import static com.toomuchcoder.api.common.lambdas.Lambda.*;

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
    public UserDTO login(UserDTO paramUser) {
        try {
            UserDTO returnUser = new UserDTO();
            User findUser = repository.findByUsername(paramUser.getUsername()).orElse(null);
            String username = paramUser.getUsername();
            if (findUser != null){
                boolean checkPassword = encoder.matches(paramUser.getPassword(), findUser.getPassword());
                if (checkPassword){
                    returnUser = modelMapper.map(findUser, UserDTO.class);
                    String token = provider.createToken(username, returnUser.getRoles());
                    returnUser.setToken(token);
                } else{
                    returnUser.setToken("WrongPW");
                }
            }else{
                returnUser.setToken("NotExitsID");
            }
            return returnUser;
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
    public Messenger save(UserDTO user) {
        String res = "";
        if (repository.findByUsername(user.getUsername()).isEmpty()) {
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            repository.save(User.builder()
                            .username(user.getUsername())
                            .password(encoder.encode(user.getPassword()))
                            .name(user.getName())
                            .email(user.getEmail())
                            .regDate(user.getRegDate())
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
