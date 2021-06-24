package com.doit.Cloneable;

import java.util.Arrays;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/24 20:23
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneableDemo c = new CloneableDemo(11,"aaa",new Student("北京"));
        CloneableDemo c2 = c.clone();
        System.out.println(c);
        System.out.println(c2);
        c2.setAge(22);
        c2.setName("bbb");

        c2.getStudent().setAddress("SHANGHAI");
        System.out.println(c);
        System.out.println(c2);

        //T[] 任何数组已经实现了Cloneable接口
        int[] arr = new int[]{1,2,3,4,5};
        int[] arr2 = arr.clone();
        arr2[0]=100;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));


    }
}
