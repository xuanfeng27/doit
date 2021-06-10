package com.doit.demoTest;

import java.util.ArrayList;


/*匿名内部类(掌握)
匿名内部类就是没有类名的内部类
匿名内部类的定义与匿名内部类对象的创建必须在一起, 匿名内部类只使用一次*/
public class TestFailFast {
    public static void main(String[] args) {//钻石操作符
        ArrayList<Integer> arrayInt = new ArrayList<Integer>(){
            // 原因: 无法将 '<>' 与匿名内部类一起使用
            {
                add(4);
                add(3);
                add(5);
            }
        };
        for (Integer array:arrayInt) {
            /*Exception in thread "main" java.util.ConcurrentModificationException*/
            if(array == 3){
                arrayInt.remove(array);
            }
        }
        System.out.println(arrayInt);

    }
}
/*之所以会抛出CMException异常，是因为我们的代码中使用了增强for循环，而在增强for循环中，
集合遍历是通过iterator进行的，但是元素的add/remove却是直接使用的集合类自己的方法。
这就导致iterator在遍历的时候，会发现有一个元素在自己不知不觉的情况下就被删除/添加了，
就会抛出一个异常，用来提示用户，可能发生了并发修改！

所以，在使用Java的集合类的时候，如果发生CMException，优先考虑fail-fast有关的情况，
实际上这里并没有真的发生并发，只是Iterator使用了fail-fast的保护机制，
只要他发现有某一次修改是未经过自己进行的，那么就会抛出异常。*/