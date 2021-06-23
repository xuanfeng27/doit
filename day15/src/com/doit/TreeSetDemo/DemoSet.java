package com.doit.TreeSetDemo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName: DemoSet
 * @Author: zll
 * @CreateTime: 2021/6/23 16:24
 * @Desc: java 程序
 * @Version: 1.0
 */
//TreeSet 排序 唯一 木有索引
//HashSet 无序 唯一
//LinkedHashSet 有序 唯一
public class DemoSet {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("222");
        set.add("111");
        set.add("333");
        set.add("444");
        set.add("444");
        System.out.println(set);

        Set<String> set2 = new HashSet<>();
        set2.add("222");
        set2.add("111");
        set2.add("333");
        set2.add("444");
        set2.add("444");
        System.out.println(set2);

        Set<String> set3 = new LinkedHashSet<>();
        set3.add("222");
        set3.add("111");
        set3.add("333");
        set3.add("444");
        set3.add("444");
        System.out.println(set3);

        for (String s : set3) {
            System.out.println(s);
        }
    }
}
