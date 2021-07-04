package com.doit.demo;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.*;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/7/3 21:15
 * @Desc: java 程序
 * @Version: 1.0
 */

//https://zhuanlan.zhihu.com/p/33313312
public class Test {
    public static void main(String[] args) {
        // method();
        // method1();
        //method3();

        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());    //7

    }

    public static void method(){
        //Collection.stream()创建一个顺序流，Collection.parallelStream()创建一个并行流
        List<String> list = Arrays.asList("args","a","b","c");
        Stream<String> stream = list.stream();
        Stream<String> stringStream = list.parallelStream();


        //如果流操作没有提供所需的功能,
        // 则可以使用BaseStream.iterator()和BaseStream.spliterator()操作来执行受控遍历
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        //终端操作
        Iterator<Integer> iterator = integerStream.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Spliterator<Integer> spliterator = integerStream.spliterator();
        spliterator.forEachRemaining(System.out::println);

        /*
        除了常规的对象Stream，Java 8有特殊类型的Stream，用于处理基本数据类型int,long和double。
        它是IntStream、LongStream和DoubleStream。
         */
        //IntStreams可以使用IntStream.range()来代替常规的for循环。
        IntStream.range(1, 4).forEach(System.out::println);

    }

    public static void method1(){
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));
     /*   执行这段代码片段会在控制台输出:

        filter:  d2
        forEach: d2
        filter:  a2
        forEach: a2
        filter:  b1
        forEach: b1
        filter:  b3
        forEach: b3
        filter:  c
        forEach: c*/
        /*
        结果的输出顺序可能令人惊讶。一种简单的方法是在Stream的所有元素上水平地执行操作。但此处相反，
        每个元素都沿着链垂直移动。第一个字符串“d2”先filter然后foreach，然后第二个字符串“a2”才被处理。
         */
        //这种方式可以减少在每个元素上执行的实际操作数，如下例所示:

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

// map:      d2
// anyMatch: D2
// map:      a2
// anyMatch: A2
// 当predicate应用于给定的输入元素时，anyMatch将立即返回true。这对于第二个被传递的“A2”来说是正确的。
// 由于stream链的垂直执行，在这种情况下，map只会执行两次。因此，map将尽可能少地被调用，而不是所有的元素映射到Stream中。

        //为什么顺序很重要

       // 下一个示例包括两个中间操作 map 和 filter 以及终端操作forEach。我们再一次查看这些操作是如何执行的:

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        // map:     d2
        // filter:  D2
        // map:     a2
        // filter:  A2
        // forEach: A2
        // map:     b1
        // filter:  B1
        // map:     b3
        // filter:  B3
        // map:     c
        // filter:  C
        //你可能已经猜到，底层集合中的每个字符串都被调用了5次map和filter，而forEach只调用一次。

       // 如果我们改变操作的顺序，将filter移到链的开头，我们可以大大减少实际执行次数:

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        // filter:  d2
        // filter:  a2
        // map:     a2
        // forEach: A2
        // filter:  b1
        // filter:  b3
        // filter:  c
        // 现在，map只被调用一次，因此操作管道在大量元素输入时执行得更快。在编写复杂的方法链时，请记住这一点。
    }

    //Stream复用
    //Java 8 Stream 无法复用。一旦你调用任何终端操作， Stream就会关闭:
    public static void method2(){
        //为了克服这个限制，必须为要执行的每一个终端操作创建一个新的Stream链，
        // 例如，我们可以创建一个Stream提供者来创建已构建所有中间操作的新Stream:

        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok
        //每次调用 get() 构造一个新Stream，我们在此调用终端操作。

    }

    public static void method3() {
        List<Person> persons = Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));
        //下一个例子将所有人按年龄分组:
        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));

        personsByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

        //Collectors 是多功能的。您还可以在Stream的元素上创建聚合，例如计算平均年龄:
        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(Person::getAge));

        System.out.println(averageAge);     // 19.0

        //为了将stream元素转换为map，我们必须指定键和值如何映射。请记住，映射的键必须是惟一的，
        // 否则会抛出IllegalStateException。你可以将合并函数作为额外参数传递，以绕过异常:
        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        Person::getAge,
                        Person::getName,
                        (name1, name2) -> name1 + ";" + name2));

        System.out.println(map);
        // {18=Max, 23=Peter;Pamela, 12=David}



        //现在我们知道了一些最强大的内置Collector，让我们尝试构建自专用的Collector。
        // 我们想要将Stream中所有person转换成一个由 | 管道字符分隔的大写字母组成的字符串。
        // 为了实现这一点，我们通过 Collector.of() 创建了一个新的Collector。
        // 我们必须传递Collector的四个要素:supplier、accumulator、 combiner和finisher。

        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, p) -> j.add(p.getName().toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher

        String names = persons.stream().collect(personNameCollector);

        System.out.println(names);  // MAX | PETER | PAMELA | DAVID
        //由于Java中的字符串是不可变的，
        // 所以我们需要一个类似StringJoiner的helper类来让collector构造我们的字符串。
        // supplier最初使用适当的分隔符构造了这样一个StringJoiner。
        // accumulator用于将每个人的大写名称添加到StringJoiner中。
        // combiner 知道如何将两个StringJoiners合并成一个。
        // 在最后一步中，finisher从StringJoiner中构造所需的字符串。
    }



}
