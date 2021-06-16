package com.doit.demo1;
//final 使用场景 订单状态编号
/**
 * @ClassName: Order
 * @Author: zll
 * @CreateTime: 2021/6/15 11:34
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Order {
    private int state;//0未支付  1已支付   2已发货   3已签收

    public static final int WEI_ZHI_FU = 0;
    public static final int YI_ZHI_FU = 1;
    public static final int YI_FA_HUO =2;
    public static final int YI_QIAN_SHOU = 3;

    public Order() {
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
