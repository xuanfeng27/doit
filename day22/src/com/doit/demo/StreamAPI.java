package com.doit.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName: StreamAPI
 * @Author: zll
 * @CreateTime: 2021/7/4 15:30
 * @Desc: java 程序
 * @Version: 1.0
 */
public class StreamAPI {
    public static void main(String[] args) {
        //创建 Stream方式一：通过集合
        List<Person> list = new ArrayList<>();
        list.add(new Person("dalang",33));
        list.add(new Person("jinlian",19));
        Stream<Person> stream1 = list.stream();
        Optional<Integer> reduce = stream1.map(s -> 1).reduce(Integer::sum);
        System.out.println(reduce.get());


        //创建 Stream方式二：通过数组
        int[] arr = {1,2,3,4,5};
        IntStream stream2 = Arrays.stream(arr);

        //创建 Stream方式三：通过Stream的of()
        Stream<int[]> stream3 = Stream.of(arr);
        //创建 Stream方式四：创建无限流
            //  迭代
        Stream<Integer> stream = Stream.iterate(0, s -> s + 2);
        stream.limit(5).forEach(System.out::println);
            // 生成
        Stream<Double> stream4 = Stream.generate(Math::random);
        stream4.limit(5).forEach(System.out::println);

        Optional<Object> optional = Optional.empty();
        Optional<Integer> integerOptional = Optional.of(3);
        integerOptional.ifPresent(System.out::println);


        Optional<Person> opt = Optional.of(new Person("张三", 8888));
        Optional<Person> p = opt.filter(e -> e.getAge() > 9000);
        System.out.println(p);

    }
}
/*
创建 Stream方式一：通过集合
Java8 中的 Collection 接口被扩展，提供了两个获取流的方法：
 default Stream<E> stream() : 返回一个顺序流
 default Stream<E> parallelStream() : 返回一个并行流

创建 Stream方式二：通过数组
Java8 中的 Arrays 的静态方法 stream() 可以获取数组流：
 static <T> Stream<T> stream(T[] array): 返回一个流
重载形式，能够处理对应基本类型的数组：
 public static IntStream stream(int[] array)
 public static LongStream stream(long[] array)
 public static DoubleStream stream(double[] array)

创建 Stream方式三：通过Stream的of()
可以调用Stream类静态方法 of(), 通过显示值创建一个流。它可以接收任意数量的参数。
 public static<T> Stream<T> of(T... values) : 返回一个流

创建 Stream方式四：创建无限流
可以使用静态方法 Stream.iterate() 和 Stream.generate(), 创建无限流。
 迭代
public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
 生成
public static<T> Stream<T> generate(Supplier<T> s)
 */
/*
Optional类：
 到目前为止，臭名昭著的空指针异常是导致Java应用程序失败的最常见原因。
 Optional<T> 类(java.util.Optional) 是一个容器类，它可以保存类型T的值，代表
这个值存在。或者仅仅保存null，表示这个值不存在。原来用 null 表示一个值不
存在，现在 Optional 可以更好的表达这个概念。并且可以避免空指针异常。

 Optional类的Javadoc描述如下：这是一个可以为null的容器对象。
如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。

 Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 创建Optional类对象的方法：
 Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
 Optional.empty() : 创建一个空的 Optional 实例
 Optional.ofNullable(T t)：t可以为null

 判断Optional容器中是否包含对象：
 boolean isPresent() : 判断是否包含对象
 void ifPresent(Consumer<? super T> consumer) ：如果有值，就执行Consumer
接口的实现代码，并且该值会作为参数传给它。

 获取Optional容器的对象：
 T get(): 如果调用对象包含值，返回该值，否则抛异常
 T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象。
 T orElseGet(Supplier<? extends T> other) ：如果有值则将其返回，否则返回由
Supplier接口实现提供的对象。
 T orElseThrow(Supplier<? extends X> exceptionSupplier) ：如果有值则将其返
回，否则抛出由Supplier接口实现提供的异常。
 */