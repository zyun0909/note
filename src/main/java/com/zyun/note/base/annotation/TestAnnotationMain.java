package com.zyun.note.base.annotation;

/**
 * 测试类
 */
@TestAnnotation(id = "一个id")
public class TestAnnotationMain {

    public static void main(String[] args) {
        boolean hasAnnotation = TestAnnotationMain.class.isAnnotationPresent(TestAnnotation.class);

        if (hasAnnotation) {
            TestAnnotation testAnnotation = TestAnnotationMain.class.getAnnotation(TestAnnotation.class);

            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.name());
        }
    }
}
