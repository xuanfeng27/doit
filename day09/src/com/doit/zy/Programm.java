package com.doit.zy;

/**
 * @ClassName: Programm
 * @Author: zll
 * @CreateTime: 2021/6/14 20:13
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Programm extends Workers{
    private String projectSalary;

    public Programm() {
    }

    public Programm(String id, String name, String salary, String projectSalary) {
        super(id, name, salary);
        this.projectSalary = projectSalary;
    }

    @Override
    public void jisuan() {
        System.out.println(getName()+getId() +"程序员"+getSalary()+projectSalary);
    }

    public String getProjectSalary() {
        return projectSalary;
    }

    public void setProjectSalary(String projectSalary) {
        this.projectSalary = projectSalary;
    }
}
