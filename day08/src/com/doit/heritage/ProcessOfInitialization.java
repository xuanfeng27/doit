package com.doit.heritage;

/**
 * @ClassName: ProcessOfInitialization
 * @Author: zll
 * @CreateTime: 2021/6/13 13:49
 * @Desc: java 程序
 * @Version: 1.0
 */
public class ProcessOfInitialization {

}

// The full process of initialization
class Insect {
    private int i = 9;
    protected int j;

    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

class Beetle extends Insect {
    private int k = printInit("Beetle.k.initialized");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
        System.out.println("be = " + be);
    }
    private int be = printInit("Beetle.be.initialized");

    private static int x2 = printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
    }
}
/*output
static Insect.x1 initialized
static Beetle.x2 initialized
Beetle constructor
i = 9, j = 0
Beetle.k.initialized
Beetle.be.initialized
k = 47
j = 39
be = 47
当执行 java Beetle，首先会试图访问 Beetle 类的 main() 方法（一个静态方法），加载器启动并找出 Beetle 类的编译代码（在名为 Beetle.class 的文件中）。
在加载过程中，编译器注意到有一个基类，于是继续加载基类。不论是否创建了基类的对象，基类都会被加载。

如果基类还存在自身的基类，那么第二个基类也将被加载，以此类推。接下来，根基类（例子中根基类是 Insect）的 static 的初始化开始执行，
接着是派生类，以此类推。这点很重要，因为派生类中 static 的初始化可能依赖基类成员是否被正确地初始化。

至此，必要的类都加载完毕，对象可以被创建了。首先，对象中的所有基本类型变量都被置为默认值，对象引用被设为 null ——
 这是通过将对象内存设为二进制零值一举生成的。接着会调用基类的构造器。本例中是自动调用的，
 但是你也可以使用 super 调用指定的基类构造器（在 Beetle 构造器中的第一步操作）。
 基类构造器和派生类构造器一样以相同的顺序经历相同的过程。当基类构造器完成后，实例变量按文本顺序初始化。
 最终，构造器的剩余部分被执行。
 */