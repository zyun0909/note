package com.zyun.note.base;

//String在当前方法体内是否可以改变值，在非当前方法体内是否可以改变值
public class OperString {

    private void oper(String str) {
        str = "2";
    }

    private String oper2(String str) {
        str = "3";
        return str;
    }

    public static void main(String[] args) {
        String str = "1";

        OperString test = new OperString();
        System.out.println(str);

        test.oper(str);
        System.out.println(str);

        str = test.oper2(str);
        System.out.println(str);

        str = "4";
        System.out.println(str);

    }
}
