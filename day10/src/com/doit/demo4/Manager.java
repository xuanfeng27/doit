package com.doit.demo4;

/**
 * @ClassName: Manager
 * @Author: zll
 * @CreateTime: 2021/6/15 16:50
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, String id, double cunkuan, double salary, double bonus) {
        super(name, id, cunkuan, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
