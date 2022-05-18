package com.toomuchcoder.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName   :   com.toomuchcoder.api.common.algorithm
 * fileName      :   FruitsClass
 * author        :   JeongmyeongHong
 * date          :   2022-05-18
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-18      JeongmyoengHong     최초 생성
 */
public class FruitsClass {
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    private static class Solution{
        private int total, apple, grape, orange;

        @Override
        public String toString() {
            return String.format("total: %d, apple: %d, grape: %d, orange: %d", total, apple, grape, orange);
        }
    }

    @FunctionalInterface interface IS{
        String x();
    }

    @Test
    void test(){

    }
}
