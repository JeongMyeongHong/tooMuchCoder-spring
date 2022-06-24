package com.toomuchcoder.api.common.algorithm.algo._hash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * packageName : com.toomuchcoder.api.common.algorithm.algo._hash
 * fileName : 베스트앨범
 * author : JeongMyeongHong
 * date : 2022-06-24
 * desc :
 * ============================================
 * DATE AUTHOR NOTE
 * ============================================
 * 2022-06-24 JeongmyoengHong 최초 생성
 */
public class 베스트앨범 {
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    static class Solution{
        private int a;
        @Override
        public String toString() {
            return "Solution{}";
        }
    }

    @FunctionalInterface private interface SolutionService<T, R>{
        R solution(T t);
    }
    static class Service{
        Solution test(Solution s){
            SolutionService<Solution, Solution> f = e -> {
                return Solution.builder().build();
            };
            return f.solution(s);
        }
    }
    @Test
    public void testSolution(){
    }
}
