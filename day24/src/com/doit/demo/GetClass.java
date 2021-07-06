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
