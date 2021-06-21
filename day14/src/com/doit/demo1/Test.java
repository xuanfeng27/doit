package com.doit.demo1;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/21 15:19
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        MyClass<String> mc = new MyClass<String>();
        mc.setName("zll");
        MyClass<Integer> mc2 = new MyClass<Integer>();
        mc2.setName(22);

        mc.method(10);
        mc.method("aaaa");

        mc2.method2("111",11);
        mc2.method2(222,2);

        //
        FanClass<String,Integer> f = new FanClass<String, Integer>();
        f.method("AAA",11);

        FanClass2 f2 = new FanClass2();
        f2.method("aaa",22);
    }
}
