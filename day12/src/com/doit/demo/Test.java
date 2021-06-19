package com.doit.demo;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎来到学生管理系统!");

        a: while (true){
        System.out.println("1.注册   2.登陆");

        int choose = sc.nextInt();


            switch (choose) {
                case 1:
                    register(list);
                    break;
                case 2:
                    boolean b = login(list);
                    if(b){
                        System.out.println("登陆成功");
                        break a;
                    }else{
                        System.out.println("用户名或密码错误,请重新登陆");
                    }
                    break;
                default:
                    System.out.println("你瞎啊?");
                    break;
            }
        }


        System.out.println("进入学生管理系统");




    }

    public static boolean login(ArrayList<User> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的用户名:");
        String username = sc.nextLine().trim();
        System.out.println("请输入您的密码:");
        String password = sc.nextLine().trim();

        //使用用户名和密码创建一个新的User
        User u = new User(username,password);

        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            //因为重写了equals方法 所以比较两个User对象就是在比较username和password的值
            if(user.equals(u)){

                return true;
            }
        }

        return  false;

    }

    public static void register(ArrayList<User> list ){
        Scanner sc = new Scanner(System.in);
        User u = new User();
        while (true){
            System.out.println("请输入用户名:");
            String username = sc.nextLine().trim();

            boolean check = check(username, list);

            if(check){
                System.out.println("用户名重复请重新输入");
            }else{
                u.setUsername(username);
                break;
            }
        }

        System.out.println("请输入密码:");
        String password = sc.nextLine().trim();
        u.setPassword(password);


        list.add(u);
        System.out.println("注册成功!");
    }

    //检测用户名是否存在 存在返回true 不存在返回false
    public static boolean check(String username,ArrayList<User> list){
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if(user.getUsername().equals(username)){
                return true;
            }
        }

        return false;
    }
}
