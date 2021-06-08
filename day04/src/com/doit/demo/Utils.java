package com.doit.demo;

import java.util.Arrays;

/**
 * @ClassName: Utils
 * @Author: zll
 * @CreateTime: 2021/6/7 10:42
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Utils {

    public static void main(String[] args) {
        int[] arr = new int[]{9,54,-2,0,2,33,483,256,99};
        quickSort(arr,0,arr.length-1);
    }

    public static void binarySearch(int[] arr){
        //二分法查找：要求此数组必须是有序的。
       // int[] arr = new int[]{-99,-54,-2,0,2,33,43,256,999};
        boolean isFlag = true;
        int number = 1;
        int head = 0;//首索引位置
        int end = arr.length - 1;//尾索引位置
        while(head <= end){
            int middle = (head + end) / 2;
            if(arr[middle] == number){
                isFlag = false;
                break;
            }else if(arr[middle] > number){
                end = middle - 1;
            }else{
                head = middle + 1;
            }
        }
        if(isFlag){
            System.out.println("未找打指定的元素");
        }
    }

    public static  void bubbleSort(){
        int[] arr = new int[]{99,-54,-2,0,2,33,43,6,79};
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int start, int end){
        if(start<end){
            int pivot = arr[start];
            int lowIdx = start;
            int highIdx = end+1;
            while (true){

                while (lowIdx < end && arr[++lowIdx] - pivot <= 0)
                    ;
                while (highIdx > start && arr[--highIdx] - pivot >= 0)
                    ;

                if (lowIdx < highIdx) {
                    swap(arr, lowIdx, highIdx);
                } else {
                    break;
                }
            }
            swap(arr,start,highIdx);
            quickSort(arr,start, highIdx-1);
            quickSort(arr,highIdx+1, end);
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}

