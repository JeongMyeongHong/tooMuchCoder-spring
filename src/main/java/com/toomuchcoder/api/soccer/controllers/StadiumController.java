package com.toomuchcoder.api.soccer.controllers;

import com.toomuchcoder.api.soccer.domains.Stadium;
import com.toomuchcoder.api.soccer.services.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.soccer.controllers
 * fileName      :   StadiumController
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
@RequestMapping("/stadium")
public class StadiumController {
    private final StadiumService service;

    @GetMapping("/logout")
    public String logout(){
        return null;
    }
    @GetMapping("/findAll")
    public List<Stadium> findAll() {
        return service.findAll();
    }
    @GetMapping("/findAll/sort")
    public List<Stadium> findAll(Sort sort) {
        return service.findAll(sort);
    }
    @GetMapping("/findAll/pageable")
    public Page<Stadium> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
    @GetMapping("/count")
    public long count() {
        return service.count();
    }
    @DeleteMapping("/delete")
    public String delete(@RequestBody Stadium stadium) {
        return service.delete(stadium);
    }
    @PostMapping("/save")
    public String save(@RequestBody Stadium stadium) {
        return service.save(stadium);
    }
    @GetMapping("/findById/{id}")
    public Optional<Stadium> findById(@PathVariable String id) {
        return service.findById(id);
    }
    @GetMapping("/existsById/{id}")
    public boolean existsById(@PathVariable String id) {
        return service.existsById(id);
    }
}
