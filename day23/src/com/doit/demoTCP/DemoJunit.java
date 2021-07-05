package com.doit.demoTCP;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//白盒测试
/**
 * @ClassName: DemoJunit
 * @Author: zll
 * @CreateTime: 2021/7/5 17:35
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
     单元测试
        可以对我们写的方法 进行测试  可以理解为取代main方法

        单元测试是第三方工具,但是我们不需要导入jar因为 idea默认集成了单元测试

       定义一个空参数 没有返回值的方法 在方法上写@org.junit.Test
       右键运行
 */

public class DemoJunit {
    public static void main(String[] args) {

    }

    @Before
    public void befor(){
        System.out.println("before");
    }

    @Test
    public void method(){
        System.out.println("hello");
    }

    @Test
    public void method2(){
        System.out.println("world");
    }

    @After
    public void after(){
        System.out.println("after");
    }


}
