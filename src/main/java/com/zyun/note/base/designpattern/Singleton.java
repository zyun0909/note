package com.zyun.note.base.designpattern;

//单例饿汉模式://饿汉式单例类.在类初始化时，已经自行实例化
public class Singleton {


    //私有的默认构造子
    private Singleton() {
    }

    //已经自行实例化
    private static final Singleton single = new Singleton();

    //静态工厂方法
    public static Singleton getInstance() {
        return single;
    }
}

//懒汉模式://懒汉式单例类.在第一次调用的时候实例化
class Singleton2 {
    //私有的默认构造子
    private Singleton2() {
    }

    //注意，这里没有final
    private static Singleton2 single = null;

    //静态工厂方法
    public synchronized static Singleton2 getInstance() {
        if (single == null) {
            single = new Singleton2();
        }
        return single;
    }
}


