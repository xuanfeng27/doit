package com.doit.demoGet;

/**
 * @ClassName: Student
 * @Author: zll
 * @CreateTime: 2021/7/6 16:15
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Student {
    private String name;
    private String age;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
