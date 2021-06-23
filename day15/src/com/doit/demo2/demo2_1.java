package com.doit.demo2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @ClassName: demo2_1
 * @Author: zll
 * @CreateTime: 2021/6/23 21:16
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
    去掉List集合中的重复元素
 */
public class demo2_1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("bbb");
        list.add("bbb");
        list.add("aaa");
        list.add("ccc");
        list.add("ddd");
        list.add("ccc");
        Set<String> set = new LinkedHashSet<>(list);
        ArrayList<String> list2 = new ArrayList<>(set);
        System.out.println(list2);

        ArrayList<String> list3 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(!list3.contains(list.get(i))){
                list3.add(list.get(i));
            }
        }
        System.out.println(list3);
    }
}
