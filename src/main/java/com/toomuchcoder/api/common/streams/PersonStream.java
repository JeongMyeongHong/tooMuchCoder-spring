package com.toomuchcoder.api.common.streams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName   :   com.toomuchcoder.api.common.streams
 * fileName      :   PersonStream
 * author        :   JeongmyeongHong
 * date          :   2022-05-16
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-16      JeongmyoengHong     최초 생성
 * 2022-05-17      JeongmyoengHong     @FunctionInterface
 */
public class PersonStream {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Person{
        private String name, ssn;
        private int getGenderChk(){
            return Integer.parseInt(ssn.substring(ssn.length()-1));
        }

        @Override
        public String toString() {
            int now = Integer.parseInt(new SimpleDateFormat("yy").format(new Date()));
            int birth = Integer.parseInt(ssn.substring(0,2));
            String gender = getGenderChk() % 2 == 1 ? "남성" : "여성";
            int age = getGenderChk() / 3 == 0 ? (100 + now - birth) : (now - birth) ;
            return String.format("[PERSON Info] Name : %s, Sex : %s Age : %d", name, gender, age);
        }
    }

    @FunctionalInterface interface PersonService{Person search(List<Person> arr, String name);}

    // "홍길동", "900120-1"
    // "김유신", "970620-1"
    // "유관순", "040920-4"
    // 남성, 여성 판단 로직
    @Test
    void personStreamTest(){
        List<Person> arr = Arrays.asList(
                Person.builder().name("홍길동").ssn("900120-1").build(),
                Person.builder().name("신사임당").ssn("970620-2").build(),
                Person.builder().name("김유신").ssn("010620-3").build(),
                Person.builder().name("유관순").ssn("040920-4").build()
        );
        String name = "홍길동";
        PersonService ps = (persons, insName) -> persons.stream().filter(person -> person.getName().equals(insName)).collect(Collectors.toList()).get(0);
        System.out.println(arr);
        System.out.println(name + " 검색 : " + ps.search(arr, name));
    }
}
