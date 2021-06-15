package com.doit.laptop;

/**
 * @ClassName: Computer
 * @Author: zll
 * @CreateTime: 2021/6/14 17:19
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Computer {

    public void open(){
        System.out.println("开机");
    }

    public void close(){
        System.out.println("关机");
    }

   /* public void usb(Mouse mouse){
    }
    //使用接口Usb 来避免写许多重载usb方法，造成代码重复

    public void usb(Keyboard keyboard){
    }*/

    public void usb(Usb usb){
        usb.openUsb();
        usb.closeUsb();
    }

}
