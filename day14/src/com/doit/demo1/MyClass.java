package com.doit.demo1;

/**
 * @ClassName: MyClass
 * @Author: zll
 * @CreateTime: 2021/6/21 15:17
 * @Desc: java 程序
 * @Version: 1.0
 */

//泛型类自定义 public class 类名<T>{}
//泛型方法自定义 public <> 返回值类型 方法名（）{}
public class MyClass<Z> {
    private Z name;
    private Z age;

    public <X> void method(X x){
        System.out.println(x.getClass());
    }

    public <X> void method2(X x, Z z){
        System.out.println(x.getClass());
        System.out.println(z.getClass());
    }



    public MyClass() {
    }

    public MyClass(Z name, Z age) {
        this.name = name;
        this.age = age;
    }

    public Z getName() {
        return name;
    }

    public void setName(Z name) {
        this.name = name;
    }

    public Z getAge() {
        return age;
    }

    public void setAge(Z age) {
        this.age = age;
    }
}
