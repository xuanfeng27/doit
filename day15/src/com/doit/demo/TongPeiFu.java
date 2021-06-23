package com.doit.demo;

import java.util.List;

/**
 * @ClassName: TongPeiFu
 * @Author: zll
 * @CreateTime: 2021/6/22 21:34
 * @Desc: java 程序
 * @Version: 1.0
 */
public class TongPeiFu {
    public static void main(String[] args) {

    }

    public static void addString1(List<? extends Object> list){
        //list.add("a");
        //list.add(new TongPeiFu());
        //list.add(new Object());
    }

    public static void addString2(List<? super TongPeiFu> list){
        //list.add("a");
        list.add(new TongPeiFu());
        //list.add(new Object());
    }
}
