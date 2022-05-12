package com.toomuchcoder.api.common.dataStructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * packageName   :   com.toomuchcoder.api.common.dataStructure
 * fileName      :   Box
 * author        :   JeongmyeongHong
 * date          :   2022-05-12
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-12      JeongmyoengHong     최초 생성
 * 2022-05-12      JeongmyoengHong     Generic
 */
@Component @Data @Lazy
//@Component 어노테이션은 순수 자바 객체로 쓴다.
//@Lazy LazyLoading 호출 할 때 인스턴스 생성 DB가 필요 없음. 시스템 전체 구동 속도를 올려준다.
public class Box<T> {
    private ArrayList<T> list;

    public Box(){
        this.list = new ArrayList<>();
    }
    // save, update, delete, findAll, findBy, count, existBy, clear
    // add, set, remove, get(), get(i), size, X, clear
    public void add(T t){
        Consumer<T> c = list::add;
        c.accept(t);
    }

    public void set(int i, T t){
        BiConsumer<Integer, T> c = list::set;
        c.accept(i, t);
    }

    public void remove(T t){
        Consumer<T> c = list::remove;
        c.accept(t);
    }

    public Object[] findAll(){
        Supplier<Object[]> s = list::toArray;
        return s.get();
    }

    public T findById(int i){
        Function<Integer, T> f = list::get;
        return f.apply(i);
    }

    public int size(){
        Supplier<Integer> s = list::size;
        return s.get();
    }

    public void clear(){
        Runnable r = list::clear;
        r.run();
    }
}
