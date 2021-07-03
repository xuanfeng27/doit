package com.doit.demo;

import java.io.File;
import java.io.FileFilter;
import java.util.*;

/**
 * @ClassName: DemoLambda
 * @Author: zll
 * @CreateTime: 2021/7/3 9:20
 * @Desc: java 程序
 * @Version: 1.0
 */
/*Open JDK 官网介绍

    Open JDK 官网： http://openjdk.java.net/ 。
    JDK Enhancement Proposals(JDK增强建议)。通俗的讲JEP就是JDK的新特性
*/

//lambda使用条件：
// 1.必须是接口，不能是抽象类
// 2.接口中只有一个抽象方法

/*
省略格式:
在Lambda标准格式的基础上，使用省略写法的规则为：

    小括号内参数的类型可以省略；
    如果小括号内有且仅有一个参，则小括号可以省略；
    如果大括号内有且仅有一个语句，则无论是否有返回值，都可以省略大括号、return关键字及语句分号。
 */

public class DemoLambda {
    public static void main(String[] args) {
        testLambda();
        method(()->System.out.println("i can fly"));

    }

    public static void testLambda(){
        //线程
        new Thread(()->{
            System.out.println("mythread");
        }).start();

       // new Thread(()-> System.out.println("thread")).start();省略格式

        //forEach
        Map<String,Integer> map = new HashMap<>();
        map.put("aaa",1);
        map.put("bbb",2);
        map.forEach((String s,Integer i)->{
            System.out.println(s+"="+i);
        });

        //map.forEach((k,v)-> System.out.println(k+"="+v));省略格式

        //文件过滤器
        File file = new File("d:\\zll\\apps\\test");
        File[] files = file.listFiles((File f) -> {
            System.out.println(f);
            return f.getName().toLowerCase().endsWith(".java");
        });
        System.out.println(Arrays.toString(files));

        //File[] files2 = file.listFiles(f->f.getName().toLowerCase().endsWith(".java"));省略格式

        //list集合比较器排序
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("aaa",22));
        list.add(new Person("bbb",12));
        list.add(new Person("ccc",44));
        list.add(new Person("ddd",20));
        Collections.sort(list,(Person s,Person i)->{
            return s.getAge()- i.getAge();
        });
        System.out.println(list);

        //Collections.sort(list, ((o1, o2) -> o1.getAge() - o2.getAge()));省略格式
    }

    public static void method(Fly f){
        f.fly();
    }
}

interface Fly{
    abstract void fly();
}

