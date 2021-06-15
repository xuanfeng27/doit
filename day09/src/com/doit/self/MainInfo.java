package com.doit.self;

/**
 * @ClassName: MainInfo
 * @Author: zll
 * @CreateTime: 2021/6/14 19:50
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
理解main方法的语法
由于Java虚拟机需要调用类的main()方法，所以该方法的访问权限必须是public，
又因为Java虚拟机在执行main()方法时不必创建对象，所以该方法必须是static的，
该方法接收一个String类型的数组参数，该数组中保存执行Java命令时传递给所运行的类的参数。
 */
//运行程序MainInfo.java
//命令行 java MainInfo  “args1" “args2" “args3"
public class MainInfo {
    public static void main(String[] args) {
        System.out.println();
    }
}

/*
 静态代码块：用static 修饰的代码块
1. 可以有输出语句。
2. 可以对类的属性、类的声明进行初始化操作。
3. 不可以对非静态的属性初始化。即：不可以调用非静态的属性和方法。
4. 若有多个静态的代码块，那么按照从上到下的顺序依次执行。
5. 静态代码块的执行要先于非静态代码块。
6. 静态代码块随着类的加载而加载，且只执行一次。
 */
/*
 非静态代码块：没有static修饰的代码块
1. 可以有输出语句。
2. 可以对类的属性、类的声明进行初始化操作。
3. 除了调用非静态的结构外，还可以调用静态的变量或方法。
4. 若有多个非静态的代码块，那么按照从上到下的顺序依次执行。
5. 每次创建对象的时候，都会执行一次。且先于构造器执行。
 */