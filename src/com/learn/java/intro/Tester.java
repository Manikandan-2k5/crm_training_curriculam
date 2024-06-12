package com.learn.java.intro;

import org.openjdk.jol.info.ClassLayout;

public class Tester {
    public static void main(String[] args) {
        Test test = new Test();
        int[] array = new int[]{1233,223,12,121212,124343,5565,89898,8347};
        System.out.println(ClassLayout.parseInstance(array).toPrintable());
    }
}
