package com.toomuchcoder.api.common.algorithm.algo._binSearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * packageName: kr.scalar.api.common._binSearch
 * fileName   : 떡볶이떡만들기
 * author     : parkjungkwan
 * date       : 2022-05-24
 * desc       : https://velog.io/@yellowsummer/Algorithm%EC%9D%B4%EA%B2%83%EC%9D%B4-%EC%BD%94%EB%94%A9-%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%8B%A4%EC%9D%B4%EC%A7%84-%ED%83%90%EC%83%89%EB%96%A1%EB%B3%B6%EC%9D%B4-%EB%96%A1-%EB%A7%8C%EB%93%A4%EA%B8%B0
 * 오늘 동빈이는 여행 가신 부모님을 대신해서 떡집 일을 하기로 했다. 오늘은 떡볶이 떡을 만드는 날이다.
 * 동빈이네 떡볶이 떡은 재밌게도 떡볶이 떡의 길이가 일정하지 않다. 대신에 한 봉지 안에 들어 가는 떡의 총 길이는 절단기로 잘라서 맞춰준다.
 * 절단기에 높이(H)를 지정하면 줄지어진 떡을 한 번에 절단한다. 높이가 H보다 긴 떡은 H 위의 부분이 잘릴 것이고, 낮은 떡은 잘리지 않는다.
 * 예를 들어 높이가 19, 14, 10, 17cm인 떡이 나란히 있고 절단기 높이를 15cm로 지정하면 자른 뒤 떡의 높이는 15, 14, 10, 15cm가 될 것이다.
 * 잘린 떡의 길이는 차례대로 4, 0, 0, 2cm이다. 손님은 6cm 만큼의 길이를 가져간다.
 * 손님이 왔을 때 요청한 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.
 * <p>
 * 입력 조건
 * 첫째 줄에 떡의 개수 N과 요청한 떡의 길이 M이 주어진다.
 * (1 <= N <= 1,000,000, 1 <= M <= 2,000,000,000)
 * 둘째 줄에는 떡의 개별 높이가 주어진다. 떡 높이의 총합은 항상 M 이상이므로, 손님은 필요한 양만큼 떡을 사갈 수 있다.
 * 높이는 10억보다 작거나 같은 양의 정수 또는 0이다.
 * 출력 조건
 * 적어도 M만큼의 떡을 집에 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-24   parkjungkwan  최초 생성
 * 2022-06-12   JeongmyoengHong  문제풀이 시작
 */
public class 떡볶이떡만들기 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Solution {
        private int[] NM;
        private int[] dduckHeight;
        private int answer;

        @Override
        public String toString() {
            return String.format("떡의 갯수 : %d\n" +
                    "요청한 떡의 길이 : %d\n" +
                    "떡의 개별 높이 : %s\n" +
                    "기대값 : %d", NM[0], NM[1], Arrays.toString(dduckHeight), answer);
        }
    }

    @FunctionalInterface
    private interface SolutionService<T, R> {
        R solution(T t);
    }

    static class Service {
        SolutionService<Solution, Solution> f = e -> {
            int min = Arrays.stream(e.getDduckHeight()).sum() / e.getNM()[0];
            OptionalInt max = Arrays.stream(e.getDduckHeight()).max();
            while(true) {
                int M = 0;
                if (!(M - e.getNM()[1] >= 0 && M - e.getNM()[1] < e.getNM()[0])) {
                    for (int height : e.getDduckHeight()) {
                        if (height - e.getAnswer() > 0) {
                            M += height - e.getAnswer();
                        }
                    }
                } else break;
            }
            return Solution.builder()
                    .NM(e.getNM())
                    .dduckHeight(e.getDduckHeight())
                    .answer(e.getAnswer())
                    .build();
        };
    }

    @Test
    void testSolution() {
        int[] NM = {4, 6};
        int[] dduckHeight = {19, 15, 10, 17};
        Solution s = Solution.builder()
                .NM(NM)
                .dduckHeight(dduckHeight)
                .build();
        System.out.println(new Service().f.solution(s));

        int[] NM2 = {6, 7};
        int[] dduckHeight2 = {19, 15, 10, 17, 12, 9};
        Solution s2 = Solution.builder()
                .NM(NM2)
                .dduckHeight(dduckHeight2)
                .build();
        System.out.println(new Service().f.solution(s2));
    }
}
