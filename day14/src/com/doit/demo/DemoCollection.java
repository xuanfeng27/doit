package com.doit.demo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName: DemoCollection
 * @Author: zll
 * @CreateTime: 2021/6/21 9:09
 * @Desc: java 程序
 * @Version: 1.0
 */
public class DemoCollection {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();//多态
        c.add("aaa");
        c.add("bbb");
        c.add("ccc");
        c.add("ddd");

        System.out.println(c.contains("bbb"));
        System.out.println(c.isEmpty());
        System.out.println(c.size());
        c.remove("ccc");
        System.out.println(c);
       // c.clear();

        for (int i = 0; i < c.size(); i++) {
           // System.out.println(c.get(i));报错，Collection中么有索引，没这个方法，ArrayList才有
        }

        //第一种
        String[] str = c.toArray(new String[c.size()]);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }

        Object[] obj = c.toArray();//多态
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
        }
    }
}
