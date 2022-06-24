package com.toomuchcoder.api.common.algorithm.algo._hash;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName: kr.scalar.api.common._hash
 * fileName   : 완주하지못한선수
 * author     : parkjungkwan
 * date       : 2022-05-24
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-24   parkjungkwan  최초 생성
 */
public class 완주하지못한선수{
    /**
     * participant	completion	return
     * ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
     * ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
     * ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
     * */
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class Solution{
        private String[] participant,completion;
        private String answer;
        @Override
        public String toString(){
            return String.format("");
        }
    }
    @FunctionalInterface private interface SolutionService<T, R>{
        R solution(T t);
    }
    static class Service{
        Solution test(Solution s){
            SolutionService<Solution, Solution> f = e -> {
                String answer = "";
                return Solution.builder()
                        .participant(e.getParticipant())
                        .completion(e.getCompletion())
                        .answer(answer)
                        .build();
            };
            return f.solution(s);
        }
    }
    @Test
    void testSolution(){
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};

        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};

        Solution s1 = Solution.builder()
                .participant(participant1)
                .completion(completion1)
                .build();
        Solution s2 = Solution.builder()
                .participant(participant2)
                .completion(completion2)
                .build();

        System.out.println(new Service().test(s1));
        System.out.println(new Service().test(s2));
    }
}
