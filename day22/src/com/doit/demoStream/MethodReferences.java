package com.doit.demoStream;

/**
 * @ClassName: MethodReferences
 * @Author: zll
 * @CreateTime: 2021/7/3 20:01
 * @Desc: java 程序
 * @Version: 1.0
 */
/*符号表示 ::
符号说明 : 双冒号为方法引用运算符，而它所在的表达式被称为方法引用。
应用场景 : 如果Lambda要表达的函数方案 , 已经存在于某个方法的实现中，那么则可以使用方法引用。
方法引用写法：System.out::println 直接让System.out中的println方法来取代Lambda。
对象名--引用成员方法  str::toUpperCase
类名--引用静态方法 Math::random
类--构造引用 Person::new
由于构造器的名称与类名完全一样，并不固定。所以构造器引用使用类名称::new的格式表示
数组--构造引用
Lambda表达式：length -> new int[length]  方法引用：int[]::new
*/
public class MethodReferences {
    public static void main(String[] args) {

    }
}
