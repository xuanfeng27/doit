package com.doit.ui;

import com.doit.service.AccountService;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("转账人:");
        String outName = sc.nextLine();
        System.out.println("收钱人:");
        String inName = sc.nextLine();
        System.out.println("转账金额");
        double money = sc.nextDouble();


        //调用service层 的转账功能
        AccountService service = new AccountService();
        service.transfer(outName,inName,money);



    }
}
