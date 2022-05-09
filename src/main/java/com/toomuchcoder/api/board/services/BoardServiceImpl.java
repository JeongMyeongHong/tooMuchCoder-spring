package com.toomuchcoder.api.board.services;

import com.toomuchcoder.api.board.repositories.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName   :   com.toomuchcoder.api.services
 * fileName      :   BoardServiceImpl
 * author        :   JeongmyeongHong
 * date          :   2022-05-04
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-04      JeongmyoengHong     최초 생성
 */
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository repository;
}
