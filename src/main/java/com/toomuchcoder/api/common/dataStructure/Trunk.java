package com.toomuchcoder.api.common.dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName   :   com.toomuchcoder.api.common.dataStructure
 * fileName      :   Trunk
 * author        :   JeongmyeongHong
 * date          :   2022-05-12
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-12      JeongmyoengHong     최초 생성
 */
public class Trunk<T> {
    private Map<String, T> map;
    public Trunk(){
        this.map = new HashMap<>();
    }

    public void put(T t){
        map.put(t.getUserid(), t);
    }

    public void replace(MemberCRUD.Member member) {
        map.replace(member.getUserid(), member);
    }

    public void remove(MemberCRUD.Member member) {
        map.remove(member.getUserid());
    }

    public MemberCRUD.Member findById(String id) {
        return map.get(id);
    }

    public List<MemberCRUD.Member> findByName(String name) {
        return null;
    }

    public List<MemberCRUD.Member> findAll() {
        List<MemberCRUD.Member> list = new ArrayList<>();
        map.keySet().forEach(key -> list.add(map.get(key)));
        return list;
    }

    public int size() {
        return map.size();
    }

    public boolean containsKey(String id) {
        return map.containsKey(id);
    }

    public void clear() {
        map.clear();
    }
}
