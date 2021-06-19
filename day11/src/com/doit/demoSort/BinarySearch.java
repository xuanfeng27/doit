package com.doit.demoSort;

/**
 * @ClassName: BinarySearch
 * @Author: zll
 * @CreateTime: 2021/6/18 17:27
 * @Desc: java 程序
 * @Version: 1.0
 */
//二分查找、折半查找
//前提条件：数组是有序排列的
//时间复杂度：100 50 25 ----> n/2^k =1---->可得k=log2n,所以时间复杂度可以表示O(h)=O(log2n)
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,11,21,64};
        int result = binarySearch(arr,9);
        System.out.println(result);
    }

    public static int binarySearch(int[] arr,int key){
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            //int mid = (low+high)/2;不推荐，可能会整型溢出
            int mid  = low +(high-low)/2; //推荐写法
            if (key>arr[mid]){
                low = mid+1;
            }else if(key<arr[mid]){
                high = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
