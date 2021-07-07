package com.doit.myAnnotation;

/**
 * @ClassName: MyAnnotation
 * @Author: zll
 * @CreateTime: 2021/7/6 17:04
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
Annotation 的成员变量在 Annotation 定义中以无参数方法的形式来声明。其
方法名和返回值定义了该成员的名字和类型。我们称为配置参数。类型只能
是八种基本数据类型、String类型、Class类型、enum类型、Annotation类型、
以上所有类型的数组。
 可以在定义 Annotation 的成员变量时为其指定初始值, 指定成员变量的初始
值可使用 default 关键字
 如果只有一个参数成员，建议使用参数名为value
 如果定义的注解含有配置参数，那么使用时必须指定参数值，除非它有默认
值。格式是“参数名 = 参数值”，如果只有一个参数成员，且名称为value，可以省略“value=”
 */

public @interface MyAnnotation {

}


@interface MyAnnotation2 {
    public abstract int age() default 18;
    public abstract String name();
    public abstract Class c();
    public abstract MyAnnotation my();
    public abstract String[] arr();

}

@interface MyAnnotation3 {
    public abstract String[] value();
}