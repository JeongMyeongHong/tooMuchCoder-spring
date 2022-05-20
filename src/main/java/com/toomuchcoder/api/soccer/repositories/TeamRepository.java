package com.toomuchcoder.api.soccer.repositories;

import com.toomuchcoder.api.soccer.domains.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName   :   com.toomuchcoder.api.soccer.repositories
 * fileName      :   TeamRepository
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 * 2022-05-20      JeongmyoengHong     update 추가
 */
interface TeamCustomRepository{
    // 000. 팀의 전화번호와 팩스번호를 수정하시오
    @Query(value= "update teams t set t.tel = :tel, t.fax = :fax where t.team_no = :team_no", nativeQuery = true)
    int update(@Param("tel") String tel, @Param("fax") String fax, @Param("team_no") String team_no);

    // 001. 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오
    @Query(value= "select t.teamName as teamName from Team t order by t.teamName")
    List<String> findTeamNamesAsc();

    String update(Team team);
}
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
