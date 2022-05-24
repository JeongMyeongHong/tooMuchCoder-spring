package com.toomuchcoder.api.common.dataStructure;

import com.toomuchcoder.api.user.domains.User;
import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class Box<K, V> {
    private HashMap<K, V> map;
    public Box(){this.map = new HashMap<>();}

    public void put(K k, V v){map.put(k, v);}

    public void replace(K k, V V) {map.replace(k, V);}

    public void remove(K k) {map.remove(k);}

    public V get(K k) {return map.get(k);}

//    public List<T> findAll() {
//        List<T> list = new ArrayList<>();
//        map.keySet().forEach(key -> list.add(map.get(key)));
//        return list;
//    }
    public List<V> findAll() {return map.values().stream().collect(Collectors.toList());}

    public List<V> get() {return new ArrayList<>(map.values());}

    public int size() {return map.size();}

    public boolean containsKey(K k) {return map.containsKey(k);}

    public void clear() {map.clear();}

    //custom

    //테이블 목록 요청시
    public List<V> findAllUserList(){
        List<V> ls = new ArrayList<>();
        for(Map.Entry<K, V> e: map.entrySet()){ ls.add((V)e.getValue()); }
        return ls;
    }

    //테이블 키값 목록 요청시
    public List<V> findAllUserKeyList(){
        List<V> ls = new ArrayList<>();
        for(Map.Entry<K, V> e: map.entrySet()){ ls.add((V)e.getKey()); }
        return ls;
    }

    //이름으로 검색된 회원 목록 요청시(필터가 필요 없이 리액트로 던지는 경우)
    public List<User> listFindByUserName(String name){
        List<User> ls = new ArrayList<>();
        for(User user: ls){ if(name.equals(user.getName())) ls.add(user); }
        return ls;
    }

    //이름으로 검색된 회원 목록 요청시(추가 필터를 통해 더 줄어든 결과값이필요한 경우우)
   public Map<String, User>  mapFindByUserName(String name){
        Map<String, User> map = new HashMap<>();
        for(Map.Entry<String, User> e: map.entrySet()){
            if(name.equals(e.getValue().getName())) map.put(e.getKey(), e.getValue());
        }
        return map;
    }
}
