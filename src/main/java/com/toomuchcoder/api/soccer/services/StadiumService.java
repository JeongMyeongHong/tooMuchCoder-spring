package com.toomuchcoder.api.soccer.services;

import com.toomuchcoder.api.soccer.domains.Stadium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.soccer.services
 * fileName      :   StadiumService
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 */
public interface StadiumService {

    String save(Stadium stadium);

    List<Stadium> findAll();

    List<Stadium> findAll(Sort sort);

    Page<Stadium> findAll(Pageable pageable);

    Optional<Stadium> findById(String id);

    boolean existsById(String id);

    long count();

//    String update(Stadium stadium);

    String delete(Stadium stadium);

    //custom
    List<Stadium> listFindByStadiumName(String name);
}
