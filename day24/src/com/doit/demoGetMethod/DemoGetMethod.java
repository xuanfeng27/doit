package com.doit.demoGetMethod;

import java.lang.reflect.Method;

/**
 * @ClassName: DemoGetMethod
 * @Author: zll
 * @CreateTime: 2021/7/6 14:47
 * @Desc: java 程序
 * @Version: 1.0
 */
public class DemoGetMethod {
    public static void main(String[] args) throws Exception {
        Class<?> c = Class.forName("com.doit.bean.Person");
        //获取所有非私有方法，包括继承
        Method[] methods = c.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("---------------------------------------");
        //获取所有方法，包括私有，不包括继承
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
        System.out.println("---------------------------------------");
        //获取setAge方法并运行
        Method setAge = c.getMethod("setAge", int.class);
        Object o = c.newInstance();
        setAge.invoke(o,18);
        System.out.println(o);
        System.out.println("---------------------------------------");
        //获取getAge方法并运行
        Method getAge = c.getMethod("getAge");
        Object age = getAge.invoke(o);
        System.out.println(age);

    }
}
