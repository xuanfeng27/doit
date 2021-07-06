package com.doit.myAnnotation;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/7/6 17:05
 * @Desc: java 程序
 * @Version: 1.0
 */
//空注解可以直接使用
// 有属性的注解要赋初值，每一个都要赋值，除非有默认值default
//特殊情况，当只有一个属性且属性名是value时，可以省略写法
@MyAnnotation3("ab")
@MyAnnotation2(name = "aaa",c=String.class,my=@MyAnnotation,arr={"a","b"})
@MyAnnotation
public class myTest {

    @MyAnnotation
    public static void main(String[] args) {

    }
}
