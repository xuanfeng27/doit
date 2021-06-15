package com.doit.demo1;

/**
 * @ClassName: StaticConstants
 * @Author: zll
 * @CreateTime: 2021/6/15 11:35
 * @Desc: java 程序
 * @Version: 1.0
 */
public class StaticConstants {
    public static final double PI = 3.1415926;//常量 StaticConstants.PI  比如 Math.PI

    public static void main(String[] args) {
        Order order = new Order();
        //shit code
        order.setState(0);
        order.setState(2);

        //优化代码 beautiful code
        order.setState(Order.YI_ZHI_FU);
        order.setState(Order.YI_FA_HUO);
    }
}
