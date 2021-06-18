package com.doit.demoSort;

import java.util.Arrays;

/**
 * @ClassName: ArraysTest
 * @Author: zll
 * @CreateTime: 2021/6/18 19:34
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
java.util.Arrays  数组工具类
  静态方法
      static String toString(int[] arr)  将给定的数组转换为字符串
      static void sort(int[] arr)  对数组中的元素 排序  从小到大
      static int binarySearch(int[] arr ,int key) 二分查找  如果不存在返回 -插入点-1
      static int[] copyOf(int[] arr ,int length) 复制数组,指定新的长度,如果长度超过原数组,将多余的元素设置为数组元素的默认值
 */
public class ArraysTest {
    public static void main(String[] args) {
        int[] arr = {43,33,2,12,35,6};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int index = Arrays.binarySearch(arr, 37);
        System.out.println(index);//-6 不存在返回 -插入点-1
        int[] arr1 = Arrays.copyOf(arr,10);
        System.out.println(Arrays.toString(arr1));

    }
}
