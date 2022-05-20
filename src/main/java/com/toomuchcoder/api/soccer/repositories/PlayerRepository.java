package com.toomuchcoder.api.soccer.repositories;

import com.toomuchcoder.api.soccer.domains.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName   :   com.toomuchcoder.api.soccer.repositories
 * fileName      :   PlayerRepository
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 * 2022-05-20      JeongmyoengHong     update 추가
 */
interface PlayerCustomRepository{
    // 000. 키와 몸무게를 변경하시오.
    String update(Player player);
}
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
