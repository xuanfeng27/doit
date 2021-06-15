package com.doit.laptop;

/**
 * @ClassName: Mouse
 * @Author: zll
 * @CreateTime: 2021/6/14 17:18
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Mouse implements Usb {

    @Override
    public void openUsb() {
        System.out.println("mouse open");
    }

    @Override
    public void closeUsb() {
        System.out.println("mouse close");
    }
}
