package com.toomuchcoder.api.soccer.controllers;

import com.toomuchcoder.api.soccer.domains.Schedule;
import com.toomuchcoder.api.soccer.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName   :   com.toomuchcoder.api.soccer.controllers
 * fileName      :   ScheduleController
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
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleService service;

    @GetMapping("/logout")
    public String logout(){
        return null;
    }
    @GetMapping("/findAll")
    public List<Schedule> findAll() {
        return service.findAll();
    }
    @GetMapping("/findAll/sort")
    public List<Schedule> findAll(Sort sort) {
        return service.findAll(sort);
    }
    @GetMapping("/findAll/pageable")
    public Page<Schedule> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
    @GetMapping("/count")
    public long count() {
        return service.count();
    }
    @DeleteMapping("/delete")
    public String delete(@RequestBody Schedule schedule) {
        return service.delete(schedule);
    }
    @PostMapping("/save")
    public String save(@RequestBody Schedule schedule) {
        return service.save(schedule);
    }
    @GetMapping("/findById/{id}")
    public Optional<Schedule> findById(@PathVariable String id) {
        return service.findById(id);
    }
    @GetMapping("/existsById/{id}")
    public boolean existsById(@PathVariable String id) {
        return service.existsById(id);
    }
}
