package com.doit.demo4;

/**
 * @ClassName: Employee
 * @Author: zll
 * @CreateTime: 2021/6/15 16:48
 * @Desc: java 程序
 * @Version: 1.0
 */
public abstract class Employee {
    private String name;
    private String id;
    private double cunkuan;
    private double salary;

    public Employee() {
    }

    public Employee(String name, String id, double cunkuan, double salary) {
        this.name = name;
        this.id = id;
        this.cunkuan = cunkuan;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCunkuan() {
        return cunkuan;
    }

    public void setCunkuan(double cunkuan) {
        this.cunkuan = cunkuan;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
