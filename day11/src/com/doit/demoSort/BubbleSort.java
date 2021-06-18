package com.doit.demoSort;

import java.util.Arrays;

/**
 * @ClassName: BubbleSort
 * @Author: zll
 * @CreateTime: 2021/6/18 17:05
 * @Desc: java 程序
 * @Version: 1.0
 */
//冒泡排序算法： 时间复杂度 O(n^2)  比较趟数：n(n-1)/2
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9,3,5,54,11,2,6};
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr){
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
