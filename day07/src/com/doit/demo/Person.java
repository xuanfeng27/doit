package com.doit.demo;

/**
 * @ClassName: Person
 * @Author: zll
 * @CreateTime: 2021/6/11 9:36
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Person {
    //私有化private修饰的成员只能在本类中使用，不能再其他类中直接调用。
    private int age;
    private String name;
    private String adress;
    private boolean isBool;

    public Person() {
    }

    public boolean isBool() {
        return isBool;
    }

    public void setBool(boolean bool) {
        isBool = bool;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void eat() {
        System.out.println(name + " eat");
    }

    public void sleep() {
        System.out.println(age + " sleep");
    }

    public void hitBean() {
        System.out.println("hitBean " + name + age);
    }

}
