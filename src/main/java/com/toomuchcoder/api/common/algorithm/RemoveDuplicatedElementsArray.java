package com.toomuchcoder.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName   :   com.toomuchcoder.api.common.algorithm
 * fileName      :   RemoveDuplicatedElementsArray
 * author        :   JeongmyeongHong
 * date          :   2022-05-17
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-17      JeongmyoengHong     최초 생성
 */
public class RemoveDuplicatedElementsArray {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private List<Integer> list;
    }
    @FunctionalInterface interface SolutionService{
        List<Integer> solution(Solution solution);
    }
    @Test
    void testSolution(){
        Solution solution = Solution.builder().list(Arrays.asList(5, 10, 9, 27, 2, 8, 10, 4, 27, 1)).build();
        SolutionService solutionService = e -> e.getList().stream().distinct().collect(Collectors.toList());
        System.out.println(solutionService.solution((solution)));
    }
}
