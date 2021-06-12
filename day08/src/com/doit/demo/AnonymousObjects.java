package com.doit.demo;

import java.util.ArrayList;

/**
 * @ClassName: AnonymousObjects
 * @Author: zll
 * @CreateTime: 2021/6/12 9:30
 * @Desc: java 程序
 * @Version: 1.0
 */
public class AnonymousObjects {
    public static void main(String[] args) {

        ArrayList<Person> arr = new ArrayList<>();
        arr.add(new Person(22,"aa"));


        new Person().setAge(33);
        //匿名对象在没有指定其引用变量时，只能使用一次。
        System.out.println(new Person().getAge());

        method(new Person());//匿名对象做参数

        Person p = methodReturn();

    }

    public static void method(Person p){
        System.out.println("形参 Anonymous objects");
    }

    public static Person methodReturn(){
        return new Person();//匿名对象做返回值
    }
}
