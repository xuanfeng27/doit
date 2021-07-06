package com.doit.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName: Demo
 * @Author: zll
 * @CreateTime: 2021/7/5 21:19
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
枚举的定义

- 格式：`public enmu 枚举名{}`
- 枚举常量定义：
  - 枚举中的常量名字大写，多个常量之间逗号分开，最后一个常量可以写分号，也可以不写。
    每一个常量，都表示这个类的对象。修饰符为`public static final`。
  - 枚举中有默认的无参数的private修饰的构造方法，如果手写构造方法，也必须是私有修饰的。
    而且构造方法必须写在常量的后面，这时最后一个常量就必须要写分号。
 */


public enum Demo {
    //枚举静态常量，直接为变量color赋值
    RED("红色"),GREEN("绿色"),YELLOW("黄色");

    private String color;

    private Demo(String color){
        this.color = color ;
    }
}
