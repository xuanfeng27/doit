package com.doit.demoTryCatch;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: TryCatchInherit
 * @Author: zll
 * @CreateTime: 2021/6/20 17:02
 * @Desc: java 程序
 * @Version: 1.0
 */
public class TryCatchInherit {
    public static void main(String[] args) {
        new Zi().method1();
    }
}

class Fu {
    public void method() throws Exception {

    }

    public void method1() {

    }
}

class Zi extends Fu{
    @Override
    public void method() throws FileNotFoundException {//子类方法声明异常不能超过父类方法声明异常

    }

    @Override
    public void method1() {//父类方法没有声明异常，子类也不能声明异常，必须使用try catch处理
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = df.parse("2020-11-12");
            System.out.println(d.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}