package com.doit.demoSort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: ComparatorTest
 * @Author: zll
 * @CreateTime: 2021/6/19 13:26
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
方式二：定制排序：java.util.Comparator
 当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那
么可以考虑使用 Comparator 的对象来排序，强行对多个对象进行整体排序的比较。
 重写compare(Object o1,Object o2)方法，比较o1和o2的大小：如果方法返回正整数，则表示o1大于o2；
如果返回0，表示相等；返回负整数，表示o1小于o2。
 可以将 Comparator 传递给 sort 方法（如 Collections.sort 或 Arrays.sort），从而允许在排序顺序上实现精确控制。
 还可以使用 Comparator 来控制某些数据结构（如有序 set或有序映射）的顺序，或者为那些没有自然顺序的对象 collection 提供排序。
 */

class Goods2 {
    private String name;
    private double price;

    public Goods2(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        Goods2[] all = new Goods2[4];
        all[0] = new Goods2("War and Peace", 100);
        all[1] = new Goods2("Childhood", 80);
        all[2] = new Goods2("Scarlet and Black", 140);
        all[3] = new Goods2("Notre Dame de Paris", 120);
        Arrays.sort(all, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Goods2 g1 = (Goods2) o1;
                Goods2 g2 = (Goods2) o2;
                return g1.getName().compareTo(g2.getName());
            }
        });
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i].getName());
        }
        System.out.println(Arrays.toString(all));
    }
}
