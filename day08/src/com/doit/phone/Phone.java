package com.doit.phone;

/**
 * @ClassName: Phone
 * @Author: zll
 * @CreateTime: 2021/6/12 11:23
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Phone {
    private long number;

    public Phone() {
    }

    public void call(){

    }

    public void message(){

    }

    public void showCallInfo(long number){
        System.out.println("只显示手机号"+number);
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
