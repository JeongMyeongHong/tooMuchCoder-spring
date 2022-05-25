package com.toomuchcoder.api.user.repositories;


import com.toomuchcoder.api.user.domains.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

interface UserCustomRepository{
    // 000. 사용자의 비밀번호와 이메일을 수정하시오
    @Query(value = "")
    void update(User user);

    @Query(value = "")
    String login(User user);

    @Query(value = "")
    String put(User user);

}
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String Username);
}


