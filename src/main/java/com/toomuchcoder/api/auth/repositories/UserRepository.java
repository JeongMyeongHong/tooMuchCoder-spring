package com.toomuchcoder.api.auth.repositories;


import com.toomuchcoder.api.auth.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName   :   com.toomuchcoder.api.repositories
 * fileName      :   UserRepository
 * author        :   JeongmyeongHong
 * date          :   2022-05-03
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-03      JeongmyoengHong     최초 생성
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    String login(User user);

    String put(User user);
}
