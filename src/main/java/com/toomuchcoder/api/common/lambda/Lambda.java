package com.toomuchcoder.api.common.lambda;

import static com.toomuchcoder.api.common.dataStructure.AppleList.Apple;

import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.function.*;

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
 * 2022-05-12      JeongmyoengHong     함수형 객체, 람다
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
                        )));
        System.out.println(equals("홍정명", "홍%"));
        System.out.println(equals("홍정명", "홍정명"));
        System.out.println(array(8).length);
        System.out.println(string(array(8)));
        System.out.println(random(1, 6));
        System.out.println(random2(1, 6));
    }

    public static int integer(String arg) {
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(arg);
    }

    public static String string(Object object) {
        Function<Object, String> f = String::valueOf;
        return f.apply(object);
    }

    public static boolean equals(String s1, String s2) {
        BiPredicate<String, String> f = String::equals;
        return f.test(s1, s2);
    }

    // int[] arr = new int[8];   클래식 자바 배열 생성
    // 이름은 array int[] 타입, size 8(파라미터)로 던지면 배열이 나온다.
    // int[]::new
    public static int[] array(int i) {
        Function<Integer, int[]> n = int[]::new;
        return n.apply(i);
    }

    public static int random(int start, int end) {
        Supplier<Double> f = Math::random;
        return (int) (f.get() * end) + start;
    }
    // 이렇게 하는것 보다 메소드에서 파라미터 2개를 받고 int타입의 리턴을 가지니까
    // BiFunction을 쓰는것이 직관적이다 따라서 아래 random2 처럼 해준다.

    public static int random2(int min, int max) {
        BiFunction<Integer, Integer, Integer> f2 = (t, u) -> {return (int) (Math.random() * u) + t;};
        // 특이한점 : 중괄호 밖에도 세미콜론을 붙여야한다.
        BiFunction<Integer, Integer, Integer> f = (t, u) -> (int) (Math.random() * u) + t;
        // 식이 하나이므로 중괄호와 return 키워드를 생략해준다.
        BiFunction<Integer, Integer, Integer> f3 = (Integer t, Integer u) -> (int) (Math.random() * u) + t;
        // 파라미터가 1개이거나 파라미터가 2개 이상일 때에는 타입이 모두 같을때 생략한다.
        // 매개변수가 1개면 소괄호 () 도 생략 할 수 있다. ***리액트에서 = e => {} 이렇게 하는것과 동일
        // ex_) Function<Integer, Integer> f = a -> {};
        return f.apply(min, max);
    }

    public static File makeFile(String arg){
        Function<String, File> f = File::new;
        return f.apply(arg);
    }

    public static void println(String arg) {
        Consumer<String> f = System.out::println;
        f.accept(arg);
    }
}
