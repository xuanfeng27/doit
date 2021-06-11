package com.doit.zuoye;

import java.util.Scanner;

/**
 * @ClassName: TestArrBeanType
 * @Author: zll
 * @CreateTime: 2021/6/11 17:19
 * @Desc: java 程序
 * @Version: 1.0
 */
public class TestArrBeanType {

    public static void main(String[] args) {
        BeanType[] arrayBean = new BeanType[3];
        TestArrBeanType testArrBean = new TestArrBeanType();
        testArrBean.addListBean(arrayBean);
        testArrBean.showListBean(arrayBean);
    }

    public void addListBean(BeanType[] arrayBean){
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arrayBean.length; i++) {
            BeanType bean = new BeanType();
            System.out.println("请输入name");
            bean.setName(sc.next());
            System.out.println("请输入adress");
            bean.setAdress(sc.next());
            System.out.println("请输入age");
            bean.setAge(sc.nextInt());
            arrayBean[i] = bean;
        }

    }

    public void showListBean(BeanType[] arrayBean){
        for (int i = 0; i < arrayBean.length; i++) {
            System.out.println(arrayBean[i].getName());
        }
    }
}
