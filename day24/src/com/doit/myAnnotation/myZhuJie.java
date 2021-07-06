package com.doit.myAnnotation;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


/*
      元注解
         修饰注解的注解

      @Retention 指定注解的声明周期
        SOURCE：注解只存在于Java源代码中，编译生成的字节码文件中就不存在了。
        CLASS：注解存在于Java源代码、编译以后的字节码文件中，运行的时候内存中没有，默认值。
        RUNTIME：注解存在于Java源代码中、编译以后的字节码文件中、运行时内存中，程序可以通过反射获取该注解。

      @Target 指定注解作用的位置
             TYPE： 用在类,接口上
             FIELD：用在成员变量上
             METHOD： 用在方法上
             PARAMETER：用在参数上
             CONSTRUCTOR：用在构造方法上
             LOCAL_VARIABLE：用在局部变量上
 */



@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@interface Book {
    public abstract  String bookName();
    public abstract  double price();
}




/*
       注解解析
           获取注解中的属性值


           AnnotatedElement接口
               方法
                  boolean isAnnotationPresent(Class annotationClass) 判断是否有指定的注解
                   T getAnnotation(Class<T> annotationClass) 获取指定的注解

           常用实现类
            Class Constructor  Method  Field
 */


@Book(bookName = "金瓶梅",price = 250)
public class myZhuJie {

    @Book(bookName = "金瓶梅.txt",price = 50)
    public void show(){

    }

    @Test
    public void test(){
        /*
             获取类上的注解
         */
        Class c = myZhuJie.class;

        boolean b = c.isAnnotationPresent(Book.class);
//        System.out.println(b);

        if(b){
            //获取指定注解
            Book book = (Book) c.getAnnotation(Book.class);
            System.out.println(book.bookName());
            System.out.println(book.price());
        }

    }

    @Test
    public void test2(){
        /*
            获取方法上的注解
         */
        Class c = myZhuJie.class;

        //获取所有方法

        Method[] ms = c.getMethods();

        for(Method m : ms){
            //判断方法上是否有注解
            boolean b = m.isAnnotationPresent(Book.class);

            //如果有则获取对应的注解
            if(b){
                Book book = m.getAnnotation(Book.class);
                System.out.println(book.bookName());
                System.out.println(book.price());
            }
        }

    }

}
