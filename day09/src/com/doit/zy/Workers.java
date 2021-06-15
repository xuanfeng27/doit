package com.doit.zy;

/**
 * @ClassName: Workers
 * @Author: zll
 * @CreateTime: 2021/6/14 20:04
 * @Desc: java 程序
 * @Version: 1.0
 */
public abstract class Workers {
     private String id;
     private String name;
     private String salary;

    public Workers() { }

    public Workers(String id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public abstract void jisuan();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
