package com.doit.demo3;

/**
 * @ClassName: StringBuilderTest
 * @Author: zll
 * @CreateTime: 2021/6/18 9:16
 * @Desc: java 程序
 * @Version: 1.0
 */
//StringBuilder 字符串缓冲区 线程不安全 效率高
//构造方法：
// public StringBuilder()默认容量16
// public StringBuilder(String str)
//方法:reverse()反转字符串 new StringBuilder(str).reverse().toString();
// append(Object obj)添加任意元素，基本类型变为String,引用类型默认调用toString().返回当前的缓冲区对象，可链式调用
//StringBuffer 字符串缓冲区  线程安全

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("acd");
        StringBuilder sb = new StringBuilder();
        String s = sb.append("abcde").reverse().toString();
        System.out.println(s);

        int[] arr = new int[]{3,8,2,5,0};
        System.out.println(reverseArr(arr));
    }

    public static String reverseArr(int[] arr){
       StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
