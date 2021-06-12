package com.doit.constructor;
//在子类的每个构造方法的 第一行 都默认有一个父类的无参构造super（），不写也有，写了就Java不提供

public class Test {
    public static void main(String[] args) {
        Student st1 = new Student();
        //Person 空参构造
       // student 空参构造

        Student st2 = new Student(001d);
        //Person 空参构造
        //student 带参构造

        Student st3 = new Student(002d,"aaa",11);
        //Person 满参构造
        //student 满参构造

        Student st4 = new Student(001d,3);
        //Person 空参构造
        //student 带参构造
        //n
        //n
        //n

        new Student().thisAndSuper();//变量就近访问原则 super（）非私有父类变量
    }
}


/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/12 11:50
 * @Desc: java 程序
 * @Version: 1.0
 */