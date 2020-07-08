package com.zyun.note.basics.extend;

public class Man extends People {

    public void test() {
        System.out.println("我是Man子类");
    }

    public static void main(String[] argssss) {

        Man test1 = new Man();
        test1.test();

        People test2 = new People();
        test2.test();

        People test = new Man();
        test.test();

    }
}
