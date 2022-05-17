package com.toomuchcoder.api.common.algorithm;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * packageName   :   com.toomuchcoder.api.common.algorithm
 * fileName      :   MaxMinClass
 * author        :   JeongmyeongHong
 * date          :   2022-05-17
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-17      JeongmyoengHong     최초 생성
 */
public class MaxMinClass {
    @Builder @Getter
    @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private List<Integer> arr;
        private int max, min, elem;

        @Override
        public String toString() {
            return String.format("전체 배열은 : " + arr + "\t최대값은 : %d, 최소값은 : %d\n", max, min);
        }
    }

    @FunctionalInterface private interface SolutionService<T, R>{
        R solution(T t);
    }

    @Test
    void testSolution(){
        SolutionService<Solution, Solution> f = e ->{
            int min = e.getArr().get(0);
            int max = e.getArr().get(0);
            for (int i : e.getArr()) {
                if (min > i) min = i;
                if (max < i) max = i;
            }
            return Solution.builder().arr(e.getArr()).min(min).max(max).build();
        };
        Solution s = Solution.builder().arr(Arrays.asList(3, 1, 9, 5, 10)).build();
        System.out.println(f.solution(s));
    }
}
