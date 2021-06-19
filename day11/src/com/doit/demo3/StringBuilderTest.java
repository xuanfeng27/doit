package com.doit.demo3;

/**
 * @ClassName: StringBuilderTest
 * @Author: zll
 * @CreateTime: 2021/6/18 9:16
 * @Desc: java 程序
 * @Version: 1.0
 */
//构造方法：
// public StringBuilder()默认容量16
// public StringBuilder(String str)
//方法:reverse()反转字符串 new StringBuilder(str).reverse().toString();
// append(Object obj)添加任意元素，基本类型变为String,引用类型默认调用toString().返回当前的缓冲区对象，可链式调用
//StringBuffer 字符串缓冲区  线程安全 效率低
//StringBuilder 字符串缓冲区 线程不安全 效率高

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("acd");
        StringBuilder sb = new StringBuilder();
        String s = sb.append("abcde").reverse().toString();
        System.out.println(s);

        int[] arr = new int[]{3,8,2,5,0};
        System.out.println(reverseArr(arr));

        testStr();
    }

    public static String reverseArr(int[] arr){
       StringBuilder sb = new StringBuilder();
        for (int i =  arr.length-1; i >=0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void testStr(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//4
        System.out.println(sb);//null
        StringBuffer sb1 = new StringBuffer(str);//NullPointerException
        System.out.println(sb1);//
    }
}
/*
StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
StringBuffer delete(int start,int end)：删除指定位置的内容
StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
StringBuffer insert(int offset, xxx)：在指定位置插入xxx
StringBuffer reverse() ：把当前字符序列逆转
 */

