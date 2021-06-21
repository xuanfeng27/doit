package com.doit.demo1;

import java.util.ArrayList;

/**
 * @ClassName: Test2
 * @Author: zll
 * @CreateTime: 2021/6/21 16:03
 * @Desc: java 程序
 * @Version: 1.0
 */
//方法遍历两个集合list
public class Test2 {
    public static <T> void method(ArrayList<T> list){
        for (T item : list) {
            System.out.println(item);
        }
    }

    public static void method2(ArrayList<?> list){
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("11111");
        list1.add("22222");

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(111111);
        list2.add(222222);

        method(list1);
        method(list2);

    }
}

