package com.doit.Cloneable;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/**
 * @ClassName: RandomAccessDemo
 * @Author: zll
 * @CreateTime: 2021/6/24 20:58
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
接口 RandomAccess
所有已知实现类：
ArrayList, AttributeList, CopyOnWriteArrayList, RoleList, RoleUnresolvedList, Stack, Vector
 */

public class RandomAccessDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //我们可以判断以下 这个list集合是否实现了RandomAccess接口
        //如果实现了 可以使用随机访问的方式来进行遍历
        //如果没实现 可以使用迭代器的方式来进行遍历 这样可以提高效率
        if(list instanceof RandomAccess){
            for (int i = 0; i < list.size(); i++) {

            }
        }else {
            for (String s : list) {

            }
        }
    }
}
