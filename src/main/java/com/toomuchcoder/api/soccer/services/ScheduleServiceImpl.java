package com.toomuchcoder.api.soccer.services;

import com.toomuchcoder.api.common.dataStructure.Box;
import com.toomuchcoder.api.soccer.domains.Schedule;
import com.toomuchcoder.api.soccer.repositories.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.soccer.services
 * fileName      :   ScheduleImpl
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
public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleRepository repository;
    
    @Override
    public String save(Schedule schedule) {
        repository.save(schedule);
        return null;
    }

    @Override
    public List<Schedule> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Schedule> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Schedule> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Schedule> findById(String id) {
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
//    public String update(Schedule schedule) {
//        return repository.update(schedule);
//    }

    @Override
    public String delete(Schedule schedule) {
        repository.delete(schedule);
        return null;
    }

    //custom
    @Override
    public List<Schedule> listFindByScheduleName(String name) {
        List<Schedule> ls = repository.findAll();
        Box<String, Schedule> box = new Box<>();
        return null;
    }
}
