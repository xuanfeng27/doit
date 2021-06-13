package com.doit.zy;

/**
 * @ClassName: Home
 * @Author: zll
 * @CreateTime: 2021/6/12 20:02
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Home {
     int a = 1;
    public Home() {
    }

    public void eatAtHome(CatClass cat){
       cat.eat();
    }

    public void eatAtHome(DogClass dog){
        dog.eat();
    }
}
