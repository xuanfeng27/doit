package com.doit.demoSort;

import java.util.Arrays;

/**
 * @ClassName: JavaCompare
 * @Author: zll
 * @CreateTime: 2021/6/19 12:47
 * @Desc: java 程序
 * @Version: 1.0
 */
// Java实现对象排序的方式有两种：
// 自然排序：java.lang.Comparable
// 定制排序：java.util.Comparator
/*
Java比较器方式一：自然排序：java.lang.Comparable
 Comparable接口强行对实现它的每个类的对象进行整体排序。这种排序被称为类的自然排序。
 实现 Comparable 的类必须实现 compareTo(Object obj) 方法，两个对象即通过 compareTo(Object obj) 方法的返回值来比较大小。如果当前对象this大
于形参对象obj，则返回正整数，如果当前对象this小于形参对象obj，则返回负整数，如果当前对象this等于形参对象obj，则返回零。
 实现Comparable接口的对象列表（和数组）可以通过 Collections.sort 或Arrays.sort进行自动排序。实现此接口的对象可以用作有序映射中的键或有
序集合中的元素，无需指定比较器。
 */

class Goods implements Comparable {
    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //按照价格，比较商品的大小
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods) {
            Goods other = (Goods) o;
            if (this.price > other.price) {
                return 1;
            } else if (this.price < other.price) {
                return -1;
            }
            return 0;
        }
        throw new RuntimeException("输入的数据类型不一致");
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

public class ComparableTest{
    public static void main(String[] args) {
        Goods[] all = new Goods[4];
        all[0] = new Goods("《红楼梦》", 100);
        all[1] = new Goods("《西游记》", 80);
        all[2] = new Goods("《三国演义》", 140);
        all[3] = new Goods("《水浒传》", 120);

        Arrays.sort(all);
        System.out.println(Arrays.toString(all));
    }
}


