package com.toomuchcoder.api.common.algorithm.algo._heap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * packageName: kr.scalar.api.common.heap
 * fileName   : 더맵게
 * author     : parkjungkwan
 * date       : 2022-05-24
 * desc       : https://programmers.co.kr/learn/courses/30/lessons/42626
 * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을
 * 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
 * <p>
 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
 * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한 사항
 * scoville의 길이는 2 이상 1,000,000 이하입니다.
 * K는 0 이상 1,000,000,000 이하입니다.
 * scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
 * 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
 * <p>
 * 입출력 예
 * scoville	K	return
 * [1, 2, 3, 9, 10, 12]	7	2
 * <p>
 * 입출력 예 설명
 * 스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
 * 새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
 * 가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]
 * <p>
 * 스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
 * 새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
 * 가진 음식의 스코빌 지수 = [13, 9, 10, 12]
 * <p>
 * 모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-24   parkjungkwan  최초 생성
 */
public class 더맵게 {

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
            List<Integer> list = new ArrayList<>();
            Arrays.stream(e.getScoville()).forEach(list::add);
            int len = list.size()-1;

            for (int i = 0; i < len; i++) {
                int a = Collections.min(list);
                list.remove((Integer) a);
                int b = Collections.min(list);
                list.remove((Integer) b);
                int k = a + b * 2;
                list.add(k);
                if (Collections.min(list) >= e.getK()) {
                    return Solution.builder().scoville(e.getScoville()).K(e.getK()).answer(i + 1).build();
                }
            }
            return Solution.builder().scoville(e.getScoville()).K(e.getK()).answer(-1).build();
        };
    }

    @Test
    void testSolution() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 200;
        Solution s = Solution.builder().scoville(scoville).K(K).build();
        System.out.println(new Service().f.solution((s)));
    }
}