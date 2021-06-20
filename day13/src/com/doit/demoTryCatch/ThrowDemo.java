package com.doit.demoTryCatch;

import java.io.FileNotFoundException;

/**
 * @ClassName: ThrowDemo
 * @Author: zll
 * @CreateTime: 2021/6/20 16:02
 * @Desc: java 程序
 * @Version: 1.0
 */
public class ThrowDemo {
    public static void main(String[] args) {
        int i = 1;
        try {//处理异常
            method(i);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

    public static void method(int i) throws FileNotFoundException,ClassNotFoundException {//声明异常提醒
        if (i==0){
            throw new FileNotFoundException("文件没找到");//throw 异常对象
        } else if (i == 1) {
            throw new ClassNotFoundException("类转换异常");
        }
    }
}
