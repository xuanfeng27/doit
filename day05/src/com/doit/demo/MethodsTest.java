package com.doit.demo;
import jdk.internal.instrumentation.*;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName: MethodsTest
 * @Author: zll
 * @CreateTime: 2021/6/8 9:14
 * @Desc: java 程序
 * @Version: 1.0
 */
public class MethodsTest {
    public static void main(String[] args) {

       /* System.out.println(test(3,4));
        System.out.println(randm());
        System.out.println(intNum());
        System.out.println(isEvenNumber(9));
        System.out.println(Arrays.toString(arrayInt(8)));
        System.out.println(Arrays.toString(doubleList(4)));*/

       // arrI(new int[]{3,6,22,1,8,72,9});
        //System.out.println(Arrays.toString(arrSc(new int[5])));
        //System.out.println(  arrStr(new String[5]));

    }

    public static String test(int m,int n){
        String s ="";
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                s += "* ";
            }
            s += "\n";
        }
        return s;
    }

    public static double randm() {
        Random r = new Random();
        return r.nextDouble();
    }

    public static int intNum(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        return sc.nextInt();
    }

    public static boolean isEvenNumber(int a) {
        if(a%2==0){
            return true;
        }else {
            return false;
        }
    }

    public static int[] arrayInt(int i){
        return new int[i];
    }

    public static double[] doubleList(int n){
        double[] d = new double[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            d[i] = r.nextDouble();
        }
       return d;
    }

    public static void arrI(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] arrSc(int[] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入：");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static String arrStr(String[] str){
        Random r = new Random();
       int a= r.nextInt(str.length);
       if(str.length == 0){
           return "";
       }
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < str.length; i++) {
            System.out.println("请输入姓名：");
            str[i] = sc.next();
        }
        return str[a];
    }
}

