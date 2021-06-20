package com.doit.demoTryCatch;
//编译异常必须处理，运行异常去改代码
/**
 * @ClassName: TryCatchDemo
 * @Author: zll
 * @CreateTime: 2021/6/20 15:01
 * @Desc: java 程序
 * @Version: 1.0
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        try {
            int b = 3/0;
            int[] arr = {};
            int a = method(arr);
            System.out.println(a);
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }catch (ArithmeticException e){
            System.out.println(e);
        }finally {
            System.out.println("老子NB");//告知操作系统释放文件资源
        }
        System.out.println("game over");
    }

    public static int method(int[] arr){
        String s = "hello";
        int a = arr[arr.length - 1];
        return a;
    }
}
