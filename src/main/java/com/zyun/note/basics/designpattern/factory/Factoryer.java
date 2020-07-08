package com.zyun.note.basics.designpattern.factory;

/**
 * 工程模式
 */
public class Factoryer implements IFactoryer {

    public Producter createProducter() {
        return new Producter();
    }

    public static void main(String[] args) {
        IFactoryer factory = new Factoryer();
        Producter product = factory.createProducter();
        product.doSomething();
    }
}
