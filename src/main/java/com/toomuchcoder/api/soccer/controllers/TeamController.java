package com.toomuchcoder.api.soccer.controllers;

import com.toomuchcoder.api.soccer.domains.Team;
import com.toomuchcoder.api.soccer.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.soccer.controllers
 * fileName      :   TeamController
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {
    private final TeamService service;

    @GetMapping("/logout")
    public String logout(){
        return null;
    }
    @GetMapping("/findAll")
    public List<Team> findAll() {
        return service.findAll();
    }
    @GetMapping("/findAll/sort")
    public List<Team> findAll(Sort sort) {
        return service.findAll(sort);
    }
    @GetMapping("/findAll/pageable")
    public Page<Team> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
    @GetMapping("/count")
    public long count() {
        return service.count();
    }
    @DeleteMapping("/delete")
    public String delete(@RequestBody Team team) {
        return service.delete(team);
    }
    @PostMapping("/save")
    public String save(@RequestBody Team team) {
        return service.save(team);
    }
    @GetMapping("/findById/{id}")
    public Optional<Team> findById(@PathVariable String id) {
        return service.findById(id);
    }
    @GetMapping("/existsById/{id}")
    public boolean existsById(@PathVariable String id) {
        return service.existsById(id);
    }
}
