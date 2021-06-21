package com.doit.demo2;

import java.util.ArrayList;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/21 16:15
 * @Desc: java 程序
 * @Version: 1.0
 */
//泛型限定<?>
//<? extends T> T以及其子类
//<? super T> T以及其父类
public class Test {
    public static void main(String[] args) {
        ArrayList<Animal> list1 = new ArrayList<>();
        list1.add(new Animal());
        list1.add(new Animal());


        ArrayList<Cat> list2 = new ArrayList<>();
        list2.add(new Cat());
        list2.add(new Cat());

        ArrayList<Dog> list3 = new ArrayList<>();
        list3.add(new Dog());
        list3.add(new Dog());

        method(list1);
        method(list2);
        method(list3);

    }

    public  static void method(ArrayList<? extends Animal> list){
        for (Object t : list) {
            Animal a = (Animal) t;
            a.eat();
        }
    }
}
