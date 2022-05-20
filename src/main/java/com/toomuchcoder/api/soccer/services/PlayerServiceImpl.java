package com.toomuchcoder.api.soccer.services;

import com.toomuchcoder.api.soccer.domains.Player;
import com.toomuchcoder.api.common.dataStructure.Box;
import com.toomuchcoder.api.soccer.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.soccer.services
 * fileName      :   PlayerServiceImpl
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
public class PlayerServiceImpl implements PlayerService{
    private final PlayerRepository repository;

    @Override
    public String save(Player player) {
        repository.save(player);
        return null;
    }

    @Override
    public List<Player> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Player> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Player> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Player> findById(String id) {
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
//    public String update(Player player) {
//        return repository.update(player);
//    }

    @Override
    public String delete(Player player) {
        repository.delete(player);
        return null;
    }

    //custom
    @Override
    public List<Player> listFindByPlayerName(String name) {
        List<Player> ls = repository.findAll();
        Box<String, Player> box = new Box<>();
        return null;
    }
}
