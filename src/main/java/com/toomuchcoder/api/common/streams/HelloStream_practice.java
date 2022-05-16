package com.toomuchcoder.api.common.streams;

import com.toomuchcoder.api.common.dataStructure.AppleApp;
import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * packageName   :   com.toomuchcoder.api.common.streams
 * fileName      :   HelloStream_practice
 * author        :   JeongmyeongHong
 * date          :   2022-05-16
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-16      JeongmyoengHong     최초 생성
 */
public class HelloStream_practice {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Hello{
        private String inLanguage;
        private Set<String> greeting;

        @Override
        public String toString() {
            return String.format("[Hello 정보] : greeting : %s, inLanguage : %s", greeting, inLanguage);
        }
    }

    interface HelloService{
        Set<String> greet(String[] arr, String inLanguage);
        void saveGreet(String[] arr, String inLanguage);
        List<Hello> findAll();

    }

    static class HelloServiceImpl implements HelloService {
        private final List<Hello> list;

        public HelloServiceImpl(){
            this.list = new ArrayList<>();
        }

        @Override
        public Set<String> greet(String[] arr, String inLanguage) {
            return Arrays.asList(arr)
                    .stream()
                    .filter(e -> e.startsWith(inLanguage))
                    .collect(Collectors.toSet());
        }

        @Override
        public void saveGreet(String[] arr, String inLanguage) {
            list.add(Hello.builder()
                    .greeting(Arrays.asList(arr)
                            .stream()
                            .filter(e -> e.startsWith(inLanguage))
                            .collect(Collectors.toSet()))
                    .inLanguage(inLanguage)
                    .build());
        }

        @Override
        public List<Hello> findAll() {
            return list;
        }
    }

    @Test
    void helloTest(){
        HelloService helloService = new HelloServiceImpl();
        String[] arr = {"한국어 안녕", "영어 Hello", "한국어 안녕하세요", "중국어 NiHao"};

        helloService.greet(arr, "한국어").forEach(System.out::println);

        helloService.saveGreet(arr,"한국어");
        helloService.saveGreet(arr,"영어");
        helloService.saveGreet(arr,"중국어");
        System.out.println(helloService.findAll());
    }
}