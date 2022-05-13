package com.toomuchcoder.api.common.dataStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

/**
 * packageName   :   com.toomuchcoder.api.common.dataStructure
 * fileName      :   MemberCRUD
 * author        :   JeongmyeongHong
 * date          :   2022-05-09
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-09      JeongmyoengHong     최초 생성
 */
public class MemberCRUD {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        MemberService service = new MemberServiceImpl();
        while (true) {
            System.out.println("0.Exit 1.save 2.update 3.delete 4.findById 5.findByName 6.findAll 7.count 8.existsById 9.clear");
            switch (s.next()) {
                case "0":
                    System.out.println("Exit");
                    return;
                case "1":
                    Member hong = new Member.Builder("hong")
                            .email("hong@test.com")
                            .name("홍길동")
                            .password("1")
                            .phone("010-1234-5678")
                            .profileImg("hong.jpg")
                            .build();
                    service.save(hong);
                    Member kim = new Member.Builder("kim")
                            .email("kim@test.com")
                            .password("1")
                            .name("김유신")
                            .phone("010-0044-9944")
                            .profileImg("kim.jpg")
                            .build();
                    service.save(kim);
                    Member you = new Member.Builder("you")
                            .email("you@test.com")
                            .password("1")
                            .name("유관순")
                            .phone("010-0880-9889")
                            .build();
                    service.save(you);

                    break;
                case "2":
                    System.out.println("2.update");
                    Member tmp = new Member();
                    tmp.setUserid("hong");
//                    service.update(tmp.getUserid(), tmp2);
                    break;
                case "3":
                    System.out.println("3.delete");
                    Member temp = new Member();
                    temp.setUserid("hong");
                    if (service.existsById(("hong"))) service.delete(temp);
                    else System.out.println("존재 하지 않는 키값입니다.");
                    break;
                case "4":
                    System.out.println("4.findById");
                    if (service.existsById(("hong"))) System.out.println(service.findById("hong"));
                    else System.out.println("존재 하지 않는 키값입니다.");
                    break;
                case "5":
                    System.out.println("5.findByName");
                    break;
                case "6":
                    System.out.println("6.findAll");
                    System.out.println(service.findAll());
                    break;
                case "7":
                    System.out.println("7.count");
                    System.out.println("총 회원수: "+service.count()+" 명");
                    break;
                case "8":
                    System.out.println("8.existsById");
                    System.out.println(service.existsById("hong"));
                    break;
                case "9":
                    System.out.println("9.clear");
                    service.clear();
                    break;
                default:
                    break;

            }
        }
    }

    @Data @NoArgsConstructor
    static class Member {
        protected String userid, name, password, profileImg, phone, email;

        public Member(Builder builder){
            this.userid = builder.userid;
            this.name = builder.name;
            this.password = builder.password;
            this.profileImg = builder.profileImg;
            this.phone = builder.phone;
            this.email = builder.email;
        }

        static class Builder{
            protected String userid, name, password, profileImg, phone, email;
            public Builder (String userid){this.userid = userid;}
            public Builder name (String name){this.name = name; return this;}
            public Builder password (String password){this.password = password; return this;}
            public Builder profileImg (String profileImg){this.profileImg = profileImg; return this;}
            public Builder phone (String phone){this.phone = phone; return this;}
            public Builder email (String email){this.email = email; return this;}
            Member build(){ return new Member(this);}
        }
        @Override
        public String toString() {
            return String.format("[사용자 스펙] : userid: %s, name: %s, password: %s, profileImg: %s, phone: %s, email: %s", userid, name, password, profileImg, phone, email);
        }
    }

    interface MemberService{
        void save(Member member);
        void update(Member member);
        void delete(Member member);
        Member findById(String id);
        List<Member> findByName(String name);
        List<Member> findAll();
        int count();
        boolean existsById(String id);
        void clear();
    }

    static class MemberServiceImpl implements MemberService {
        private final HashMap<String, Member> map;

        public MemberServiceImpl(){
            this.map = new HashMap<>();
        }

        @Override
        public void save(Member member){
            map.put(member.getUserid(), member);
        }

        @Override
        public void update(Member member) {
            map.replace(member.getUserid(), member);
        }

        @Override
        public void delete(Member member) {
            map.remove(member.getUserid());
        }

        @Override
        public Member findById(String id) {
            return map.get(id);
        }

        @Override
        public List<Member> findByName(String name) {
            return null;
        }

        @Override
        public List<Member> findAll() {
            List<Member> list = new ArrayList<>();
            map.keySet().forEach(key -> list.add(map.get(key)));
            return list;
        }

        @Override
        public int count() {
            return map.size();
        }

        @Override
        public boolean existsById(String id) {
            return map.containsKey(id);
        }

        @Override
        public void clear() {
            map.clear();
        }

    }
}
