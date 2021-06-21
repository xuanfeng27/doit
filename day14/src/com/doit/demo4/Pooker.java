package com.doit.demo4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: Pooker
 * @Author: zll
 * @CreateTime: 2021/6/21 19:30
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
     斗地主案例

     1.准备牌
           定义一个集合用来存储54张扑克牌
           四种花色  ♥-♠-♦-♣
           牌的数字  2-A-K-Q-J-10-9-8-7-6-5-4-3
           循环拼接扑克牌 将扑克牌放入到集合中
           最后向集合中添加 大王 和小王
     2.洗牌
           Collections 单列集合工具类
              static void  shuffle(List list)  将集合中元素的顺序打乱
     3.发牌
            三个玩家三个集合
            底牌一个集合
            遍历集合 依次获取每张扑克牌
            判断索引  发扑克牌

            索引>=51  底牌
            索引%3==0  玩家1
            索引%3==1  玩家2
            索引%3==2  玩家3


     4.看牌
           遍历 直接 toString
 */

public class Pooker {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String[] a = {"♥","♠","♦","♣"};
        String[] b = "2-A-K-Q-J-10-9-8-7-6-5-4-3".split("-");

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                list.add(a[i]+b[j]);
            }
        }
        list.add("大王@");
        list.add("小王@");
        System.out.println(list);

        Collections.shuffle(list);

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> listDi = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(i>=51){
                listDi.add(list.get(i));
            }else if(i % 3 == 0){
                list1.add(list.get(i));
            }else if (i % 3 == 1) {
                list2.add(list.get(i));
            }else if (i % 3 == 2){
                list3.add(list.get(i));
            }
        }
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(listDi);

    }
}
