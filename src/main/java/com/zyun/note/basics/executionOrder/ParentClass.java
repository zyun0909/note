package com.zyun.note.basics.executionOrder;

/**
 * @description：代码执行顺序-父类
 * @Author zhaoyun
 * @Date 2020-7-9
 * @see com.zyun.note.basics.executionOrder.ChildClass#main(java.lang.String[])
 */

public class ParentClass {
    private int p1 = getValue();
    private static int p2 = getValue2();

    public ParentClass() {
        System.out.println("我是父构造器");
    }

    static {
        System.out.println("我是父静态代码块1");
    }

    static {
        System.out.println("我是父静态代码块2");
    }

    {
        System.out.println("我是父代码块1");
    }

    {
        System.out.println("我是父代码块2");
    }

    private int getValue() {
        System.out.println("我是父成员变量p1");
        return 1;
    }

    private static int getValue2() {
        System.out.println("我是父静态成员变量p2");
        return 1;
    }

}
