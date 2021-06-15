package com.doit.laptop;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/14 17:21
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.open();
        computer.usb(new Mouse());
        computer.usb(new Keyboard());
    }
}
