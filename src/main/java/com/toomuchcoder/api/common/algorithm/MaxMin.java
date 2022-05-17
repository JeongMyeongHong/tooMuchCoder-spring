package com.toomuchcoder.api.common.algorithm;

import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * packageName   :   com.toomuchcoder.api.common.algorithm
 * fileName      :   MaxMin
 * author        :   JeongmyeongHong
 * date          :   2022-05-17
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-17      JeongmyoengHong     최초 생성
 */
public class MaxMin {
    @Getter
    @Builder
    public static class MaxMinVo {
        private List<Integer> nums;
        private int max, min;
        @Override
        public String toString() {
            int max = new maxMinServiceImpl().getMax(nums);
            int min = new maxMinServiceImpl().getMin(nums);
            return String.format("전체 배열은 : " + nums + "\t최대값은 : %d, 최소값은 : %d\n", max, min);
        }
    }

    interface maxMinService {
        int getMin(List<Integer> nums);
        void addMin();
        void addMax();

        int getMax(List<Integer> nums);
    }

    public static class maxMinServiceImpl implements maxMinService {
        private final List<MaxMin> list;

        public maxMinServiceImpl(){ this.list = new ArrayList<>(); }

        @Override
        public int getMin(List<Integer> nums) {
            int tmp = nums.get(0);
            for (int i : nums) {
                if (tmp > i) tmp = i;
            }
            return tmp;
        }

        @Override
        public void addMin() {

        }

        @Override
        public void addMax() {

        }

        @Override
        public int getMax(List<Integer> nums) {
            int tmp = nums.get(0);
            for (int i : nums) {
                if (tmp < i) tmp = i;
            }
            return tmp;
        }
    }

    @Test
    void maxMinTest() {
        List<MaxMinVo> arr = Arrays.asList(
                MaxMinVo.builder().nums(Arrays.asList(3, 1, 9, 5, 10)).build(),
                MaxMinVo.builder().nums(Arrays.asList(4, 2, 8, 6, 0)).build(),
                MaxMinVo.builder().nums(Arrays.asList(33, 99, 53, 65, 42, 10)).build()
        );
        System.out.println(arr);
    }
}
