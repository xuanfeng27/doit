package com.doit.demoGetMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FanXingRemove
 * @Author: zll
 * @CreateTime: 2021/7/6 15:42
 * @Desc: java 程序
 * @Version: 1.0
 */
//泛型擦除
    //java中的泛型都是伪泛型，只在编译时生效，在运行时class文件中都是Object类型
public class FanXingRemove {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        Class<? extends List> c = list.getClass();
        Method add = c.getMethod("add", Object.class);
        add.invoke(list,10);
        add.invoke(list,true);
        add.invoke(list,10.4);
        System.out.println(list);

        Object get = c.getMethod("get", int.class).invoke(list, 0);
        System.out.println(get);
    }
}
