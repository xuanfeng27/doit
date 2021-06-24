package com.doit.DemoMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: HashMapDemo
 * @Author: zll
 * @CreateTime: 2021/6/24 14:43
 * @Desc: java 程序
 * @Version: 1.0
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Person,String> map = new HashMap<Person, String>();
        map.put(new Person("aaa",38),"北京");
        map.put(new Person("bbb",28),"撒谎");
        map.put(new Person("ccc",18),"上海");
        map.put(new Person("ccc",18),"世界");
        System.out.println(map);

        Set<Person> set = map.keySet();
        for (Person key : set) {
            System.out.println(key.getName()+key.getAge()+map.get(key));
        }

        Set<Map.Entry<Person, String>> set2= map.entrySet();
        for (Map.Entry<Person, String> en : set2) {
            System.out.println(en.getKey().getName()+en.getKey().getAge()+en.getValue());
        }
    }
}
