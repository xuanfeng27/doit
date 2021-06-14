package com.doit.duoTai;

/**
 * @ClassName: Home
 * @Author: zll
 * @CreateTime: 2021/6/14 9:53
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Home {

    public void eatAtHome(Animal a){
        System.out.println("在家吃饭");
        a.eat();
    }

    public void lookHome(HomeKeeper hk){
        hk.lookHome();//abstract func ---> subclass override func
    }

}
