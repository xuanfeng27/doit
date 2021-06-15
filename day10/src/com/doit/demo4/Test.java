package com.doit.demo4;

import java.util.ArrayList;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/15 17:23
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        double zongjichan =100000;
        ArrayList<Employee> list =new ArrayList<>();
        Manager m1 = new Manager("aaa","001",1000,2000,3000);
        ChuZI c1 = new ChuZI("bbb","002",2000,3000);
        FuWu f1 =new FuWu("ccc","003",500,1500);
        list.add(m1);
        list.add(c1);
        list.add(f1);
        Company com = new Company(zongjichan, list);
        com.show();
        com.faGongZi();
        com.show();
    }
}
