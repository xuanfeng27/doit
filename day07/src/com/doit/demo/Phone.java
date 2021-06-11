package com.doit.demo;

/**
 * @ClassName: Phone
 * @Author: zll
 * @CreateTime: 2021/6/11 10:38
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Phone {
    String brand;
    String color;
    double price;

    public void show(){
        System.out.println("brand:"+brand+","+"color:"+color+","+"price:"+price);
    }

    public void setAttr(String brand,String color,double price){
        this.brand = brand;
        this.color = color;
        this.price = price;
    }
}
