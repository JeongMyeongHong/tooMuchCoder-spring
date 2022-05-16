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
 */
public class PersonStream {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Person{
        private String name, ssn, gender;
        private int age;

        @Override
        public String toString() {
            int a = Integer.parseInt(ssn.substring(ssn.length()-1));
            int b = Integer.parseInt(new SimpleDateFormat("YY").format(new Date()));
            int c = Integer.parseInt(ssn.substring(0,2));
            this.gender = a % 2 == 1 ? "남성": "여성";
            this.age = a / 2 == 0 ? (100 + b - c) : (b - c) ;
            return String.format("[PERSON Info] Name : %s, Sex : %s Age : %d", name, gender, age);
        }
    }
    interface PersonService{
        Person search(List<Person> arr, String name);
        String getGender(List<Person> arr, String name);
    }
    public static class PersonServiceImpl implements PersonService{
        private final List<Person> list;

        public PersonServiceImpl() {
            this.list = new ArrayList<>();
        }

        @Override
        public Person search(List<Person> arr, String name) {
            return arr.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList()).get(0);
        }

        @Override
        public String getGender(List<Person> arr, String name) {
            return arr.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList()).get(0).getGender();
        }


    }
    // "홍길동", "900120-1"
    // "김유신", "970620-1"
    // "유관순", "040920-4"
    // 남성, 여성 판단 로직
    @Test
    void personStreamTest(){
        List<Person> arr = Arrays.asList(
                Person.builder().name("홍길동").ssn("900120-1").build(),
                Person.builder().name("김유신").ssn("970620-1").build(),
                Person.builder().name("유관순").ssn("040920-4").build()
        );
        System.out.println(arr);
        String name = "홍길동";
        System.out.println(name + " 검색 : " + new PersonServiceImpl().search(arr, name));
        System.out.println(name + " 님의 성별 : " + new PersonServiceImpl().getGender(arr, name));
    }
}
