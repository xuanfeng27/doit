package com.doit.demoTest;

import com.doit.demo.Person;

import java.util.Objects;

/**
 * @ClassName: test
 * @Author: zll
 * @CreateTime: 2021/6/9 9:42
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test {
    int a;
    Student stu;

    public Test(int a, Student stu) {
        this.a = a;
        this.stu = stu;
    }

    public Test() {
        System.out.println("no");
    }

    public Test(int a){
        System.out.println("aaa");
        this.a =a;
    }

    public static void main(String[] args) {
        new Test(3);

        Person p = new Person();
        p.age = 23;
        p.name="zhao";
        p.sex='男';
        System.out.println(p.age);

        Person p2 = new Person();
        p2.age = 33;
        p2.name="li";
        System.out.println(p2.height);

        System.out.println("------------自定义类equals覆写----------------");
        System.out.println(new Test(2).equals(new Test(2)));

        int big = Integer.MAX_VALUE;
        System.out.println("big = " + big);
        int bigger = big * 4;
        System.out.println("bigger = " + bigger);

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return a == test.a && Objects.equals(stu, test.stu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, stu);
    }
}
