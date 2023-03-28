package com.edu.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("F");
        list.add("B");
        list.add("B");
        list.add("C");

        System.out.println(list);   // [F, B, B, C]

        list.remove("B");
        System.out.println(list);

        list.add(0, "HH");
        System.out.println(list);

    }
}
