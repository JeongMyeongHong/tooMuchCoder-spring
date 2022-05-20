package com.toomuchcoder.api.soccer.services;

import com.toomuchcoder.api.soccer.domains.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.soccer.services
 * fileName      :   PlayerService
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 */
public interface PlayerService {

    String save(Player player);

    List<Player> findAll();

    List<Player> findAll(Sort sort);

    Page<Player> findAll(Pageable pageable);

    Optional<Player> findById(String id);

    boolean existsById(String id);

    long count();

//    String update(Player player);

    String delete(Player player);

    //custom
    List<Player> listFindByPlayerName(String name);
}
