package com.toomuchcoder.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName   :   com.toomuchcoder.api.common.algorithm
 * fileName      :   CheckSameArrayClass
 * author        :   JeongmyeongHong
 * date          :   2022-05-18
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-18      JeongmyoengHong     최초 생성
 */
public class CheckSameArrayClass {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Solution {
        private int[] a, b;
        private String res;

        @Override
        public String toString() {
            return String.format("A 배열 " + a + ", B 배열 " + b + "은 %s 배열입니다", res);
        }
    }

    @FunctionalInterface
    interface IS<T, R> {
        R solution(T t);
    }

    @Test
    void test() {
        int[] arr1 = {1, 3, 2};
        int[] arr2 = {2, 3, 1};
        Solution s = Solution.builder().a(arr1).b(arr2).build();
        IS<Solution, Solution> f = e -> {
            return Solution.builder().a(e.getA()).b(e.getB()).res("").build();
        };
        System.out.println(f.solution(s));
    }
}
