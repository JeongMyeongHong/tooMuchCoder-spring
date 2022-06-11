package com.toomuchcoder.api.common.algorithm.algo;

import java.util.stream.IntStream;

/**
 * packageName   :   com.toomuchcoder.api.common.algorithm.algo
 * fileName      :   Test
 * author        :   JeongmyeongHong
 * date          :   2022-06-11
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-06-11      JeongmyoengHong     최초 생성
 */
public class Test {
    public int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(i -> a[i]*b[i]).sum();
    }
}
