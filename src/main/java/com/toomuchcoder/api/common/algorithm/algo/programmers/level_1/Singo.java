package com.toomuchcoder.api.common.algorithm.algo.programmers.level_1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * packageName   :   com.toomuchcoder.api.common.algorithm.algo
 * fileName      :   Singo
 * author        :   JeongmyeongHong
 * date          :   2022-06-11
 * desc          :   신고 결과 받기
 *                  https://programmers.co.kr/learn/courses/30/lessons/92334?language=java
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-06-11      JeongmyoengHong     최초 생성
 */
public class Singo {
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class Solution{
        private String[] id_list, report, result;
        private int k;

        @Override
        public String toString(){
            return String.format("id_list : %s\n" +
                            "report : %s\n" +
                            "result : %s",
                    Arrays.toString(id_list), Arrays.toString(report), Arrays.toString(result));
        }
    }
    @FunctionalInterface private interface SolutionService<T, R>{
        R solution(T t);
    }
    static class Service{
        Solution test(Solution s){
            SolutionService<Solution, Solution> f = e -> {
                String[] answer = {};
                List<String> splitReport = new ArrayList<>();
                HashMap<String, String> map = new HashMap<>();
                for (String report: e.getReport()){
//                    Arrays.asList(report.split(" ")).forEach(splitReport::add);
                    splitReport.addAll(Arrays.asList(report.split(" ")));
                    map.put(report.split(" ")[0], report.split(" ")[1]);
                }
                System.out.println(splitReport);
                System.out.println(map);
                return Solution.builder()
                        .id_list(e.getId_list())
                        .report(e.getReport())
                        .k(e.getK())
                        .result(answer)
                        .build();
            };
            return f.solution(s);
        }
    }
    @Test
    void testSolution(){
        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k1 = 2;
        // retult = [2,1,1,0]
        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;
        // retult = [0,0]

        Solution s1 = Solution.builder()
                .id_list(id_list1)
                .report(report1)
                .k(k1)
                .build();

        Solution s2 = Solution.builder()
                .id_list(id_list2)
                .report(report2)
                .k(k1)
                .build();

        System.out.println(new Service().test(s1));
//        System.out.println(new Service().test(s2));
    }
}
