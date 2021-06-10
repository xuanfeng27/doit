package com.doit.demo;


/*
Java：String、StringBuffer 和 StringBuilder 的区别:

String：字符串常量，字符串长度不可变。Java中String 是immutable（不可变）的。用于存放字符的数组被声明为final的，
因此只能赋值一次，不可再更改。

StringBuffer：字符串变量（Synchronized，即线程安全）。如果要频繁对字符串内容进行修改，出于效率考虑最好使用 StringBuffer，
如果想转成 String 类型，可以调用 StringBuffer 的 toString() 方法。Java.lang.StringBuffer 线程安全的可变字符序列。
在任意时间点上它都包含某种特定的字符序列，但通过某些方法调用可以改变该序列的长度和内容。可将字符串缓冲区安全地用于多个线程。

StringBuilder：字符串变量（非线程安全）。在内部 StringBuilder 对象被当作是一个包含字符序列的变长数组。

基本原则：
如果要操作少量的数据用 String ；
单线程操作大量数据用StringBuilder ；
多线程操作大量数据，用StringBuffer。
*/
/*
String 类中 concat() 方法和 + 号的区别:
首先关于 new 出来的对象和 String s = "字符串" 的 == 执行结果为 false 就不多赘述了，因为 == 比较的是两个对象的地址值，
equals() 比较的是字面值。那么 concat 方法和 + 号的区别在这里有体现了，我们查看concat方法的源码可以看到，
它是通过复制数组在通过 char 数组进行拼接生成一个新的对象，所以地址值会有变动
*/


import java.util.Objects;

public class TestStr{
	public static void main(String[] args){
		String a = "saff";
		String b = "saff";
		String c = new String("saff");
		System.out.println(a.equals(b));  // true
		System.out.println(a.equals(c));  // true
		System.out.println(a ==b);  //true
		System.out.println(a ==c);  //false
		
		String s1="a"+"b"+"c";
		String s2="abc";
		System.out.println(s1==s2);//true
		System.out.println(s1.equals(s2));//true
		
		String st1="ab";
		String st2="abc";
		String st3=st1+"c";
		System.out.println(st3==st2);         // false
		System.out.println(st3.equals(st2));  // true
		
		String str1 = "a".concat("b").concat("c");
        String str2 = "a"+"b"+"c";
        String str3 = "abc";
        String str4 = new String("abc");
        System.out.println(str1 == str2); //运行结果为false
		System.out.println(str1 == str3); //运行结果为false
        System.out.println(str2 == str3); //运行结果为ture
        System.out.println(str2 == str4); //运行结果为false
        System.out.println(str1.equals(str4)); //运行结果为true
		
	}
}

/*
 注意 == 与 equals的区别
== 它比较的是对象的地址
equals 比较的是对象的内容

Java 会对 -128 ~ 127 的整数进行缓存，所以当定义两个变量初始化值位于 -128 ~ 127 之间时，两个变量使用了同一地址：

Integer a=123;
Integer b=123;
System.out.println(a==b);        // 输出 true
System.out.println(a.equals(b));  // 输出 true

当两个 Integer 变量的数值超出 -128 ~ 127 范围时, 变量使用了不同地址：

a=1230;
b=1230;
System.out.println(a==b);        // 输出 false
System.out.println(a.equals(b));  // 输出 true

*/

//Integer 变量(无论是否是 new 生成的)与 int 变量比较，只要两个变量的值是相等的，结果都为 true。

/**
 * 比较Integer变量与int变量
 */
class TestInt {
    public static void main(String[] args) {
        Integer i1 = 200;
        Integer i2 = new Integer(200);
        int j = 200;
        System.out.println(i1 == j);//输出：true
        System.out.println(i2 == j);//输出：true
    }
}
//包装类 Integer 变量在与基本数据类型 int 变量比较时，Integer 会自动拆包装为 int，然后进行比较，
//实际上就是两个 int 变量进行比较，值相等，所以为 true。

class TestString {
    public static void main(String[] args) {
        // 由字面值创建字符串
        String s1 = "hello,world!";
        String s2 = "hello,world!";
        System.out.println(s1 == s2);
        System.out.println(Objects.equals(s1, s2));
        // 由 new 关键字创建字符串
        String s3 = new String("hello,world!");
        String s4 = new String("hello,world!");
        System.out.println(s3 == s4);
        System.out.println(Objects.equals(s3, s4));

        System.out.println(s1 == s3);
        System.out.println(s1 == s3.intern());

        String s5 = "hello,";
        String s6 = "world!";
        System.out.println(s1 == s5 + s6);
        System.out.println(s1 == "hello," + "world!");
        System.out.println(s3 == s5 + s6);
        System.out.println(s1 == (s5 + s6).intern());
    }
}

// output: true true false true false true false true false true