package com.doit.zy;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/12 20:05
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        Home hm = new Home();
        hm.eatAtHome(new CatClass("猫"));
        hm.eatAtHome(new DogClass("狗"));
    }
}
