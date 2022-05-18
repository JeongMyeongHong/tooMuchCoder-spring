package com.toomuchcoder.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * packageName   :   com.toomuchcoder.api.common.algorithm
 * fileName      :   Fruites
 * author        :   JeongmyeongHong
 * date          :   2022-05-17
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-17      JeongmyoengHong     최초 생성
 */
public class Fruits {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Solution {
        int apple;
        int grape;
        int orange;
    }
    @FunctionalInterface interface IS<T, R>{
        R solution(T t);
    }
    @Test
    void testSolution(){
        List<Solution> ls = Arrays.asList(
                Solution.builder().apple(10000).grape(20000).orange(12000).build(),
                Solution.builder().apple(8000).grape(3000).orange(15000).build(),
                Solution.builder().apple(20000).grape(15000).orange(38000).build(),
                Solution.builder().apple(13000).grape(20000).orange(30000).build(),
                Solution.builder().apple(30000).grape(12000).orange(20000).build(),
                Solution.builder().apple(35000).grape(30000).orange(25000).build(),
                Solution.builder().apple(50000).grape(23000).orange(10000).build()
        );
        IS<List<Solution>, String> s = e -> {
            int apple = 0;
            int grape = 0;
            int orange = 0;
            for (Solution solution : e){
                apple += solution.getApple();
                grape += solution.getGrape();
                orange += solution.getOrange();
            }
            return String.format("총합 : %d\n사과 평균 : %d\n포도 평균 : %d\n오렌지 평균 : %d\n",
                    apple + grape + orange, apple/e.size(), grape/e.size(), orange/e.size());
        };

        System.out.println(s.solution(ls));
    }
}
