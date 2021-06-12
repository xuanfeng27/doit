package com.doit.heritage;

/**
 * @ClassName: Employee
 * @Author: zll
 * @CreateTime: 2021/6/12 10:33
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Employee {
    private int age;//私有的子类无法继承
    private String name;

    public Employee() {
    }

    public int play(){
        return 3;
    }

    public Employee work(){
        return new Employee();
    }


    public void eat(){
        System.out.println("employee eat");
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

}
