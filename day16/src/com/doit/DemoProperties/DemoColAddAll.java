package com.doit.DemoProperties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @ClassName: DemoColAddAll
 * @Author: zll
 * @CreateTime: 2021/6/24 16:25
 * @Desc: java 程序
 * @Version: 1.0
 */
//Collections  static <T> boolean addAll(Collection c, T...elements )
public class DemoColAddAll {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        Collections.addAll(c,"a","bb","ccc","dddd");
        System.out.println(c);
    }
}
