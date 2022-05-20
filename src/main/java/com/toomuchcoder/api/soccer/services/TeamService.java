package com.toomuchcoder.api.soccer.services;

import com.toomuchcoder.api.soccer.domains.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.soccer.services
 * fileName      :   TeamService
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 */
public interface TeamService {
    String save(Team team);

    List<Team> findAll();

    List<Team> findAll(Sort sort);

    Page<Team> findAll(Pageable pageable);

    Optional<Team> findById(String id);

    boolean existsById(String id);

    long count();

//    String update(Team team);

    String delete(Team team);

    //custom
    List<Team> listFindByTeamName(String name);
}
