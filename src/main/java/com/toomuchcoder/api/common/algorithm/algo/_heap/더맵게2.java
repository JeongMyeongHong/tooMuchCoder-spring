package com.toomuchcoder.api.common.algorithm.algo._heap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * packageName : com.toomuchcoder.api.common.algorithm.algo._heap
 * fileName : 더맵게2
 * author : JeongMyeongHong
 * date : 2022-06-24
 * desc :
 * ============================================
 * DATE AUTHOR NOTE
 * ============================================
 * 2022-06-24 JeongmyoengHong 최초 생성
 */

public class 더맵게2 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Solution {
        private int[] scoville;
        private int K;
        private int answer;

        @Override
        public String toString() {
            return String.format("scoville : %s\nK : %d\nanswer: %d", Arrays.toString(scoville), K, answer);
        }
    }

    @FunctionalInterface
    private interface SolutionService<T, R> {
        R solution(T t);
    }

    static class Service {
        SolutionService<Solution, Solution> f = e -> {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            Arrays.stream(e.getScoville()).forEach(pq::add);
            int answer = 0;
            while (pq.peek() <= e.getK()) {
                if (pq.size() == 1) {
                    return Solution.builder().scoville(e.getScoville()).K(e.getK()).answer(-1).build();
                }
                int a = pq.poll();
                int b = pq.poll();
                int result = a + (b * 2);
                pq.offer(result);
                answer ++;
            }
            return Solution.builder().scoville(e.getScoville()).K(e.getK()).answer(answer).build();
        };
    }

    @Test
    void testSolution() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        Solution s = Solution.builder().scoville(scoville).K(K).build();
        System.out.println(new Service().f.solution((s)));
    }
}
