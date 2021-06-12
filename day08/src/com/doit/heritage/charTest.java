package com.doit.heritage;

import java.util.Date;

/**
 * @ClassName: charTest
 * @Author: zll
 * @CreateTime: 2021/6/12 16:42
 * @Desc: java 程序
 * @Version: 1.0
 */
public class charTest {

    public static void main(String []args) {
        test();
        method1();
    }
    public static void test() {
        int a = 33;
        System.out.println(""+a);
        char[] arr = new char[] { 'a', 'b', 'c' };
        System.out.println(arr);
        int[] arr1 = new int[] { 1, 2, 3 };
        System.out.println(arr1);
        double[] arr2 = new double[] { 1.1, 2.2, 3.3 };
        System.out.println(arr2);

        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);//1.0

        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);//1

    }

    public static void method1() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//false
    }
}
