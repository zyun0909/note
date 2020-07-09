package com.zyun.note.basics.executionOrder;

/**
 * @description：代码执行顺序-子类
 * @Author zhaoyun
 * @Date 2020-7-9
 * @see com.zyun.note.basics.executionOrder.ChildClass#main(java.lang.String[])
 */
public class ChildClass extends ParentClass {
    private int c1 = getValue();
    private static int c2 = getValue2();

    public ChildClass() {
        System.out.println("我是子构造器");
    }

    static {
        System.out.println("我是子静态代码块1");
    }

    static {
        System.out.println("我是子静态代码块2");
    }

    {
        System.out.println("我是子代码块1");
    }

    {
        System.out.println("我是子代码块2");
    }

    private int getValue() {
        System.out.println("我是子成员变量c1");
        return 1;
    }

    private static int getValue2() {
        System.out.println("我是子静态成员变量c2");
        return 1;
    }

    /**
     * 初始化，则是为标记为常量值的字段赋值的过程。
     * 换句话说，只对static修饰的变量或语句块进行初始化。
     * 如果初始化一个类的时候，其父类尚未初始化，则优先初始化其父类。
     * 如果同时包含多个静态变量和静态代码块，则按照自上而下的顺序依次执行。
     */
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
    }

}
