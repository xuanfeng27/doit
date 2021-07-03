package com.doit.demoStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName: DemoStreamTest
 * @Author: zll
 * @CreateTime: 2021/7/3 19:49
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
现在有两个ArrayList集合存储队伍当中的多个成员姓名，要求依次进行以下若干操作步骤：
第一个队伍只要名字为3个字的成员姓名；
第一个队伍筛选之后只要前3个人；
第二个队伍只要姓张的成员姓名；
第二个队伍筛选之后不要前2个人；
将两个队伍合并为一个队伍；
打印整个队伍的姓名信息。
 */
public class DemoStreamTest {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");

        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");

        Stream<String> stream1 = one.stream().filter(s -> s.length() == 3).limit(3);
        Stream<String> stream2 = two.stream().filter(s -> s.startsWith("张")).skip(2);
        Stream<String> concat = Stream.concat(stream1, stream2);
        concat.forEach(System.out::println);
        //one.addAll(two);
    }
}
