package com.doit.demoFunInterface;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @ClassName: Demo_Supplier
 * @Author: zll
 * @CreateTime: 2021/7/3 11:50
 * @Desc: java 程序
 * @Version: 1.0
 */

/* 函数式接口
注解 @FunctionalInterface
函数式接口在Java中是指：有且仅有一个抽象方法的接口。
函数式接口，即适用于函数式编程场景的接口。而Java中的函数式编程体现就是Lambda，
 所以函数式接口就是可以适用于Lambda使用的接口。
 只有确保接口中有且仅有一个抽象方法，Java中的Lambda才能顺利地进行推导。
 */

/*
Supplier 供给型函数式接口
抽象方法 : get
仅包含一个无参的方法：T get()。用来获取一个泛型参数指定类型的对象数据。
 */

public class Demo_Supplier {
    public static void main(String[] args) {
        int[] arr = {2,6,1,5,3};
        method(()->{
            Arrays.sort(arr);
            return arr[0];
        });

        Supplier<Integer> i = ()-> 3;
    }

    public static void method(Supplier<Integer> s){
        Integer min = s.get();
        System.out.println(min);
    }
}
