package com.doit.demo;

import java.math.BigDecimal;

/**
 * @ClassName: BigDecimalDemo
 * @Author: zll
 * @CreateTime: 2021/6/20 10:27
 * @Desc: java 程序
 * @Version: 1.0
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        //不要传double类型0.01，本身就不精确，用字符串
        BigDecimal b1 = new BigDecimal("0.01");
        BigDecimal b2 = new BigDecimal("0.03");

        BigDecimal add = b1.add(b2);
        System.out.println(add.doubleValue());
        BigDecimal subtract = b1.subtract(b2);
        System.out.println(subtract);
        BigDecimal multiply = b1.multiply(b2);
        System.out.println(multiply);
        BigDecimal divide = b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);
        System.out.println(divide.doubleValue());

    }
}
