package com.doit.demo;
//import static com.doit.demo.StaticTest.method;
/**
 * @ClassName: CodeBlock
 * @Author: zll
 * @CreateTime: 2021/6/15 10:27
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
*静态代码块**：定义在成员位置，使用static修饰的代码块{ }。
- 位置：类中方法外。
- 执行：随着类的加载而执行且执行一次，优先构造方法的执行
 */
class Person{
    static final int b = 2;
    static int a =1;

    //成员代码块
    {
        System.out.println("成员代码块执行了");
    }

    //静态代码块
    static {
        System.out.println("静态代码块执行了");
    }

    public Person(){
        System.out.println("空参构造");
    }

    public Person(int n){
        System.out.println(n);
    }

    public static void method(){
        //局部代码块
        {
            System.out.println("局部代码块执行了");
        }
    }
}

class Student extends Person{
    static int a = 2;
}

public class CodeBlock {
    //静态代码块执行 >成员代码块执行>构造函数
    public static void main(String[] args) {
       // Person p = new Person();//成员代码块 每次创建对象都执行一次
       // Person p2 =new Person();
        Person p3 = new Person(3);
        //Student s = new Student();
        //Person.method();
        //System.out.println(Person.a);//变量可以
       // System.out.println(Person.b);//final 常量 静态代码块不初始化

    }
}
