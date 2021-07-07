package com.doit.myAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

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

/*
JDK5.0提供了4个标准的meta-annotation类型，分别是：
Retention
    RetentionPolicy.SOURCE:在源文件中有效（即源文件保留），编译器直接丢弃这种策略的注释
    RetentionPolicy.CLASS:在class文件中有效（即class保留） ， 当运行 Java 程序时, JVM
    不会保留注解。 这是默认值
    RetentionPolicy.RUNTIME:在运行时有效（即运行时保留），当运行 Java 程序时, JVM 会
    保留注释。程序可以通过反射获取该注释。
Target
Documented
    @Documented: 用于指定被该元 Annotation 修饰的 Annotation 类将被
    javadoc 工具提取成文档。默认情况下，javadoc是不包括注解的。
    定义为Documented的注解必须设置Retention值为RUNTIME。

Inherited
    @Inherited: 被它修饰的 Annotation 将具有继承性。如果某个类使用了被
    @Inherited 修饰的 Annotation, 则其子类将自动具有该注解。
 */

/*
类型注解：
 JDK1.8之后，关于元注解@Target的参数类型ElementType枚举值多了两个：TYPE_PARAMETER,TYPE_USE。
 在Java 8之前，注解只能是在声明的地方所使用，Java8开始，注解可以应用在任何地方。
 ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 */
class TestTypeDefine<@TypeDefine() U> {
    private U u;
    public <@TypeDefine() T> void test(T t){ }
}

@Target({ElementType.TYPE_PARAMETER})
@interface TypeDefine{ }

