package com.toomuchcoder.api.common.dataStructure;

import static com.toomuchcoder.api.common.lambda.Lambda.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName   :   com.toomuchcoder.api.common.dataStructure
 * fileName      :   AppleList
 * author        :   JeongmyeongHong
 * date          :   2022-05-11
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-11      JeongmyoengHong     최초 생성
 */
// Apple의 객체가 color price origin
public class AppleList {
    @Test
    void appleListTest() {
        AppleService service = new AppleServiceImpl();
        System.out.println("###   save   ###");
        Apple yd = new Apple.Builder()
                .color("RED")
                .origin("영동")
                .price(1000)
                .build();
        service.save(yd);
        Apple yd2 = new Apple.Builder()
                .color("BLUE")
                .origin("영동")
                .price(1500)
                .build();
        service.save(yd2);
        Apple pg = new Apple.Builder()
                .color("RED")
                .origin("풍기")
                .price(2000)
                .build();
        service.save(pg);

        System.out.println("###   최초 count   ### \n총 사과수: " + service.count() + " 개");
        System.out.println("###   findAll   ###");
        System.out.println(service.findAll());
        System.out.println("###   findByOrigin   ###");
        System.out.println(service.findByOrigin("영동"));
        System.out.println("###   findByColor   ###");
        System.out.println(service.findByColor("RED"));
        System.out.println("###   findById   ###");
        System.out.println("첫번째 사과 정보 : "+service.findById(0));
        System.out.println("###   update   ###");
        Apple ca = new Apple.Builder()
                .origin("미국")
                .color("RAINBOW")
                .price(9999)
                .build();
        service.update(0, ca);
        System.out.println("수정된 사과정보:" +service.findById(0));
        System.out.println("###   delete   ###");
        service.delete(ca);
        System.out.println("ca만 삭제 후 사과 리스트");
        System.out.println(service.findAll());
        System.out.println("###   clear   ###");
        System.out.println("###   clear 전 count   ### \n총 사과수: " + service.count() + " 개");
        service.clear();
        System.out.println("###   clear 후 count   ### \n총 사과수: " + service.count() + " 개");
    }

    @Data
    @NoArgsConstructor
    public static class Apple {
        private String color, origin;
        private int price;

        public Apple(Builder builder) {
            this.color = builder.color;
            this.price = builder.price;
            this.origin = builder.origin;
        }

        @NoArgsConstructor
        public static class Builder {
            private String color, origin;
            private int price;

            public Builder color(String color) {
                this.color = color;
                return this;
            }

            public Builder price(int price) {
                this.price = price;
                return this;
            }

            public Builder origin(String origin) {
                this.origin = origin;
                return this;
            }

            public Apple build() {
                return new Apple(this);
            }
        }

        @Override
        public String toString() {
            return String.format("[사과정보] : color : %s, price : %d, origin : %s", color, price, origin);
        }
    }

    interface AppleService {
        void save(Apple apple);

        void update(int i, Apple apple);

        void delete(Apple apple);

        List<Apple> findAll();

        List<Apple> findByOrigin(String origin);

        List<Apple> findByColor(String Color);

        Apple findById(int i);

        int count();

        void clear();
    }

    static class AppleServiceImpl implements AppleService {
        private final List<Apple> list;

        public AppleServiceImpl() {
            this.list = new ArrayList<>();
        }

        @Override
        public void save(Apple apple) {
            list.add(apple);
        }

        @Override
        public void update(int i, Apple apple) {
            list.set(i, apple);
        }

        @Override
        public void delete(Apple apple) {
            list.remove(apple);
        }

        @Override
        public List<Apple> findAll() {
            return list;
        }

        @Override
        public List<Apple> findByOrigin(String origin) {
            return list.stream().filter(apple -> apple.getOrigin().equals(origin)).collect(Collectors.toList());
        }

        @Override
        public List<Apple> findByColor(String color) {
            return list.stream().filter(apple -> apple.getColor().equals(color)).collect(Collectors.toList());
        }

        @Override
        public Apple findById(int i) {
            return list.get(i);
        }

        @Override
        public int count() {
            return list.size();
        }

        @Override
        public void clear() {
            list.clear();
        }
    }
}

