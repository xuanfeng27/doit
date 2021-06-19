package com.doit.demo1;

/**
 * @ClassName: Test3
 * @Author: zll
 * @CreateTime: 2021/6/19 10:07
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
结论：
 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
 只要其中有一个是变量，结果就在堆中
 如果拼接的结果调用intern()方法，返回值就在常量池中
 */
//字符串对象
public class Test3 {
    public static void main(String[] args) {
        Person p1 = new Person(11,"aaa");//0x2222
        Person p2 = new Person(11,"aaa");//0x3333
        System.out.println(p1==p2);//false
        System.out.println(p1.age == p2.age);//true
        System.out.println(p1.name == p2.name);//true
        // 0x2222---->常量池0x1111   0x3333---->常量池0x1111 "aaa"
    }
}

class StringTest {
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };
    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + " and ");//good and
        System.out.println(ex.ch);//'b', 'e', 's', 't'
    }
}
/*
字符串  基本数据类型、包装类
Integer包装类的public static int parseInt(String s)：可以将由“数字”字符组成的字符串转换为整型。
类似地,使用java.lang包中的Byte、Short、Long、Float、Double类调相应的类方法可以将由“数字”字符组成的字符串，转化为相应的基本数据类型。
基本数据类型、包装类  字符串
调用String类的public String valueOf(int n)可将int型转换为字符串
相应的valueOf(byte b)、valueOf(long l)、valueOf(float f)、valueOf(double d)、valueOf(boolean b)可由参数的相应类型到字符串的转换

 */