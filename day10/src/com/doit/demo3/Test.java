package com.doit.demo3;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/15 15:25
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        InnerClass in = new InnerClass();
        Fly f =  in.getFly();//多态
        f.fly();


        //匿名内部类
        new Fly(){

            @Override
            public void fly() {
                System.out.println("匿名内部类fly方法重写");
            }
        }.fly();

        ((Fly)()->System.out.println("ssss")).fly();

    }

}
