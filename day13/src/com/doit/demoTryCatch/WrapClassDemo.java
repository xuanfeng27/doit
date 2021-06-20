package com.doit.demoTryCatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: WrapClassDemo
 * @Author: zll
 * @CreateTime: 2021/6/20 10:42
 * @Desc: java 程序
 * @Version: 1.0
 */
public class WrapClassDemo {
    public static void main(String[] args) {
        //String---->int
        int i = Integer.parseInt("1000",10);
        System.out.println(i);
        //int ----> String
        String s = String.valueOf(10);
        System.out.println(s);

        //自动装箱
        Integer in = 5;
        //自动拆箱
        int a = new Integer(4);

        List<Integer> list = new ArrayList<Integer>();
        list.add(4); //自动装箱
        int b = list.get(0);//自动拆箱

        //java比较器
        int compare = Integer.compare(10, 20);
        System.out.println(compare);//-1

        int compare1 = Double.compare(10.1, 10.3);
        System.out.println(compare1);//-1

       //byte常量池 -128 127
        Integer i1 = 127;//new Integer(127)
        Integer i2 = 127;//i2 = i1
        Integer i3 = new Integer(127);
        Integer i4 = 128;
        Integer i5 = 128;
        Integer i6 = new Integer(128);
        System.out.println(i1 == i2);//true
        System.out.println(i1 == i3);//false
        System.out.println(i4 == i5);//false
        System.out.println(i4 == i6);//false




    }
}
