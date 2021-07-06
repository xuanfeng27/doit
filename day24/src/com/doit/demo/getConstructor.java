package com.doit.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName: getConstructor
 * @Author: zll
 * @CreateTime: 2021/7/6 11:18
 * @Desc: java 程序
 * @Version: 1.0
 */
public class getConstructor {
    public static void main(String[] args) throws  Exception {
        //获取Class对象
        Class<?> c = Class.forName("com.doit.bean.Person");
        //获取空参构造方法  是public修饰的
        Constructor<?> constructor = c.getConstructor();
        System.out.println(constructor);
        //获取构造方法数组 是public修饰的
        Constructor<?>[] cs = c.getConstructors();
        for (Constructor<?> c1 : cs) {
            System.out.println(c1);
        }
        //获取Person对象实例
        Object obj = constructor.newInstance();// Object obj = new Person();
        System.out.println(obj);

        //方便写法，Class对象只能获取空参构造方法
        Object o1 = c.newInstance();
        System.out.println(o1);


        //获取带参构造方法，运行构造方法
        Constructor<?> cs1 = c.getConstructor(String.class, int.class);//可变参数（Class...type）
        Object o = cs1.newInstance("liuyan", 38);//可变参数（Object...init）
        System.out.println(o);

        //获取所有构造方法，包括私有构造
        //java.lang.reflect 类 AccessibleObject  setAccessible(boolean b)
            //直接已知子类：
            //Constructor, Field, Method
        Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();
        Constructor<?> dc = c.getDeclaredConstructor(String.class);
        System.out.println(dc);//private com.doit.bean.Person(java.lang.String)
        dc.setAccessible(true);//取消权限检查，暴力反射 ，不推荐使用，破坏了类的封装
        Object obj2 = dc.newInstance("dalang");
        System.out.println(obj2);//Person{name='dalang', age=0}
    }
}
