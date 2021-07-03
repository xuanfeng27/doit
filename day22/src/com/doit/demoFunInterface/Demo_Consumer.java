package com.doit.demoFunInterface;

import java.util.function.Consumer;

/**
 * @ClassName: Demo_Consumer
 * @Author: zll
 * @CreateTime: 2021/7/3 14:36
 * @Desc: java 程序
 * @Version: 1.0
 */
//函数式接口在Java中是指：有且仅有一个抽象方法的接口。
//消费型函数式接口 Consumer<T>
//Consumer接口中包含抽象方法void accept(T t)，意为消费一个指定泛型的数据。
//  默认方法：andThen
public class Demo_Consumer {
    public static void main(String[] args) {
        //标准写法
        method("123",(String str)->{
            System.out.println(Integer.parseInt(str));
        });
        //简化写法
        method("abc",str-> System.out.println(str.toUpperCase()));

        method("123",i-> System.out.println(Integer.parseInt(i)*100));

        methodAndThen("abCd",s -> System.out.println(s.toUpperCase()),s -> System.out.println(s.toLowerCase()));

    }

    public static<T> void method(T s, Consumer<T> c) {
        c.accept(s);
    }

    public static void methodAndThen(String s, Consumer<String> c1,Consumer<String> c2){
        c1.andThen(c2).accept(s);
    }
}
/*源码：
 default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
 */
