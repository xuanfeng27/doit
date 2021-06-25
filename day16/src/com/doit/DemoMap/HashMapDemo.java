package com.doit.DemoMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: HashMapDemo
 * @Author: zll
 * @CreateTime: 2021/6/24 14:43
 * @Desc: java 程序
 * @Version: 1.0
 */
//HashMap 默认的初始容量为 16 ;变成树型结构的临界值为 8; 恢复链式结构的临界值为 6
//当哈希表的大小超过这个阈值static final int MIN_TREEIFY_CAPACITY = 64;才会把链式结构转化成树型结构，否则仅采取扩容来尝试减少冲突
//按照原来的拉链法来解决冲突，如果一个桶上的冲突很严重的话，是会导致哈希表的效率降低至 O（n），而通过红黑树的方式，可以把效率改进至 O（logn）。
// 相比链式结构的节点，树型结构的节点会占用比较多的空间，所以这是一种以空间换时间的改进方式。
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Person,String> map = new HashMap<Person, String>();
        map.put(new Person("aaa",38),"北京");
        map.put(new Person("bbb",28),"撒谎");
        map.put(new Person("ccc",18),"上海");
        map.put(new Person("ccc",18),"世界");
        //map.put(null,null);//HashMap允许null值和null键
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
