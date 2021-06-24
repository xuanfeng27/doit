package com.doit.DemoMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: DemoMap
 * @Author: zll
 * @CreateTime: 2021/6/24 10:45
 * @Desc: java 程序
 * @Version: 1.0
 */
//Map<K,V>双列集合的顶层接口
    //TreeMap（null键不行，可以null值）  HashMap（允许null值和null键）   LinkdeHashMap（允许null值和null键）
    //方法：V put(K,V) 返回值null添加成功，键相同时返回被覆盖的值  putIfAbsent(K,V)键相同时不改
    //V get(K) 键不存在返回null   getOrDefault(K,Default)避免null异常
    //boolean containsKey(K)
    //V remove(K)
public class DemoMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("aaa",11);
        map.put("bbb",22);
        map.put("ccc",33);
        map.put("bbb",23);
        System.out.println(map);

        Integer val = map.get("aaa");
        System.out.println(val);
        Integer value = map.remove("aaa");
        System.out.println(value);

        //遍历
        Set<String> set = map.keySet();
        System.out.println(set);
        for (String key : set) {
            Integer value2 = map.get(key);
            System.out.println(key+"="+value2);
        }

        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String next = it.next();
            System.out.println(next+"="+map.get(next));
        }

        map.forEach((K,V)->{
            System.out.println(K+"="+V);
        });

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> it2 = entries.iterator();
        while (it2.hasNext()){
            System.out.println(it2.next());
        }


    }
}
