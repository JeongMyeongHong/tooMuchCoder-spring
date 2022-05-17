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
 * fileName      :   PrimeNumber
 * author        :   JeongmyeongHong
 * date          :   2022-05-17
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-17      JeongmyoengHong     최초 생성
 */
public class PrimeNumber {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Solution {
        private int start, end;
        private List<Integer> primes;

        @Override
        public String toString() {
            return String.format("%d 부터 %d 까지의 소수는 " + primes + "입니다.", start, end);
        }
    }

    @FunctionalInterface
    interface SolutionService {
        List<Integer> solution(int start, int end);
    }
/**
 *             for (int i = no1; i < no2; i++) {
 *                 for (int j = 2; j <= i; j++) {
 *                     if (j == i) res += String.format("%d ", i);
 *                     else if (i % j == 0) break;
 *                 }
 *             }
 *             */
    @Test
    void testSolution() {
        int start = 1;
        int end = 100;
//        SolutionService s = (x, y) -> {
//            List<Integer> arr = Arrays.asList()
//
//        }
        System.out.println();
    }
}
