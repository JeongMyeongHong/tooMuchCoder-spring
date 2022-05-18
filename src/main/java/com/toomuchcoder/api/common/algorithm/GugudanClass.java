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
 * fileName      :   Gugudan
 * author        :   JeongmyeongHong
 * date          :   2022-05-17
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-17      JeongmyoengHong     최초 생성
 */
public class GugudanClass {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private int[][] arr;

        @Override
        public String toString() {
            return String.format("");
        }
    }
    @FunctionalInterface interface IS{
        void solution();
    }

    @Test
    void test() {
        IS f = () -> {};
        for(int k = 2; k < 10; k+=4) {
            for (int i = 1; i < 10; i++) {
                for (int j = k; j < k+4; j++) {
                    System.out.print(j + "*" + i+ "=" +(j*i)+"\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
