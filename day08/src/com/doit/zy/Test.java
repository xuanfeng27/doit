package com.doit.zy;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/12 20:05
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test {
    static double a = Math.random();//static在加载时已经被初始化，并不是每次创建新对象时都初始化。
    // static 变量只被初始化一次。
    double b = Math.random();
    private final int i = 0;//值不可变
    private final Home h = new Home();//引用地址不可改变，对象内容可以改变 final方法不能被继承改写

    public Test() {
    }

    public static void main(String[] args) {
        Home hm = new Home();
        hm.eatAtHome(new CatClass("猫"));
        hm.eatAtHome(new DogClass("狗"));

        System.out.println(new Test().a);
        System.out.println(new Test().a);

        System.out.println(new Test().b);
        System.out.println(new Test().b);

        System.out.println(new Test().i);
        System.out.println(new Test().i);

        System.out.println(new Test().h.a);
        System.out.println(new Test().h.a =4);
    }
}
