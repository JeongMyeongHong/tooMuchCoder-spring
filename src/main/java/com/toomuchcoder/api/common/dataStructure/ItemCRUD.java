package com.toomuchcoder.api.common.dataStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * packageName   :   com.toomuchcoder.api.common.dataStructure
 * fileName      :   ItemCRUD
 * author        :   JeongmyeongHong
 * date          :   2022-05-10
 * desc          :
 * ============================================
 * DATE             AUTHOR              NOTE
 * ============================================
 * 2022-05-10      JeongmyoengHong     최초 생성
 */
public class ItemCRUD {
    public static void main(String[] args) {
        System.out.println("0.exit 1.save 2.update 3.delete 4.findById 5.findByName 6.findAll 7.count 8.existsById");
    }

    @Data @AllArgsConstructor static class Item{
        private int id;
        private String name;
        private int price;
    }

    interface ItemService{
        void save(Item item);
        void update(Item item);
        void delete(Item item);
        Item findById(String id);
        List<Item> findByName(String name);
        List<Item> findAll();
        int count();
        boolean existsById(String id);
    }

    @RequiredArgsConstructor class ItemServiceImpl implements ItemService{
        private final Map<String, Item> map;

        @Override
        public void save(Item item) {

        }

        @Override
        public void update(Item item) {

        }

        @Override
        public void delete(Item item) {

        }

        @Override
        public Item findById(String id) {
            return null;
        }

        @Override
        public List<Item> findByName(String name) {
            return null;
        }

        @Override
        public List<Item> findAll() {
            return null;
        }

        @Override
        public int count() {
            return 0;
        }

        @Override
        public boolean existsById(String id) {
            return false;
        }
    }
}


