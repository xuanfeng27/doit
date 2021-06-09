package com.doit.demoTest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName: StudentManager
 * @Author: zll
 * @CreateTime: 2021/6/9 19:30
 * @Desc: java 程序
 * @Version: 1.0
 */
public class StudentManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        a:while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("add");
                    addStudent(list,sc);
                    break;
                case 2:
                    System.out.println("del");
                    delStudent(list,sc);
                    break;
                case 3:
                    System.out.println("change");
                    changeStudent(list,sc);
                    break;
                case 4:
                    System.out.println("show");
                    showStudent(list);
                    break;
                case 5:
                    System.out.println("game over");
                    break a;
                default:
                    System.out.println("你瞎啊");
                    break ;
            }
        }
    }

    public static void addStudent( ArrayList<Student> list,Scanner sc){
        Student st = new Student();
        while (true){
            System.out.println("请输入学生id");
            st.sid = sc.next();
            boolean bl = isUsed(st.sid,list);
            if(bl){
                System.out.println("sorry,你输入的学号已经被占用，请重新输入");
            }else {
                break;
            }
        }

        System.out.println("学生姓名");
        st.name = sc.next();
        System.out.println("学生年龄");
        st.age = sc.next();
        System.out.println("学生所在地");
        st.address = sc.next();
        list.add(st);
        System.out.println("添加学生成功");
    }

    public static boolean isUsed(String sid, ArrayList<Student> list){
        for (int i = 0; i < list.size(); i++) {
            if(sid.equals(list.get(i).sid)){
                return true;
            }
        }
        return false;
    }

    public static void delStudent(ArrayList<Student> list,Scanner sc){
        if(list.size()==0){
            System.out.println("还没有录入学生");
            return;
        }
        while (true){
            System.out.println("请输入学生id");
            String sid = sc.next();
            for (int i = 0; i < list.size(); i++) {
                if(sid.equals(list.get(i).sid)){
                    list.remove(list.get(i));
                    System.out.println("删除学生成功");
                    return;
                }
            }
            System.out.println("没有这个学生,请重新输入");
        }
    }

    public static void changeStudent(ArrayList<Student> list,Scanner sc){
        while (true){
            if(list.size()==0){
                System.out.println("还没有录入学生");
                return;
            }
            System.out.println("请输入你要修改的学生的id");
            String sid = sc.next();
            for (int i = 0; i < list.size(); i++) {
                if(sid.equals(list.get(i).sid)){
                    System.out.println("学生姓名");
                    list.get(i).name = sc.next();
                    System.out.println("学生年龄");
                    list.get(i).age = sc.next();
                    System.out.println("学生所在地");
                    list.get(i).address = sc.next();
                    System.out.println("修改学生成功");
                    return;
                }
            }
            System.out.println("没有这个学生id");
        }
    }

    public static void showStudent(ArrayList<Student> list){
        if(list.size()==0){
            System.out.println("还没有学生录入");
        }else {
            System.out.println("学号\t姓名\t年龄\t居住地");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).sid+"\t"+list.get(i).name
                        +"\t"+list.get(i).age+"\t"+list.get(i).address);
            }
        }
    }

}
