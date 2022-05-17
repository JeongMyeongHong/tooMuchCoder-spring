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
 * fileName      :   CheckSameArray
 * author        :   JeongmyeongHong
 * date          :   2022-05-17
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-17      JeongmyoengHong     최초 생성
 */
// 배열 [1, 3, 2], [2, 3, 1] 은아
public class CheckSameArray {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private List<Integer> list;
    }
    @FunctionalInterface interface SolutionService{
        Boolean solution(Solution solution1, Solution solution2);
    }
    @Test
    void testSolution(){
        List<Solution> ls = Arrays.asList(
                Solution.builder().list(Arrays.asList(1, 3, 2)).build(),
                Solution.builder().list(Arrays.asList(2, 3, 1)).build()
        );
        SolutionService sol = (x, y) -> x.getList().containsAll(y.getList());
        System.out.println(sol.solution(ls.get(0), ls.get(1)));
    }
}
