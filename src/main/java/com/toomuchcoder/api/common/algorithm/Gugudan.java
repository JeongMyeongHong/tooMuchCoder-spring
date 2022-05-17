package com.toomuchcoder.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * packageName   :   com.toomuchcoder.api.common.algorithm
 * fileName      :   Gugudan
 * author        :   JeongmyeongHong
 * date          :   2022-05-17
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-17      JeongmyoengHong     최초 생성
 */
// 혜민
public class Gugudan {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private List<Integer> list;
    }
    @FunctionalInterface interface SolutionService{
        String solution();
    }
    @Test
    void testSolution(){

    }
}
