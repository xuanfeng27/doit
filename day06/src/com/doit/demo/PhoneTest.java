package com.doit.demo;

import java.util.Arrays;
import java.util.Objects;

/**
 * @ClassName: PhoneTest
 * @Author: zll
 * @CreateTime: 2021/6/9 10:41
 * @Desc: java 程序
 * @Version: 1.0
 */
public class PhoneTest {
    public static void main(String[] args) {
        Phone ph = new Phone();
        ph.name = "xiaomi";
        ph.price = 1888.4;

        Phone ph2 = new Phone();
        ph2.name = "huawei";
        ph2.price=2199;

        Phone ph3 = new Phone();

        Phone[] phoneArr = new Phone[3];
        phoneArr[0] = ph;
        phoneArr[1] = ph2;
        phoneArr[2] = ph3;



        for (int i = 0; i < phoneArr.length; i++) {

           System.out.println(phoneArr[i].name);
        }
    }
}
