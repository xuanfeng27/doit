package com.doit.Cloneable;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/24 20:23
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneableDemo c = new CloneableDemo(11,"aaa",new Student("北京"));
        CloneableDemo c2 = c.clone();
        System.out.println(c);
        System.out.println(c2);
        c2.setAge(22);
        c2.setName("bbb");

        c2.getStudent().setAddress("SHANGHAI");
        System.out.println(c);
        System.out.println(c2);



    }
}
