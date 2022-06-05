package com.toomuchcoder.api.common.algorithm.algo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * packageName   :   com.toomuchcoder.api.common.algorithm.algo
 * fileName      :   KNumberList
 * author        :   JeongmyeongHong
 * date          :   2022-06-05
 * desc          :  https://programmers.co.kr/learn/courses/30/lessons/42748?language=java
 *      K 번째 수.
 *      배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 *      예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
 *      array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
 *      1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
 *      2에서 나온 배열의 3번째 숫자는 5입니다.
 *      배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
 *      commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때
 *      나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 *      입출력 예
 *      array	                commands	                        return
 *      [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-06-05      JeongmyoengHong     최초 생성
 */

public class KNumberList {
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class Solution{
        private List<Integer> array, aReturn;
        private List<List<Integer>> commands;

        @Override
        public String toString(){
            return String.format("array : %s\n" +
                    "commands : %s\n" +
                    "실행 결과 : %s", array, commands, aReturn);
        }
    }
    @FunctionalInterface private interface ISolution<T, R>{
        R solution(T t);
    }
    @Test
    void testSolution(){
        List<Integer> array = Arrays.asList(1, 5, 2, 6, 3, 7, 4);
        List<List<Integer>> commands = Arrays.asList(Arrays.asList(2, 5, 3),
                                        Arrays.asList(4, 4, 1),
                                        Arrays.asList(1, 7, 3));
        Solution s = Solution.builder()
                .array(array)
                .commands(commands)
                .build();

        ISolution<Solution, Solution> f = e -> {

            return Solution.builder()
                    .array(e.getArray())
                    .commands(e.getCommands())
                    .aReturn(null)
                    .build();
        };

        System.out.println(f.solution(s));
    }
}
