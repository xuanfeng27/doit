package com.doit.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: DemoHashSet
 * @Author: zll
 * @CreateTime: 2021/6/24 9:06
 * @Desc: java 程序
 * @Version: 1.0
 */
//HashSet 特点：无序  唯一
                    // 先比较hashCode 不同就添加，若相同再比较equals(重写)不同添加，相同不添加
public class DemoHashSet {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        set.add(new Person("aaa",38));
        set.add(new Person("bbb",25));
        set.add(new Person("aaa",38));
        System.out.println(set);

        HashSet<Person> set2 = new HashSet<>(8);//8的倍数


        //LinkedHashSet 链表（有序） + 哈希表（唯一）

    }
}
