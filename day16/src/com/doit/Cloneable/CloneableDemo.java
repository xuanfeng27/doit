package com.doit.Cloneable;

/**
 * @ClassName: CloneableDemo
 * @Author: zll
 * @CreateTime: 2021/6/24 20:05
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
**克隆的前提条件:**
- 被克隆的对象必须实现Cloneable接口
- 必须重写clone方法
 */

public class CloneableDemo implements Cloneable{

    private int age;
    private String name;
    private Student student;

    public CloneableDemo(int age, String name, Student student) {
        this.age = age;
        this.name = name;
        this.student = student;
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

    public CloneableDemo(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public CloneableDemo() {
    }

    @Override
    public CloneableDemo clone() throws CloneNotSupportedException {
        CloneableDemo clone = (CloneableDemo) super.clone();
        clone.setStudent(student.clone());
        return clone;

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "CloneableDemo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}


class Student implements Cloneable{
    private String address;
    public Student() {
    }

    public Student(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" +
                "address='" + address + '\'' +
                '}';
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}