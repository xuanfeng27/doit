package com.doit.demo1;

import java.util.Collections;
import java.util.Iterator;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/23 19:43
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<String>();
        System.out.println(list);
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.add(1,"eee");
        System.out.println(list);
        list.remove("ccc");
        System.out.println(list);
        System.out.println(list.size());
        //list.add(-2,"666");

        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
    }
}
