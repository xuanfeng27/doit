package com.doit.demoSort;

import java.util.Arrays;

/**
 * @ClassName: QuickSort
 * @Author: zll
 * @CreateTime: 2021/6/18 19:49
 * @Desc: java 程序
 * @Version: 1.0
 */
//快速排序 时间复杂度：O(N*logN)
/*
https://www.runoob.com/w3cnote/quick-sort.html
该方法的基本思想是：
1．先从数列中取出一个数作为基准数。
2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
3．再对左右区间重复第二步，直到各区间只有一个数。

对挖坑填数进行总结:
1．i =L; j = R; 将基准数挖出形成第一个坑a[i]。
2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {72, 6,57 ,88 ,60 ,42 ,83 ,73 ,48 ,85};
        quickSort(arr,0, arr.length-1);
    }

    public static void quickSort(int[] arr,int left,int right){
        if (left < right){
            int i = left;
            int j = right;
            int base = arr[left];
            while (i < j){
                while (i < j && arr[j] > base){
                    j--;
                }
                if(i < j){
                    arr[i] = arr[j];
                    i++;
                }

                while (i < j && arr[i] < base) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = base;
            quickSort(arr, left, i-1);
            quickSort(arr, i+1, right);
        }
        System.out.println(Arrays.toString(arr));
    }

}
