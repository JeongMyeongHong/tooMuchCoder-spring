package com.toomuchcoder.api.soccer.services;

import com.toomuchcoder.api.common.dataStructure.Box;
import com.toomuchcoder.api.soccer.domains.Team;
import com.toomuchcoder.api.soccer.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.soccer.services
 * fileName      :   TeamServiceImpl
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 */
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{
    private final TeamRepository repository;

    @Override
    public String save(Team team) {
        repository.save(team);
        return null;
    }

    @Override
    public List<Team> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Team> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Team> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Team> findById(String id) {
        return repository.findById(0L);
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(0L);
    }

    @Override
    public long count() {
        return repository.count();
    }

//    @Override
//    public String update(Team team) {
//        return repository.update(team);
//    }

    @Override
    public String delete(Team team) {
        repository.delete(team);
        return null;
    }

    //custom
    @Override
    public List<Team> listFindByTeamName(String name) {
        List<Team> ls = repository.findAll();
        Box<String, Team> box = new Box<>();
        return null;
    }
}
