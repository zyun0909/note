package com.zyun.note.base.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhaoyun
 * @create 2019-09-06
 **/
public class Test {
    public static void main(String[] args) {
        // 准备一个集合
        List<Integer> list = Arrays.asList(10, 5, 25, -15, 20);

        // Jdk1.7写法
        Collections.sort(list,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // Jdk1.8写法
        list.sort((i1,i2) -> i1 - i2);

        System.out.println(list);// [-15, 5, 10, 20, 25]
    }
}
