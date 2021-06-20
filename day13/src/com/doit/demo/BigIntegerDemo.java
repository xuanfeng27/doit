package com.doit.demo;

import java.math.BigInteger;
import java.util.Random;

/**
 * @ClassName: BigIntegerDemo
 * @Author: zll
 * @CreateTime: 2021/6/20 9:33
 * @Desc: java 程序
 * @Version: 1.0
 */
public class BigIntegerDemo {
    public static void main(String[] args) {
        BigInteger b1 = new BigInteger("1111111111111111111111111111111111111");
        BigInteger b2 = new BigInteger("222222222222222222222222222222");
        BigInteger add = b1.add(b2);
        System.out.println(add);
        BigInteger subtract = b1.subtract(b2);
        System.out.println(subtract);
        BigInteger multiply = b1.multiply(b2);
        System.out.println(multiply);
        BigInteger divide = b1.divide(b2);//整除，去掉小数部分
        System.out.println(divide.toString());
        System.out.println(divide.intValue());

        BigInteger b3 = new BigInteger("111111111111111",2);
        System.out.println(b3);

        byte[] bb = {'1','2','3'};
        BigInteger b5 = new BigInteger(bb);
        System.out.println(b5);


    }
}
