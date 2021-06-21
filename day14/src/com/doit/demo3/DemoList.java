package com.doit.demo3;

import java.util.*;

/**
 * @ClassName: DemoList
 * @Author: zll
 * @CreateTime: 2021/6/21 17:10
 * @Desc: java 程序
 * @Version: 1.0
 */
//java.util.List接口
//特点：有序 有索引 元素可重复
public class DemoList {
    public static void main(String[] args) {
        List<String> list = new Stack<>();
        Stack<String> s = (Stack<String>) list;
        s.push("aaa");
        s.push("bbb");
        s.push("ccc");
        s.pop();
        for (String str : list) {
            System.out.println(str);
        }

        List<String> list1 = new ArrayList<>();
        list1.add("111");
        list1.add("222");
        Iterator<String> it = list1.iterator();
        for (String str : list1) {
            if (it.hasNext())
                System.out.println(it.next());
        }

        List<String> list2 = new ArrayList<>();
        list2.add("1112");
        list2.add("2222");
        ListIterator<String> it2 = list2.listIterator();
            while(it2.hasNext()){
                System.out.println(it2.next());
                it2.add("it22");
            }

            System.out.println(list2);
    }
}
