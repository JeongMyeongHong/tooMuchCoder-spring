package com.toomuchcoder.api.common.algorithm.algo._hash;

import lombok.*;
import org.junit.jupiter.api.Test;

/**
 * packageName: kr.scalar.api.common._hash
 * fileName   : 베스트앨범
 * author     : parkjungkwan
 * date       : 2022-05-24
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-24   parkjungkwan  최초 생성
 */
public class 베스트앨범 {
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class Solution{
        @Override
        public String toString(){
            return String.format("");
        }
    }
    @FunctionalInterface private interface SolutionService<T, R>{
        R solution(T t);
    }
    static class Service{
        Solution test(Solution s){
            SolutionService<Solution, Solution> f = e -> {
                return Solution.builder()
                        .build();
            };
            return f.solution(s);
        }
    }
    @Test
    void testSolution(){

        Solution s = Solution.builder()
                .build();

        System.out.println(new Service().test(s));
    }
}
