package com.doit.demoCollections;

/**
 * @ClassName: Person
 * @Author: zll
 * @CreateTime: 2021/6/23 14:54
 * @Desc: java 程序
 * @Version: 1.0
 */
//自定义类要实现Comparable<>接口，重写CompareTo()方法，才能使用Collectins.sort()方法自然排序

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private double height;

    public Person() {
    }

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Person o) {
       // return this.name.compareTo(o.name);
        return this.age - o.age;
        //return (int) (this.height - o.height);//错误，190.2-190.1=0.1,强转之后return 0 ,失败
       // return Double.compare(this.height, o.height);
    }
}
