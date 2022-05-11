package com.toomuchcoder.api.common.dataStructure;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName   :   com.toomuchcoder.api.common.dataStructure
 * fileName      :   BmiList
 * author        :   JeongmyeongHong
 * date          :   2022-05-11
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-11      JeongmyoengHong     최초 생성
 */
// 키    몸무게    생년월일(900101-1)
// height weight    ssn
public class BmiList {
    public static void main(String[] args) {

    }
    @Data
    static class Bmi{
        private double height, weight;
        private String ssn;

        public Bmi(Builder builder){
            this.height = builder.height;
            this.weight = builder.weight;
            this.ssn = builder.ssn;
        }
        @NoArgsConstructor
        static class Builder{
            private double height, weight;
            private String ssn;
            public Builder height (double height){this.height = height; return this;}
            public Builder weight (double weight){this.weight = weight; return this;}
            public Builder ssn (String ssn){this.ssn = ssn; return this;}
            Bmi build(){return new Bmi(this);}
        }
        @Override
        public String toString(){
            return String.format("");
        }
    }
    interface BmiService{
        void save(Bmi bmi);
        void update(int i, Bmi bmi);
        void delete(Bmi bmi);
        void clear();
        Bmi findById(int i);
        List<Bmi> findByGender(String gender);
        List<Bmi> findAll();
        int count();
    }
    static class BmiServiceImpl implements BmiService{
        private final List<Bmi> list;

        public BmiServiceImpl() {
            this.list = new ArrayList<>();
        }

        @Override
        public void save(Bmi bmi) {
            list.add(bmi);
        }

        @Override
        public void update(int i, Bmi bmi) {
            list.set(i, bmi);
        }

        @Override
        public void delete(Bmi bmi) {
            list.remove(bmi);
        }

        @Override
        public void clear() {
            list.clear();
        }

        @Override
        public Bmi findById(int i) {
            return list.get(i);
        }

        @Override
        public List<Bmi> findByGender(String gender) {
            return null;
        }

        @Override
        public List<Bmi> findAll() {
            return list;
        }

        @Override
        public int count() {
            return list.size();
        }
    }
}
