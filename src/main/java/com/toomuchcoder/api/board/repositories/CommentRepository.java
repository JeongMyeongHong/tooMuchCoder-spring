package com.toomuchcoder.api.board.repositories;

import com.toomuchcoder.api.board.domains.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName   :   com.toomuchcoder.api.board.repositories
 * fileName      :   CommentRepository
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 */
interface CommentCustomRepository{

}
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, CommentCustomRepository{
}
