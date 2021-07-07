package com.doit.demo;

import com.doit.bean.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * @ClassName: GetClass
 * @Author: zll
 * @CreateTime: 2021/7/6 10:47
 * @Desc: java 程序
 * @Version: 1.0
 */
//三种获取Class对象方法
public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        //1. Object类的getClass方法
        Person p = new Person();
        Class<? extends Person> c1 = p.getClass();
        System.out.println(c1);

        //2. 任意类型的隐藏静态属性class  传参使用  Person类加载不会初始化
        Class<Person> c2 = Person.class;
        System.out.println(c2);
        System.out.println(c1==c2);

        //3. Class类的 静态方法 forName(String str)   配置文件使用
        Class<?> c3 = Class.forName("com.doit.bean.Person");
        System.out.println(c3);

        getPersonClass();
    }

    public static void getPersonClass() throws IOException, ClassNotFoundException {
        Properties props = new Properties();
        Reader r = new FileReader("day24\\text.properties");
        props.load(r);
        String className = props.getProperty("className");
        Class<?> c = Class.forName(className);
        System.out.println(c);
    }
}

/*
了解：什么时候会发生类初始化？
 类的主动引用（一定会发生类的初始化）
     当虚拟机启动，先初始化main方法所在的类
     new一个类的对象
     调用类的静态成员（除了final常量）和静态方法
     使用java.lang.reflect包的方法对类进行反射调用
     当初始化一个类，如果其父类没有被初始化，则先会初始化它的父类

 类的被动引用（不会发生类的初始化）
     当访问一个静态域时，只有真正声明这个域的类才会被初始化
     当通过子类引用父类的静态变量，不会导致子类初始化
     通过数组定义类引用，不会触发此类的初始化
     引用常量不会触发此类的初始化（常量在链接阶段就存入调用类的常量池中了）

 */
class LoadingTest {
    public static void main(String[] args) {
    // 主动引用：一定会导致A和Father的初始化
        // A a = new A();
        // System.out.println(A.m);
        // Class.forName("com.atguigu.java2.A");

    // 被动引用
    A[] array = new A[5];//不会导致A和Father的初始化
        // System.out.println(A.b);//只会初始化Father
        // System.out.println(A.M);//不会导致A和Father的初始化
    }
    static {
        System.out.println("main所在的类");
    }
}

class Father {
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }
}
class A extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;
}
