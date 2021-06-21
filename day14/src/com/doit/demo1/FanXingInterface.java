package com.doit.demo1;

/**
 * @ClassName: FanXingInterface
 * @Author: zll
 * @CreateTime: 2021/6/21 15:49
 * @Desc: java 程序
 * @Version: 1.0
 */
public interface FanXingInterface<K, V> {
    public abstract void method(K key, V value);
}

class FanClass<K, V> implements FanXingInterface<K, V> {

    @Override
    public void method(K key, V value) {
        System.out.println(key + " "+ value);
    }
}

class FanClass2 implements FanXingInterface<String,Integer>{

    @Override
    public void method(String key, Integer value) {
        System.out.println(key + " "+value);
    }
}