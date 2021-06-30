package com.doit.demoProperties;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * @ClassName: DemoProperties
 * @Author: zll
 * @CreateTime: 2021/6/30 17:32
 * @Desc: java 程序
 * @Version: 1.0
 */
public class DemoProperties {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        InputStream in = new FileInputStream("day20\\src\\com\\doit\\props.properties");
        props.load(in);
        in.close();
        System.out.println(props);

        FileWriter fw = new FileWriter("..\\props.properties");
        props.setProperty("001","哈哈");  //键 无序 唯一 不允许 null键和null值
        props.store(fw,"");
        fw.close();
        System.out.println(props);
    }
}
/*
     java.util.Properties  属性集合 双列集合
        特点
             1.继承Hashtable 实现Map接口  可以使用Map的所有的方法
             2.没有泛型 键String  值String
             3.唯一一个可以和IO流直接结合使用的集合

        特有方法
             String setProperty(String key ,String value) 添加数据 相当于 put
             String getProperty(String key) 根据键找值 相当于 get
             set<String> stringPropertyNames() 获取所有键的Set集合  相当于 keySet
 */

/*
     和IO流结合使用

     void load(InputStream in ) 可以将文件中的键值对加载到集合中
               方法的参数是InputStream 可以传入其任意子类对象  FileInputStream
     void load(Reader r)
               方法的参数是Reader 可以传入其任意子类对象 FileReader


 */