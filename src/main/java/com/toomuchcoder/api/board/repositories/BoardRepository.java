package com.toomuchcoder.api.board.repositories;

import com.toomuchcoder.api.board.domains.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName   :   com.toomuchcoder.api.repositories
 * fileName      :   BoardRepository
 * author        :   JeongmyeongHong
 * date          :   2022-05-04
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-04      JeongmyoengHong     최초 생성
 */
interface BoardCustomRepository{
    // 000. 게시판 이름 boardName 을 변경하시오
}
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
