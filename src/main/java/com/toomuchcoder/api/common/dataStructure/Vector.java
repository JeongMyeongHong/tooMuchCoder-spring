package com.toomuchcoder.api.common.dataStructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * packageName   :   com.toomuchcoder.api.common.dataStructure
 * fileName      :   Vector
 * author        :   JeongmyeongHong
 * date          :   2022-05-13
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-13      JeongmyoengHong     최초 생성
 */
@Component
@Data
@Lazy
public class Vector<T> {
    private ArrayList<T> list;

    public Vector(){
        this.list = new ArrayList<>();
    }
    // save, update, delete, findAll, findBy, count, existBy, clear
    // add, set, remove, get(), get(i), size, X, clear
    public void add(T t){
//        Consumer<T> c = list::add;
//        c.accept(t);
        list.add(t);
    }

    public void set(int i, T t){
//        BiConsumer<Integer, T> c = list::set;
//        c.accept(i, t);
        list.set(i, t);
    }

    public void remove(T t){
//        Consumer<T> c = list::remove;
//        c.accept(t);
        list.remove(t);
    }

    public ArrayList<T>findAll(){
//        Supplier<Object[]> s = list::toArray;
//        return s.get();
        return list;
    }

    public T get(int i){
//        Function<Integer, T> f = list::get;
//        return f.apply(i);
        return list.get(i);
    }

    public int size(){
//        Supplier<Integer> s = list::size;
//        return s.get();
        return list.size();
    }

    public void clear(){
//        Runnable r = list::clear;
//        r.run();
        list.clear();
    }
}
