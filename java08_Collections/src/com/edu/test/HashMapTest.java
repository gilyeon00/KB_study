package com.edu.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("강호동", 85);
        map.put("이수근", 97);
        map.put("서장훈", 87);
        map.put("김희철", 92);

        // 1. map 에 담겨 있는 모든 키 값을 받아온다
        Set<String> keys = map.keySet();
        System.out.println(keys);

        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // 2. key 에 매핑된 점수를 받아서 모든 성적의 total 점수를 출력
        int total = 0;
        for (int value : map.values()) {
            total += value;
        }
        System.out.println("전체 점수 : " + total);

        System.out.println("평균 점수 : " + total/map.size());

    }
}
