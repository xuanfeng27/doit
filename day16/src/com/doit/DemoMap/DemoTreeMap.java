package com.doit.DemoMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName: DemoTreeMap
 * @Author: zll
 * @CreateTime: 2021/6/24 14:52
 * @Desc: java 程序
 * @Version: 1.0
 */
//构造函数
// public TreeMap()键要实现自然排序接口；
// public TreeMap(Comparator c);
// public TreeMap(Map map)
//
public class DemoTreeMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("ccc",111);
        map.put("aaa",222);
        map.put("bbb",333);
        map.put("ddd",444);
        System.out.println(map);
        Map<String, Integer> map2 = new TreeMap<String, Integer>(map);
        System.out.println(map2);

        Map<String, Integer> map3 = new TreeMap<String, Integer>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

    }
}
