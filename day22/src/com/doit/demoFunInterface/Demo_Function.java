package com.doit.demoFunInterface;

import java.util.function.Function;

/**
 * @ClassName: Demo_Function
 * @Author: zll
 * @CreateTime: 2021/7/3 15:20
 * @Desc: java 程序
 * @Version: 1.0
 */
//抽象方法：apply
//Function接口中最主要的抽象方法为：R apply(T t)，根据类型T的参数获取类型R的结果。
public class Demo_Function {
    public static void main(String[] args) {
        method("123",(String s)->{
            return Integer.parseInt(s);
        },(Integer num)->{
            return 100*num;
        });
        method("123", Integer::parseInt, s->s*100);

        //将一个字符串转换成person对象
        method2("liuyan",s->new Person(s));
        method2("liuyan", Person::new);
    }

    public static void method(String s, Function<String, Integer> fun,Function<Integer, Integer> fun2){
        Integer rlt = fun.andThen(fun2).apply(s);
        System.out.println(rlt);
    }

    public static void method2(String str,Function<String, Person> fun){
        Person p = fun.apply(str);
        System.out.println(p);

    }
}
/*
默认方法：andThen
Function接口中有一个默认的andThen方法，用来进行组合操作。JDK源代码如：

default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
    Objects.requireNonNull(after);
    return (T t) -> after.apply(apply(t));
}
 */