package com.doit.phone;

/**
 * @ClassName: SmartPhone
 * @Author: zll
 * @CreateTime: 2021/6/12 11:23
 * @Desc: java 程序
 * @Version: 1.0
 */
public class SmartPhone extends Phone {
    private String address;

    public SmartPhone() {
    }

    @Override
    public void showCallInfo(long number) {
        super.showCallInfo(number);//调用父类方法，避免复制重复代码
        System.out.println("归属地"+address);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
