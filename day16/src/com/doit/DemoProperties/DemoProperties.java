package com.doit.DemoProperties;

import java.util.Properties;
import java.util.Set;

/**
 * @ClassName: DemoProperties
 * @Author: zll
 * @CreateTime: 2021/6/24 15:42
 * @Desc: java 程序
 * @Version: 1.0
 */
//Properties :底层哈希表，键无序 唯一
// 实现类Map接口 ； 没有泛型 K V都是String  ； 唯一一个能够和IO流直接结合使用的集合
// 方法：String setProperty(String K,String V)  getProperty(K)    stringPropertyNames（）

public class DemoProperties {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("name","abc");
        props.setProperty("age","22");
        System.out.println(props);
        String age = props.getProperty("age");

        Set<String> keys = props.stringPropertyNames();
        for (String key:keys){
            System.out.println(key +"="+ props.getProperty(key));
        }

    }
}
