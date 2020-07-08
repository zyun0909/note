package com.zyun.note.basics.designpattern.singleton;

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



