package com.toomuchcoder.api.soccer.services;

import com.toomuchcoder.api.soccer.domains.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.soccer.services
 * fileName      :   ScheduleService
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 */
public interface ScheduleService {

    String save(Schedule schedule);

    List<Schedule> findAll();

    List<Schedule> findAll(Sort sort);

    Page<Schedule> findAll(Pageable pageable);

    Optional<Schedule> findById(String id);

    boolean existsById(String id);

    long count();

//    String update(Schedule schedule);

    String delete(Schedule schedule);

    //custom
    List<Schedule> listFindByScheduleName(String name);
}
