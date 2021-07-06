package com.doit.myAnnotation;

/**
 * @ClassName: MyAnnotation
 * @Author: zll
 * @CreateTime: 2021/7/6 17:04
 * @Desc: java 程序
 * @Version: 1.0
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