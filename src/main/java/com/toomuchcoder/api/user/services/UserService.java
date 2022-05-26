package com.toomuchcoder.api.user.services;

import com.toomuchcoder.api.auth.domains.Messenger;
import com.toomuchcoder.api.user.domains.User;
import com.toomuchcoder.api.user.domains.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.services
 * fileName      :   UserService
 * author        :   JeongmyeongHong
 * date          :   2022-05-03
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-03      JeongmyoengHong     최초 생성
 */
public interface UserService {
    UserDTO login(UserDTO user);

    List<User> findAll();

    List<User> findAll(Sort sort);

    Page<User> findAll(Pageable pageable);

    Messenger count();

    Messenger update(User user);

    Messenger delete(User user);

    Messenger save(UserDTO user);

    Optional<User> findById(String userid);

    Messenger existsById(String userid);

    //custom

    List<User> listFindByUserName(String name);
}
