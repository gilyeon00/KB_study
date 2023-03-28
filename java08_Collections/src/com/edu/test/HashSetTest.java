package com.edu.test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("A");
        set.add("C");
        set.add("B");
        set.add("C");
        set.add("ㅋ");

        System.out.println(set);            // [A, B, C]
        System.out.println(set.size());     // 3

        boolean flag = set.remove("B");
        System.out.println("삭제가 잘되었나요? : " + flag);     // 삭제가 잘되었나요? : true

        set.clear();    // 전부 삭제
        System.out.println(set);

    }
}
