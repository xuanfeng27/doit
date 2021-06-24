package com.doit.DemoProperties;

/**
 * @ClassName: DemoVarArguments
 * @Author: zll
 * @CreateTime: 2021/6/24 15:59
 * @Desc: java 程序
 * @Version: 1.0
 */
//可变参数 a本质是数组 可以传数组
// 格式：参数类型...变量名
//注意事项：
//1.一个方法只能有一个可变参数；
//2. 若一个方法有多个参数，可变参数放最后
public class DemoVarArguments {
    public static void main(String[] args) {
        sum();
        sum(2);
        sum(1,2,3,4,5);

        int[] array = new int[6];
        sum(array);

        sum2("aaa",1,1,1,1,1,11,111,1,2);
    }

    public static int sum(int...a) {
        System.out.println(a);//[I@1b6d3586
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }

    public static int sum2(String b, int... a) {
        System.out.println(a);
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}
