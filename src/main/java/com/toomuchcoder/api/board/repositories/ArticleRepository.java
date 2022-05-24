package com.toomuchcoder.api.board.repositories;

import com.toomuchcoder.api.board.domains.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName   :   com.toomuchcoder.api.board.repositories
 * fileName      :   ArticleRepository
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 */
interface ArticleCustomRepository{
    // 000. title과 content를 수정하시오
//    Article update(Article article);
}
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleCustomRepository{

}
