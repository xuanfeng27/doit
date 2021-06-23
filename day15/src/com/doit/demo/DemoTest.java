package com.doit.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName: DemoTest
 * @Author: zll
 * @CreateTime: 2021/6/21 20:49
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
ArrayList的JDK1.8之前与之后的实现区别？
 JDK1.7：ArrayList像饿汉式，直接创建一个初始容量为10的数组
 JDK1.8：ArrayList像懒汉式，一开始创建一个长度为0的数组，当add添加第一个元素时再创建一个始容量为10的数组
 */
/*
问题：为什么用Eclipse/IDEA复写hashCode方法，有31这个数字？
 选择系数的时候要选择尽量大的系数。因为如果计算出来的hash地址越大，所谓的“冲突”就越少，查找起来效率也会提高。
 并且31只占用5bits,相乘造成数据溢出的概率较小。
 31可以 由i*31== (i<<5)-1来表示,现在很多虚拟机里面都有做相关优化。（提高算法效率）
 31是一个素数，素数作用就是如果我用一个数字来乘以这个素数，那么最终出来的结果只能被素数本身和被乘数还有1来整除！(减少冲突)
 */
public class DemoTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr1 = {6,7,8};
        System.arraycopy(arr,0,arr1,1,2);
        System.out.println(Arrays.toString(arr1));//[6, 1, 2]
        int[] arr2 = {};
        int[] ints = arr2;
        System.out.println(arr2);
        System.out.println(ints);
        ints = Arrays.copyOf(ints, 10);
        System.out.println(ints);
        System.out.println(Arrays.toString(ints));//[1,2,3,4,5,0,0,0,0,0]

        Zll<String> zll = new Zll<>();
        zll.setName("zll");
        System.out.println(zll);

        ArrayList<Double> list = new ArrayList<>();
        list.add(1.4);
        list.add(3.3);
        Zll.method(list,2.9);
        zll.method2(list);
        zll.method3("list");
    }
}


class Zll<QQ> {
    private QQ name;

    public <T> void method3(T t){
        System.out.println(t.getClass());
    }

    public void method2(ArrayList<?> list){
        System.out.println(list);
    }

    public static <T> void method(ArrayList<T> list,T t){
        list.add(t);
        System.out.println(list);

    }

    public Zll(QQ name) {
        this.name = name;
    }

    public Zll() {
    }

    public QQ getName() {
        return name;
    }

    public void setName(QQ name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Zll{" +
                "name=" + name +
                '}';
    }
}

class ForTest {
    public static void main(String[] args) {
        String[] str = new String[5];
        for (String myStr : str) {
            myStr = "atguigu";
            System.out.println(myStr);
        }
        System.out.println(Arrays.toString(str));//[null, null, null, null, null]


    }


}

