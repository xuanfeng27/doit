package com.doit.demoGetMethod;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ClassName: DemoTest
 * @Author: zll
 * @CreateTime: 2021/7/6 15:04
 * @Desc: java 程序
 * @Version: 1.0
 */
public class DemoTest {
    public static void main(String[] args) throws Exception {
        File f = new File("day24\\src\\com\\doit\\demoGetMethod\\demoTest.properties");
        Properties props = new Properties();
        Reader r = new FileReader(f);
        props.load(r);
        r.close();

        String className = props.getProperty("className");
        String methodName = props.getProperty("methodName");
        Class<?> c = Class.forName(className);
        Object o = c.newInstance();
        Method method = c.getMethod(methodName);
        method.invoke(o);
    }
}
