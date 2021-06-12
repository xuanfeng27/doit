package com.doit.zy;

/**
 * @ClassName: DogClass
 * @Author: zll
 * @CreateTime: 2021/6/12 19:52
 * @Desc: java 程序
 * @Version: 1.0
 */
public class DogClass extends Animal{

    public DogClass() {
    }

    public DogClass(String name){
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName()+"eat meat");
    }

    @Override
    public void sleep() {
        System.out.println("pa sleep");
    }

    public void doorKeeper(){
        System.out.println("door keeper");
    }
}
