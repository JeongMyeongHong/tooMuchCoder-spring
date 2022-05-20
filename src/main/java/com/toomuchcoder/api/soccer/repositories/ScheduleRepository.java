package com.toomuchcoder.api.soccer.repositories;

import com.toomuchcoder.api.soccer.domains.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName   :   com.toomuchcoder.api.soccer.repositories
 * fileName      :   ScheduleRepository
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 * 2022-05-20      JeongmyoengHong     update 추가
 */

interface ScheduleCustomRepository{
    // 000. 스케줄 날짜만 수정이 되도록 하시오
    String update(Schedule schedule);
}
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
