package com.toomuchcoder.api.common.dataStructure;

import static com.toomuchcoder.api.common.lambda.Lambda.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
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
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AppleService service = new AppleServiceImpl();
        while (true) {
            System.out.println("0.Exit 1.save 2.update 3.delete 4.findAll 5.findByOrigin 6.findByColor 7.findById 8.count 9.clear");
            switch (s.next()) {
                case "0":
                    System.out.println("Exit");
                    return;
                case "1":
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
                    break;
                case "2":
                    System.out.println("2.update");
                    break;
                case "3":
                    System.out.println("3.delete");
                    break;
                case "4":
                    System.out.println("4.findAll");
                    break;
                case "5":
                    System.out.println("5.findByOrigin");
                    System.out.println(service.findByOrigin("영동"));
                    break;
                case "6":
                    System.out.println("6.findByColor");
                    break;
                case "7":
                    System.out.println("7.findById");
                    System.out.println(service.findAll());
                    break;
                case "8":
                    System.out.println("8.count");
                    System.out.println("총 회원수: " + service.count() + " 명");
                    break;
                case "9":
                    System.out.println("9.clear");
                    service.clear();
                    break;
                case "10":
                    System.out.println("사과 가격은 " + integer("1000"));
                    System.out.println("사과 가격은 " + string(1000));
                    System.out.println("사과 가격은 " + string("1000"));
                default:
                    break;

            }
        }
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
        public List<Apple> findByColor(String Color) {
            return null;
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
