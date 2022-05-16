package com.toomuchcoder.api.common.streams;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * packageName   :   com.toomuchcoder.api.common.streams
 * fileName      :   HelloStream
 * author        :   JeongmyeongHong
 * date          :   2022-05-16
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-16      JeongmyoengHong     최초 생성
 */
// 한국어 안녕, 영어 Hello, 중국어 NiHao
public class HelloStream {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Hello{
        private String greeting, inLanguage;

        @Override
        public String toString() {
            return String.format("[Hello 정보] : greeting : %s, inLanguage : %s", greeting, inLanguage);
        }
    }

    interface HelloService{
        Set<Hello> greet(List<Hello> list, String inLanguage);
    }
    public static class HelloServiceImpl implements HelloService{

        @Override
        public Set<Hello> greet(List<Hello> arr, String inLanguage) {
            return arr.stream()
                    .filter(e -> e.getInLanguage().equals(inLanguage))
                    .collect(Collectors.toSet());
        }
    }

    @Test
    void helloTest(){
        List<Hello> arr = Arrays.asList(
                Hello.builder().inLanguage("영어").greeting("Hello").build(),
                Hello.builder().inLanguage("한국어").greeting("안녕").build(),
                Hello.builder().inLanguage("중국어").greeting("NiHao").build()
        );
        System.out.println(new HelloServiceImpl().greet(arr, "영어"));
    }
}
