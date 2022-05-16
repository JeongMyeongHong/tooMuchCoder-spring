package com.toomuchcoder.api.common.lambdas;

/**
 * packageName   :   com.toomuchcoder.api.common.lambda
 * fileName      :   MyLambda
 * author        :   JeongmyeongHong
 * date          :   2022-05-13
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-13      JeongmyoengHong     최초 생성
 */
public class MyLambda {
    @FunctionalInterface
    interface MyFunction {
        int excute(String arg);
    }

    @FunctionalInterface
    interface MySupplier {
        int excute();
    }

    @FunctionalInterface
    interface MyConsumer {
        void excute(String arg);
    }

    @FunctionalInterface
    interface MyPredicate {
        boolean excute(String arg);
    }
    @FunctionalInterface
    interface MyInterface{
        String myMethod();
    }
    @FunctionalInterface
    interface MyUnaryOp{
        int operator(Integer a);
    }
    @FunctionalInterface
    interface LengthOfString{
        int excute(String arg);
    }
    @FunctionalInterface
    interface MathOperation{
        int excute(int a, int b);
    }
    @FunctionalInterface
    interface FunctionTest<T, H>{
        H excute(T t);
    }
}
