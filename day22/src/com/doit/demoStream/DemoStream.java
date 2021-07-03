package com.doit.demoStream;

import com.doit.demoFunInterface.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: DemoStream
 * @Author: zll
 * @CreateTime: 2021/7/3 17:03
 * @Desc: java 程序
 * @Version: 1.0
 */
//在Java 8中，得益于Lambda所带来的函数式编程，引入了一个全新的Stream概念，用于解决已有集合类库既有的弊端。
//获取一个流非常简单，有以下几种常用的方式：
    //所有的Collection集合都可以通过stream默认方法获取流；
    //Stream接口的静态方法of可以获取数组对应的流。备注：of方法的参数其实是一个可变参数，所以支持数组
public class DemoStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Stream<String> listStream = list.stream();

        Set<String> set = new HashSet<String>();
        Stream<String> setStream = set.stream();

        Map<String, String> map = new HashMap<String, String>();
        Stream<String> stream = map.keySet().stream();
        Stream<String> stream1 = map.values().stream();
        Stream<Map.Entry<String, String>> stream2 = map.entrySet().stream();

        //数组转换stream流
        String[] arrStr = {"a","b"};
        Stream<String> arrStr1 = Stream.of(arrStr);

        int[] arr = {3,8,2,5,0};
        Stream<int[]> arr1 = Stream.of(arr);

        Integer[] arr2 = {3,5,7,8,2,0};
        Stream<Integer> arr3 = Stream.of(arr2);

        Stream<Integer> arrStream = Stream.of(3, 7, 8, 4, 0);

        /*
        终结方法：返回值类型不再是Stream接口自身类型的方法，因此不再支持类似StringBuilder那样的链式调用。
        本小节中，终结方法包括count和forEach方法。
        非终结方法：返回值类型仍然是Stream接口自身类型的方法，因此支持链式调用。
         */
        //Stream流终结方法 :返回值类型不是流类型，只能调用一次
            //1.  void forEach(Consumer<T> c)
            //2.  long count()
        Stream<String> stringStream = Stream.of("2", "5", "8", "0");
        //stringStream.forEach(System.out::println);
        long count = stringStream.count();
        System.out.println(count);

        //Stream<T> limit(long maxSize):获取Stream流对象中的前n个元素,返回一个新的Stream流对象
        //Stream<T> skip(long n): 跳过Stream流对象中的前n个元素,返回一个新的Stream流对象
        Stream<String> streams = Stream.of("dalang", "jinlian", "tangyan", "ximen");
        streams.skip(2).limit(1).forEach(System.out::println);//"tangyan"

        //过滤 Stream<T> filter(Predicate<? super T> predicate);
        //去除重复数据，使用 distinct方法。方法签名：Stream<T> distinct()
        Stream<String> streamf = Stream.of("大娃","大娃", "二娃", "狐狸精", "妖怪");
        streamf.filter(s->s.contains("娃")).distinct().forEach(System.out::println);

        //map:映射
        //如果需要将流中的元素映射到另一个流中，可以使用 map方法。方法签名：
        //<R> Stream<R> map(Function<? super T, ? extends R> mapper);
        //该接口需要一个 Function函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流

        Stream<String> streamSt = Stream.of("大娃","大娃", "二娃", "狐狸精", "妖怪");
        Stream<Person> personStream = streamSt.map(Person::new);
        personStream.forEach(System.out::println);

        // Stream流中的结果到集合中
        //Stream流提供 collect方法，其参数需要一个 java.util.stream.Collector<T,A, R>接口对象来指定收集到哪种集合中。
        // java.util.stream.Collectors 类提供一些方法，可以作为 Collector`接口的实例：
            //public static Collector<T, ?, List> toList()：转换为 List集合。
            //public static Collector<T, ?, Set> toSet()：转换为 Set集合。
        Stream<String> streamTrans = Stream.of("大娃","大娃", "二娃", "狐狸精", "妖怪");
        //转换为list集合
        List<String> list1 = streamTrans.collect(Collectors.toList());
        //转换为set集合
        Set<String> set1 = streamTrans.collect(Collectors.toSet());
        //转换为ArrayList集合
        ArrayList<String> arrayList = streamTrans.collect(Collectors.toCollection(ArrayList::new));
        //转换为HashSet集合
        HashSet<String> hashSet = streamTrans.collect(Collectors.toCollection(HashSet::new));

        /*
        Stream流中的结果到数组中
        Stream提供 toArray方法来将结果放到一个数组中，返回值类型是Object[]的：
        Object[] toArray();
        */
        Object[] objArr = streamTrans.toArray();
        String[] strArr = streamTrans.toArray(String[]::new);
    }
}
