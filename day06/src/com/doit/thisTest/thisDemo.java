package com.doit.thisTest;

/**
 * @ClassName: thisDemo
 * @Author: zll
 * @CreateTime: 2021/6/10 11:37
 * @Desc: java 程序
 * @Version: 1.0
 */
public class thisDemo {
    public static void main(String[] args) {
        System.out.println(new Person("aa").getInfo());
    }
}

class Person{ // 定义Person类
    private String name ;
    private int age ;
    public Person(){ // 无参构造器
        System.out.println("新对象实例化") ;
    }
    public Person(String name){
        this(); // 调用本类中的无参构造器
        this.name = name ;
    }
    public Person(String name,int age){
        this(name) ; // 调用有一个参数的构造器
        this.age = age;
    }
    public String getInfo(){
        return "姓名：" + name + "，年龄：" + age ;
    }
}
/*注意：
 可以在类的构造器中使用"this(形参列表)"的方式，调用本类中重载的其他的构造器！
 明确：构造器中不能通过"this(形参列表)"的方式调用自身构造器
 如果一个类中声明了n个构造器，则最多有 n - 1个构造器中使用了"this(形参列表)"
 "this(形参列表)"必须声明在类的构造器的首行！
 在类的一个构造器中，最多只能声明一个"this(形参列表)"*/