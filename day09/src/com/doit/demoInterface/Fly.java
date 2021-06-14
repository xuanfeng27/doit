package com.doit.demoInterface;

/**
 * @ClassName: Fly
 * @Author: zll
 * @CreateTime: 2021/6/14 10:39
 * @Desc: java 程序
 * @Version: 1.0
 */
//接口的内部主要就是封装了方法，接口中所有方法都是抽象方法（JDK 7及以前)(在JDK8中新出了默认方法和静态方法)
//在具体实现类中重写方法，实现功能,这样将功能的定义与实现分离，优化了程序设计。 解耦
/*
接口中成员的特点:
1.接口中，无法定义成员变量，但是可以定义常量，其值不可以改变，默认使用public static final修饰。
2.接口中可以定义方法，方法也有固定的修饰符，public abstract
3.接口没有构造方法,不能直接创建对象
 */
public interface Fly {

    //int num ; // 错误,必须赋值
    int num =10; // 正确 , 省去了默认修饰符 public static final
    public static final int num1= 100; // 正确 , 完整写法

    //public Fly(){}; 错误，没有构造方法

    void method(); //正确 没写public abstract java自动补齐

    public abstract void open();

    public abstract void fly();

    public abstract void close();
}

interface A{
    public abstract void show();
    public abstract void show1();
}

interface B{
   public abstract void show1();
   public abstract void show2();
}
/*
接口的特点(注意事项)
1.类与类是继承关系,类与接口是实现关系,一个类可以在继承一个类的同时实现多个接口
2.接口与接口的关系继承关系,可以单继承,也可以多继承
**接口的出现降低了耦合性，即设备与设备之间实现了解耦。**
 */
interface C extends A,B{
   public abstract void show3();
}

class D {
    public void show(){
       System.out.println("show");
    }
}

class E extends D implements C{ //show()方法可以不用重写，class D 有了

      @Override
      public void show1() {

      }

      @Override
      public void show2() {

      }

      @Override
      public void show3() {

      }
}