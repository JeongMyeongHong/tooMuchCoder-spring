package com.toomuchcoder.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * packageName   :   com.toomuchcoder.api.controllers
 * fileName      :   HomeController
 * author        :   JeongmyeongHong
 * date          :   2022-05-03
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-03      JeongmyoengHong     최초 생성
 */
@RestController
public class HomeController {
    @GetMapping("/")
    public String now(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
