package com.doit.zy;

/**
 * @ClassName: Manager
 * @Author: zll
 * @CreateTime: 2021/6/14 20:08
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Manager extends Workers{
    private String managerSalary;

    public Manager() {
    }

    public Manager(String id, String name, String salary, String managerSalary) {
        super(id, name, salary);
        this.managerSalary = managerSalary;
    }

    @Override
    public void jisuan() {
        System.out.println(getName()+getId() +"经理"+ getSalary() + managerSalary);
    }

    public String getManagerSalary() {
        return managerSalary;
    }

    public void setManagerSalary(String managerSalary) {
        this.managerSalary = managerSalary;
    }

}
