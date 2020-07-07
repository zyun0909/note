package com.zyun.note.base.jdk8;


import com.zyun.note.bean.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Lambda表達式例子
 */
public class Lambda {

    /**
     * 获得一个list集合
     */
    private static List<User> getLoopList() {
        List<User> all = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            all.add(new User("name_" + i, "pwd_" + i));
        }
        return all;
    }

    /**
     * 获得一个map集合
     */
    private static Map<Integer, Integer> getLoopMap() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        return map;
    }

    /**
     * 打印分行符公共方法
     */
    private static void println() {
        System.out.println("--------------------------我是分行符--------------------------");
    }

    /**
     * 测试集合(list,map)循环
     */
    private static void testLoop() {
        List<User> list = getLoopList();
        beforeLoopList(list);
        lambdaLoopList(list);

        Map<Integer, Integer> map = getLoopMap();
        beforeLoopMap(map);
        lambdaLoopMap(map);
    }

    /**
     * 以前循环一个集合，for和foreach循环
     */
    private static void beforeLoopList(List<User> list) {
        System.out.println("Java 7 遍历List");
        for (User user : list) {
            System.out.println(user);
        }
        println();
    }

    /**
     * 使用lambda循环一个集合
     */
    private static void lambdaLoopList(List<User> list) {
        System.out.println("Java 8 遍历List");

        //下面三行循环效果相同,就是简写形式
        //list.forEach((User user) -> System.out.println(user));
        //list.forEach(user -> System.out.println(user));
        list.forEach(System.out::println);

        println();
    }

    /**
     * Java 7 的map的遍历
     */
    private static void beforeLoopMap(Map<Integer, Integer> map) {
        System.out.println("Java 7 遍历map");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key " + entry.getKey() + " value " + entry.getValue());
        }
//        for (Integer key : map.keySet()) {
//            System.out.println("key " + key);
//        }
//        for (Integer value : map.values()) {
//            System.out.println("v " + value);
//        }
        println();
    }

    /**
     * Java 8 的map的遍历
     */
    private static void lambdaLoopMap(Map<Integer, Integer> map) {
        System.out.println("Java 8 遍历map");
        map.forEach((key, value) -> System.out.println("key " + key + " value " + value));
        println();
    }

    /**
     * 测试循环的时候，顺带操作集合中的内容。
     */
    private static void testLoopOperate() {
        List<User> list = getLoopList();
        lambdaOperateList(list);

        Map<Integer, Integer> map = getLoopMap();
        lambdaOperateMap(map);
    }

    private static void lambdaOperateList(List<User> list) {
        System.out.println("对list集合进行操作：user's name + “_1” ");
        list.forEach(user -> {
            user.setName(user.getName() + "_1");
        });
        //操作完，循环输出一下，看下是否操作OK。
        list.forEach(System.out::println);
        println();
    }

    private static void lambdaOperateMap(Map<Integer, Integer> map) {
        System.out.println("对map集合进行操作：map's value + 10 ");
        map.forEach((k, v) -> {
            map.put(k, v + 10);//更新。
        });
        lambdaLoopMap(map);
    }

    /**
     * 测试collection.stream().filter()
     */
    private static void testStreamFilter() {
        List<User> list = getLoopList();
        System.out.println("对集合进行过滤：user name 包含 1 的用户");
        List<User> filtered = list.stream().filter(s -> s.getName().contains("1")).collect(Collectors.toList());
        filtered.forEach(user -> System.out.println(user.toString()));
        println();
    }

    /**
     * 测试collection.stream().map()
     */
    private static void testStreamMap() {
        List<User> list = getLoopList();
        System.out.println("对集合进行操作：user name + “1” ");
        List<String> nameList = list.stream().map(User::getName).collect(Collectors.toList());
        nameList.forEach(System.out::println);
        println();

    }

    /**
     * 测试用法，稍复杂的串行操作。
     * 过滤空值；去重；排序；循环输出。
     */
    private static void testNumber() {
        List<Integer> integers = Arrays.asList(1, 3, null, 8, 7, 8, 13, 10, 1);
        integers.stream().filter(Objects::nonNull).distinct().sorted((o1, o2) -> (o2 - o1)).forEach(System.out::println);
    }


    public static void main(String[] args) {

        Lambda.testLoop();

        Lambda.testLoopOperate();

        Lambda.testStreamFilter();

        Lambda.testStreamMap();

        Lambda.testNumber();

    }
}
