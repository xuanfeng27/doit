package com.doit.zy;

/**
 * @ClassName: CatClass
 * @Author: zll
 * @CreateTime: 2021/6/12 19:51
 * @Desc: java 程序
 * @Version: 1.0
 */
public class CatClass extends Animal {

    public CatClass() {
    }

    public CatClass(String name){
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName()+"eat fish");
    }

    @Override
    public void sleep() {
        System.out.println("lay sleep");
    }

    public void getMouse(){
        System.out.println("get Mouse");
    }
}
