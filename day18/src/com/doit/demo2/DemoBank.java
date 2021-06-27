package com.doit.demo2;

/**
 * @ClassName: DemoBank
 * @Author: zll
 * @CreateTime: 2021/6/27 20:32
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
模拟银行取钱的问题
1.定义一个Account类
    1）该Account类封装了账户编号（String）和余额（double）两个属性
    2）设置相应属性的getter和setter方法
    3）提供无参和有两个参数的构造器
    4）系统根据账号判断与用户是否匹配，需提供hashCode()和equals()方法的重写
2.提供两个取钱的线程类：小明、小明 wife
    1）提供了Account类的account属性和double类的取款额的属性
    2）提供带线程名的构造器
    3）run()方法中提供取钱的操作
3.在主类中创建线程进行测试。考虑线程安全问题。
 */
public class DemoBank {
    public static void main(String[] args) {
        Account account = new Account("432343",1000);
        Task task = new Task(account,200);
        Task task2 = new Task(account,300);
        for (int i = 0; i < 3; i++) {
            Thread t1 = new Thread(task,"小明");
            Thread t2 = new Thread(task2,"wife");
            t1.start();
            t2.start();
        }
    }
}

class Account{
    private String id;
    private double balance;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.balance, balance) != 0) return false;
        return id != null ? id.equals(account.id) : account.id == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

class Task implements Runnable {
    private Account account;
    private double withDraw;

    public Task(Account account, double withDraw) {
        this.account = account;
        this.withDraw = withDraw;
    }

    @Override
    public void run() {
        synchronized (account){
            if (account.getBalance()>= withDraw) {
                account.setBalance(account.getBalance()-withDraw);
                System.out.println(Thread.currentThread().getName()+ "取走了"+withDraw);
                System.out.println("余额还有："+account.getBalance());
                System.out.println("--------------------------------------");
            }else {
                System.out.println("现金不足，取款失败");
            }
        }
    }
}