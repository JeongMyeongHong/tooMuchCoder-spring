package com.toomuchcoder.api.common.lambda;

/**
 * packageName   :   com.toomuchcoder.api.common.lambda
 * fileName      :   Calculator
 * author        :   JeongmyeongHong
 * date          :   2022-05-11
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-11      JeongmyoengHong     최초 생성
 */
public class Calculator {
    public static void main(String... args) {
        var s = "계산기";
        System.out.println(s);
        Calculator c = new Calculator();
        System.out.println("10 + 5 = " + c.operate(10, 5, (a, b) -> a+b));
        System.out.println("10 - 5 = " + c.operate(10, 5, (a, b) -> a-b));
        System.out.println("10 x 5 = " + c.operate(10, 5, (a, b) -> a*b));
        System.out.println("10 / 5 = " + c.operate(10, 5, (a, b) -> a/b));
    }
    interface Arithmetic{
        int operation(int a, int b);

    }
    private int operate(int a, int b, Arithmetic arithmetic){
        return arithmetic.operation(a, b);
    }
}
