package com.doit.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @ClassName: GenericType
 * @Author: zll
 * @CreateTime: 2021/6/22 21:15
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
如果B是A的一个子类型（子类或者子接口），而G是具有泛型声明的类或接口，G<B>并不是G<A>的子类型！
比如：String是Object的子类，但是List<String >并不是List<Object>的子类。
 */
public class GenericType {
    public static void main(String[] args) {
        Collection<String> cc = new ArrayList<String>();
        //printCollection1(cc);报错，只能传Object类型
        printCollection2(cc);
    }
/*
读取List<?>的对象list中的元素时，永远是安全的，因为不管list的真实类型是什么，它包含的都是Object。
写入list中的元素时，不行。因为我们不知道c的元素类型，我们不能向其中添加对象。
 唯一的例外是null，它是所有类型的成员。
 */
    public static void printCollection1(Collection<Object> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }

    public static void printCollection2(Collection<?> c) {
        for (Object e : c) {
            System.out.println(e);
            //c.add(new Object())//不可以
        }

        Iterator<?> it = c.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }


}

class Father<T1, T2> {
}
// 子类不保留父类的泛型
// 1)泛型擦除
class Son1 extends Father {// 等价于class Son extends Father<Object,Object>{
}
// 2)具体类型
class Son2 extends Father<Integer, String> {
}
// 子类保留父类的泛型
// 1)全部保留
class Son3<T1, T2> extends Father<T1, T2> {
}
// 2)部分保留
class Son4<T2> extends Father<Integer, T2> {
}

