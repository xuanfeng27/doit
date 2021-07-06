package com.doit.isTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * @ClassName: DemoIsTest
 * @Author: zll
 * @CreateTime: 2021/7/6 20:25
 * @Desc: java 程序
 * @Version: 1.0
 */
//模仿 JUnit4  Test  测试运行方法
public class DemoIsTest {

    @IsTest
    public static void method1(){
        System.out.println("method1");
    }


    public static void method2(){
        System.out.println("method2");
    }
    @IsTest
    public static void method3(){
        System.out.println("method3");
    }
}

//元注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface IsTest{

}


/*
            获取Demo01字节码文件对象
            获取Demo01中所有方法
            判断方法上是否有@MyTest注解
            如果有 运行该方法
        */
class TestJit{
    public static void main(String[] args) throws Exception {
        Class<DemoIsTest> c = DemoIsTest.class;
        DemoIsTest obj = c.newInstance();
        Method[] methods = c.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(IsTest.class)){
                m.invoke(obj);
            }
        }
    }
}

