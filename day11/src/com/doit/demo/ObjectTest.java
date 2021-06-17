package com.doit.demo;

import java.util.ArrayList;

/**
 * @ClassName: ObjectTest
 * @Author: zll
 * @CreateTime: 2021/6/17 9:59
 * @Desc: java 程序
 * @Version: 1.0
 */
public class ObjectTest {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(obj);//java.lang.Object@1b6d3586 默认调用toString()
        String str = obj.toString();
        System.out.println(str);//java.lang.Object@1b6d3586

        ArrayList<Person> list = new ArrayList<Person>();
        Person p1 = new Person(12);
        System.out.println(p1);//覆写toString()
        list.add(p1);
        list.add(new Person(22));
        System.out.println(list.toString());

        //Person 重写 Object equals()方法
        Person p2 = new Person(52,"aaa");
        Person p3 = new Person(52,null);
        boolean bl =  p2.equals(p3);
        System.out.println(bl);

        //先比较hashcode,相同再比较equals方法
        System.out.println(obj.hashCode());
        System.out.println( p2.hashCode()==p3.hashCode());
    }
}
