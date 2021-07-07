package com.doit.demo;

import java.lang.reflect.Field;

/**
 * @ClassName: DemoReflection
 * @Author: zll
 * @CreateTime: 2021/7/7 10:40
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
Reflection（反射）是被视为动态语言的关键，反射机制允许程序在执行期借助于Reflection API取得任何类的内部信息，
并能直接操作任意对象的内部属性及方法。

加载完类之后，在堆内存的方法区中就产生了一个Class类型的对象（一个类只有一个Class对象），
这个对象就包含了完整的类的结构信息。我们可以通过这个对象看到类的结构。
这个对象就像一面镜子，透过这个镜子看到类的结构，所以，我们形象的称之为：反射。

 */
public class DemoReflection {
    public static void main(String[] args) throws Exception {
        //反射获取成员变量
        Class<?> c = Class.forName("com.doit.bean.Person");
        System.out.println(c.getPackage());//package com.doit.bean
        Object o = c.newInstance();
        Field name = c.getDeclaredField("name");//获取所有属性含私有
        name.setAccessible(true);//暴力反射
        name.set(o,"zll");
        Object o1 = name.get(o);
        System.out.println(o1);

        Class<String> stringClass = String.class;
        String a = "hello";
        Class<? extends String> cl = a.getClass();
        System.out.println(cl == stringClass);
    }
}
/*
类的加载过程：
加载：将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时
数据结构，然后生成一个代表这个类的java.lang.Class对象，作为方法区中类数据的访问
入口（即引用地址）。所有需要访问和使用类数据只能通过这个Class对象。这个加载的
过程需要类加载器参与。

链接：将Java类的二进制代码合并到JVM的运行状态之中的过程。
验证：确保加载的类信息符合JVM规范，例如：以cafe开头，没有安全方面的问题
准备：正式为类变量（static）分配内存并设置类变量默认初始值的阶段，这些内存
都将在方法区中进行分配。
解析：虚拟机常量池内的符号引用（常量名）替换为直接引用（地址）的过程。

初始化：
执行类构造器<clinit>()方法的过程。类构造器<clinit>()方法是由编译期自动收集类中
所有类变量的赋值动作和静态代码块中的语句合并产生的。（类构造器是构造类信
息的，不是构造该类对象的构造器）。
当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先触发其父类
的初始化。
虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确加锁和同步。

 */
class ClassLoadingTest {
    public static void main(String[] args) {
        System.out.println(C.m);
    }
}
class C {
    static {
        m = 300;
    }
    static int m = 100;
}
/*
    第二步：链接 结束后 m=0
    第三步：初始化 后，m的值由<clinit>()方法执行决定
    这个C的类构造器<clinit>()方法由类变量的赋值和静态代码块中的语句按照顺序合并产生，类似于
    <clinit>(){
        m = 300;
        m = 100;
    }
*/