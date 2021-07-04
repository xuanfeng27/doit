package com.doit.demo;

/**
 * @ClassName: Person
 * @Author: zll
 * @CreateTime: 2021/7/3 10:17
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
/*
Java 内置四大核心函数式接口
函数式接口 参数类型 返回类型 用途
Consumer<T>
消费型接口 T void 对类型为T的对象应用操作，包含方法：void accept(T t)

Supplier<T>
供给型接口 无 T 返回类型为T的对象，包含方法：T get()

Function<T, R>
函数型接口 T R
对类型为T的对象应用操作，并返回结果。结果是R类型的对象。包含方法：R apply(T t)

Predicate<T>
断定型接口 T boolean 确定类型为T的对象是否满足某约束，并返回boolean 值。包含方法：boolean test(T t)
 */