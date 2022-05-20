package com.toomuchcoder.api.soccer.services;

import com.toomuchcoder.api.common.dataStructure.Box;
import com.toomuchcoder.api.soccer.domains.Stadium;
import com.toomuchcoder.api.soccer.repositories.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.soccer.services
 * fileName      :   StadiumServiceImpl
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
public class StadiumServiceImpl implements StadiumService{
    private final StadiumRepository repository;


    @Override
    public String save(Stadium stadium) {
        repository.save(stadium);
        return null;
    }

    @Override
    public List<Stadium> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Stadium> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Stadium> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Stadium> findById(String id) {
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
//    public String update(Stadium stadium) {
//        return repository.update(stadium);
//    }

    @Override
    public String delete(Stadium stadium) {
        repository.delete(stadium);
        return null;
    }

    //custom
    @Override
    public List<Stadium> listFindByStadiumName(String name) {
        List<Stadium> ls = repository.findAll();
        Box<String, Stadium> box = new Box<>();
        return null;
    }
}
