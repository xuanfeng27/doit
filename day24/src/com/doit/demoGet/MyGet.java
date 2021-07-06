package com.doit.demoGet;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.Set;

/**
 * @ClassName: MyGet
 * @Author: zll
 * @CreateTime: 2021/7/6 16:18
 * @Desc: java 程序
 * @Version: 1.0
 */
//反射 依赖注入
public class MyGet {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        Reader r = new FileReader("day24\\src\\com\\doit\\demoGet\\my.properties");
        props.load(r);
        String className = props.getProperty("className");
        Class<?> c = Class.forName(className);
        Object o = c.newInstance();
        Set<String> set = props.stringPropertyNames();
        for (String s : set) {
            if(!s.equals("className")){

                String str = "set"+s.substring(0,1).toUpperCase()+s.substring(1);
                c.getMethod(str,String.class).invoke(o,props.getProperty(s));
            }
        }
        System.out.println(o);
    }
}
