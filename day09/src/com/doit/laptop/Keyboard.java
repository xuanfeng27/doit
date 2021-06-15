package com.doit.laptop;

/**
 * @ClassName: Keyboard
 * @Author: zll
 * @CreateTime: 2021/6/14 17:19
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Keyboard implements Usb{

    @Override
    public void openUsb() {
        System.out.println("keyboard open");
    }

    @Override
    public void closeUsb() {
        System.out.println("keyboard close");
    }
}
