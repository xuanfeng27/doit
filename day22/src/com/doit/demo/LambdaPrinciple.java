package com.doit.demo;

/**
 * @ClassName: LambdaPrinciple
 * @Author: zll
 * @CreateTime: 2021/7/3 20:14
 * @Desc: java 程序
 * @Version: 1.0
 */

public class LambdaPrinciple {
    public static void main(String[] args) {
        //使用Lambda表达式
        method(()->{
            System.out.println("运行程序，控制台可以得到预期的结果，但是并没有出现一个新的类class文件，" +
                    "也就是说Lambda并没有在编译的时候产生一个新的类。");
        });
    }

    public static void method(Fly f){
        f.fly();
    }
}
//格式 (DOS命令行)
//javap -c -p 类名    //注意需要在class文件所在的目录中执行
/*
public class com.doit.demo.LambdaPrinciple {
  public com.doit.demo.LambdaPrinciple();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: invokedynamic #2,  0              // InvokeDynamic #0:fly:()Lcom/doit/demo/Fly;
       5: invokestatic  #3                  // Method method:(Lcom/doit/demo/Fly;)V
       8: return

  public static void method(com.doit.demo.Fly);
    Code:
       0: aload_0
       1: invokeinterface #4,  1            // InterfaceMethod com/doit/demo/Fly.fly:()V
       6: return

  private static void lambda$main$0();
    Code:
       0: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #6                  // String 运行程序，控制台可以得到预期的结果，但是并没有出现一个新的类class文件，也就是说Lambda并没有在编译的时候产生一个新的类。
       5: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
 */

/*
其实Lambda在运行的时候会生成一个内部类，为了验证是否生成内部类，可以在运行时加 上
-Djdk.internal.lambda.dumpProxyClasses ，加上这个参数后，运行时会将生成的内部类class码输出到一个文件中。
使用java命令如下：
cd..到day22目录下
java -Djdk.internal.lambda.dumpProxyClasses com.doit.demo.LambdaPrinciple

得到文件 LambdaPrinciple$$Lambda$1.class
如下：

final class LambdaPrinciple$$Lambda$1 implements Fly {
    private LambdaPrinciple$$Lambda$1() {
    }

    @Hidden
    public void fly() {
        LambdaPrinciple.lambda$main$0();
    }
}

结论:

匿名内部类在编译的时候会一个class文件 Lambda在程序运行的时候形成一个类

在类中新增一个方法,这个方法的方法体就是Lambda表达式中的代码
还会形成一个匿名内部类,实现接口,重写抽象方法
在接口的重写方法中会调用新生成的方法.
*/