package com.doit.demoTest;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName: StudentsTest
 * @Author: zll
 * @CreateTime: 2021/6/9 16:00
 * @Desc: java 程序
 * @Version: 1.0
 */
public class StudentsTest {
    public static void main(String[] args) {
        ArrayList<Students> list = new ArrayList<>();
        addStudents(list);
        show(list);
        Students st = getStudent(list);
        System.out.println(st.name + " " + st.age);

    }
    public static void addStudents(ArrayList<Students> list){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            Students st = new Students();
            System.out.println("请输入学生姓名：");
            st.name = sc.next();
            System.out.println("请输入学生年龄：");
            st.age = sc.nextInt();
            list.add(st);
        }
    }

    public static void show(ArrayList<Students> list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i).name +" "+list.get(i).age;
        }
        System.out.println(str);
    }

    public static Students getStudent(ArrayList<Students> list) {
        int idx = new Random().nextInt(list.size());
        return list.get(idx);
    }
}
