package com.zyun.note.basics.basicDataType;

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
        System.out.println(str); //1

        test.oper(str);
        System.out.println(str); //1

        str = test.oper2(str);
        System.out.println(str); //3

        str = "4";
        System.out.println(str); //4

    }
}
