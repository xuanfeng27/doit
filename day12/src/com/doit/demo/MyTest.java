package com.doit.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: MyTest
 * @Author: zll
 * @CreateTime: 2021/6/19 19:56
 * @Desc: java 程序
 * @Version: 1.0
 */
public class MyTest {
    public static void main(String[] args) {
        List<MyUser> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎来到学生管理系统!");
        a:while (true){
            System.out.println("1.注册   2.登陆");
            int num = sc.nextInt();
            switch (num){
                case 1 :
                    register(sc,list);
                    break;
                case 2 :
                    login(sc,list);
                    break a;
                default:
                    System.out.println("fail");
                    break;
            }
        }
        System.out.println("进入学生管理系统");
    }

    public static void register(Scanner sc,List<MyUser> list) {
        MyUser myUser = new MyUser();
        while (true){
            sc.nextLine();//添加这一行，不然 String name为空串
            System.out.println("请输入用户名称：");
            String name = sc.nextLine().trim();
            boolean bl = checkUser(name,list);
            if (bl) {
                System.out.println("该用户名已被注册");
            }else {
                myUser.setUserName(name);
                break;
            }
        }
        System.out.println("请输入密码：");
        String password = sc.nextLine().trim();
        myUser.setPassword(password);
        list.add(myUser);
        System.out.println("恭喜你，注册成功");
    }

    public static void login(Scanner sc,List<MyUser> list){
        String name = "";
        while (true){
            System.out.println("请输入用户名称：");
            name = sc.nextLine().trim();
            System.out.println("请输入密码：");
            String password = sc.nextLine().trim();
            MyUser myUser = new MyUser(name,password);
            boolean bl = loginCheck(myUser,list);
            if (bl) {
                System.out.println("恭喜你，登录成功");
                break;
            }else {
                System.out.println("输入错误");
            }
        }
    }

    public static boolean checkUser(String name,List<MyUser> list) {
        for (MyUser user : list) {
            if (user.getUserName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public static boolean loginCheck(MyUser myUser,List<MyUser> list) {
        for (MyUser user : list) {
            if (user.equals(myUser)){
                return true;
            }
        }
        return false;
    }

}
