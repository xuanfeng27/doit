package com.doit.laptop;
//**接口中，无法定义成员变量，但是可以定义常量，其值不可以改变，默认使用public static final修饰。
//**接口中可以定义方法，方法也有固定的修饰符，public abstract
//**接口没有构造方法,不能直接创建对象
/**
 * @ClassName: Usb
 * @Author: zll
 * @CreateTime: 2021/6/14 17:17
 * @Desc: java 程序
 * @Version: 1.0
 */
public interface Usb {
    public abstract void openUsb();

    public abstract void closeUsb();

}
