package com.toomuchcoder.api.soccer.repositories;

import com.toomuchcoder.api.soccer.domains.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName   :   com.toomuchcoder.api.soccer.repositories
 * fileName      :   Stadium
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 * 2022-05-20      JeongmyoengHong     update 추가
 */
interface StadiumCustomRepository{
    // 000. 전화번호를 변경하도록 하시오.
    String update(Stadium stadium);
}
@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}
