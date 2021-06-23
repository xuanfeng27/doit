package com.doit.demo2;


import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName: demo2_2
 * @Author: zll
 * @CreateTime: 2021/6/23 21:30
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
    随机生成 10个  1-100的随机数  要求 随机数不能重复   将生成的随机数降序打印
 */
public class demo2_2 {
    public static void main(String[] args) {
        Random r = new Random();
        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        while (set.size() < 10){
            int num =  r.nextInt(100)+1;
            set.add(num);
        }
        System.out.println(set);

    }
}
