package com.toomuchcoder.api.common.lambda;

import static com.toomuchcoder.api.common.dataStructure.AppleList.Apple;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * packageName   :   com.toomuchcoder.api.common.lambda
 * fileName      :   Lambda
 * author        :   JeongmyeongHong
 * date          :   2022-05-11
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-11      JeongmyoengHong     최초 생성
 */
public class Lambda {
    public static void main(String[] args) {
        System.out.println(integer("900"));
        System.out.println(new Apple.Builder().color("RED").origin("영동").price(1000).build());
        System.out.println(
                string(
                        Arrays.asList(
                                new Apple.Builder().color("RED").origin("영동").price(1000).build(),
                                new Apple.Builder().color("BLUE").origin("영동").price(1000).build(),
                                new Apple.Builder().color("RED").origin("풍기").price(1000).build()
                        ) ) );
        System.out.println(equals("홍정명", "홍%"));
        System.out.println(equals("홍정명", "홍정명"));
        System.out.println(array(8).length);
        System.out.println(string(array(8)));
        System.out.println(random(1,6));
        System.out.println(random(1,6));
        System.out.println(random(1,6));
        System.out.println(random(1,6));
        System.out.println(random(1,6));
        System.out.println(random(1,6));
        System.out.println(random(1,6));
    }
    public static int integer(String arg){
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(arg);
    }
    public static String string(Object object){
        // String s = String.valueOf(Object);
        Function<Object, String> f = String::valueOf;
        return f.apply(object);
    }

    public static boolean equals(String s1, String s2){
        BiPredicate<String, String> f = String::equals;
        return f.test(s1, s2);
    }

    // int[] arr = new int[8];   클래식 자바 배열 생성
    // 이름은 array int[] 타입, size 8(파라미터)로 던지면 배열이 나온다.
    // int[]::new
    public static int[] array(Integer i){
        Function<Integer, int[]> n = int[]::new;
        return n.apply(i);
    }

    public static double random(Integer start, Integer end){
        Supplier<Double> f = Math::random;
        return (int)(f.get()*end)+start;
    }
}
