package com.doit.zy;

/**
 * @ClassName: Company
 * @Author: zll
 * @CreateTime: 2021/6/14 20:15
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Company {
    public static void main(String[] args) {
        Manager m = new Manager("liuyan","001","10000","5000");
        method(m);
    }

    public static void method(Workers workers){
        if (workers instanceof Manager){
            System.out.println("职位：经理");
        }
        workers.jisuan();
    }
}
