package com.doit.demoFunInterface;

import java.util.function.Predicate;

/**
 * @ClassName: Demo_Predictate
 * @Author: zll
 * @CreateTime: 2021/7/3 16:03
 * @Desc: java 程序
 * @Version: 1.0
 */

//Predicate接口中包含一个抽象方法：
// boolean test(T t)。用于条件判断的场景：
public class Demo_Predictate {
    public static void main(String[] args) {
        method("abcdHWss",s -> s.contains("H"),s->s.contains("W"));
    }

    public static void method(String str, Predicate<String> pre,Predicate<String> pre2){
        boolean b = pre.test(str);
        boolean b2 = pre2.test(str);
        if (b&&b2) {
            System.out.println("这个字符串，既包含H，又包含W");
        }

        boolean test = pre.and(pre2).test(str);
        if (test) {
            System.out.println("字符串，既包含H，又包含W");
        }

        boolean test1 = pre.or(pre2).test(str);
        if(test1){
            System.out.println("字符串，H,W二者包含其一");
        }

        boolean test2 = pre.negate().test(str);

    }
}
/*
默认方法：and
既然是条件判断，就会存在与、或、非三种常见的逻辑关系。
其中将两个Predicate条件使用“与”逻辑连接起来实现“并且”的效果时，可以使用default方法and。其JDK源码为：
default Predicate<T> and(Predicate<? super T> other) {
    Objects.requireNonNull(other);
    return (t) -> test(t) && other.test(t);
}

默认方法：or
与and的“与”类似，默认方法or实现逻辑关系中的“或”。JDK源码为：

default Predicate<T> or(Predicate<? super T> other) {
    Objects.requireNonNull(other);
    return (t) -> test(t) || other.test(t);
}

默认方法：negate
“与”、“或”已经了解了，剩下的“非”（取反）也会简单。默认方法negate的JDK源代码为：

default Predicate<T> negate() {
    return (t) -> !test(t);
}
 */