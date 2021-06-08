package com.doit.demo;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName: LearnArray
 * @Author: zll
 * @CreateTime: 2021/6/7 9:35
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
常用快捷键
psvm main方法
sout 输出
100.fori 循环
ctrl+/ 单行注释
ctrl+shift+/ 多行注释
ctrl +d 复制
ctrl+y 删除
shift + enter 移动光标到下一行
alt+ctrl+L格式化
alt + enter 修复
*/
//数组的长度是固定的；
public class LearnArray {
    public static void main(String[] args) {
        //定义数组并赋值3种写法
        int[] arr = new int[4];
        int[] arr1 = new int[]{1,2,3};
        arr1 = new int[]{5,6};
        int[] arr2 = {2,5,7};//简化写法

        double[] arrd = new double[3];
        arrd[1]=10.1;
        System.out.println(arrd[0]);
        System.out.println(arrd[1]);

        float[] arrf = new float[]{3.14f,10.8f};
        byte[] arrb = new byte[]{10,20,30};
        long[] arrl = new long[]{100000000000L};

        char[] chs = new char[3];
        System.out.println(chs[1]);
        chs[2]='a';

        char[] arrch = new char[]{'a','b','c'};

        boolean[] bl = new boolean[3];
        System.out.println(bl[0]);
        bl[1]=true;
        System.out.println(bl[1]);

        String[] str = new String[3];
        System.out.println(str[0]);
        str[0] = "i";
        str[1]= "love";
        str[2] = "java";
        for (int i = str.length-1; i >=0; i--) {
            System.out.print(str[i]+" ");
        }

        boolean[] arrbol = new boolean[]{true,false,true};
        Random[] arrdom = new Random[3];
        Scanner[] arrsc = new Scanner[3];
        System.out.println("========================================================");
        int[] arrInt = new int[]{4,2,7,1,9,0,5,22,13,66,3};

        int sum = 0;
        int count = 0;
        int jnum = 0;
        int jsum = 0;
        for (int j = 0; j < arrInt.length; j++) {
            sum += j;
            if(arrInt[j]%2==0){
                System.out.println(arrInt[j]);
                if(j%2!=0){
                   jsum+=arrInt[j];
                   jnum++;
                }
            }else {
                count++;
            }
        }
        System.out.println(sum);
        System.out.println(count);
        System.out.println((jsum*1.0/jnum));

        new LearnArray().randomCall();

    }
    public void maxFun(){

        int[] arr = new int[]{3,8,2,5,1};
        int max=arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max=arr[i];
            }
            if(min > arr[i]){
                min = arr[i];
            }
        }

        System.out.println(max);
    }

    public void reverseFun(){
        int[] arr = new int[]{3,8,2,5,1};
        int temp = 0;
        int maxIndex = arr.length - 1;
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(minIndex>=maxIndex){
                break;
            }else {
                temp = arr[minIndex];
                arr[minIndex] = arr[maxIndex];
                arr[maxIndex] = temp;
                minIndex++;
                maxIndex--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void randomCall(){
        String[] str = new String[]{"a","b","c","d","e"};
        Random r = new Random();
        int a = r.nextInt(5);
        System.out.println(str[a]);
    }
}

