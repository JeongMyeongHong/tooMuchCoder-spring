package com.toomuchcoder.api.controllers;

import com.toomuchcoder.api.services.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName   :   com.toomuchcoder.api.controllers
 * fileName      :   BoardController
 * author        :   JeongmyeongHong
 * date          :   2022-05-04
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-04      JeongmyoengHong     최초 생성
 */
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;
}
