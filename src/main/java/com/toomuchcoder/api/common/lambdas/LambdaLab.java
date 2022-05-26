package com.toomuchcoder.api.common.lambdas;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.function.Supplier;

/**
 * packageName   :   com.toomuchcoder.api.common.lambdas
 * fileName      :   LambdaLab
 * author        :   JeongmyeongHong
 * date          :   2022-05-26
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-26      JeongmyoengHong     최초 생성
 */
public class LambdaLab {

    public static Date solution(){
        Supplier<Date> s = Date::new;
        return s.get();
    }

    public static LocalDate date(){
        Supplier<LocalDate> s = LocalDate::now;
        return s.get();
    }

    public static String getDate() {
        Supplier<String> s = () -> LocalDate.now().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
        return s.get();
    }

    @Test
    void test(){
        System.out.println(solution());
        System.out.println(date());
        System.out.println(getDate());
    }
}
