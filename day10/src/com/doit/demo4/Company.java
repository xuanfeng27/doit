package com.doit.demo4;

import java.util.ArrayList;

/**
 * @ClassName: Company
 * @Author: zll
 * @CreateTime: 2021/6/15 17:05
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Company {
    private double zongzichan;
    private ArrayList<Employee> list;

    public Company() {
    }

    public Company(double zongzichan, ArrayList<Employee> list) {
        this.zongzichan = zongzichan;
        this.list = list;
    }

    public double getZongzichan() {
        return zongzichan;
    }

    public void setZongzichan(double zongzichan) {
        this.zongzichan = zongzichan;
    }

    public ArrayList<Employee> getList() {
        return list;
    }

    public void setList(ArrayList<Employee> list) {
        this.list = list;
    }

    public void show(){

        for (int i = 0; i < list.size(); i++) {
               Employee employee = list.get(i);
               System.out.println(employee.getName());
               System.out.println(employee.getId());
               System.out.println(employee.getCunkuan());
               System.out.println(employee.getSalary());
               if(employee instanceof Manager){
                   Manager mg = (Manager)employee;
                   System.out.println(mg.getBonus());
               }
           }
        System.out.println(zongzichan);
    }

    public void faGongZi(){
        for (int i = 0; i < list.size(); i++) {
            Employee employee = list.get(i);
            zongzichan -= employee.getSalary();
            employee.setCunkuan(employee.getCunkuan()+employee.getSalary());

            if (employee instanceof Manager){
                Manager mg = (Manager)employee;
                zongzichan -= mg.getBonus();
                mg.setCunkuan(mg.getCunkuan()+mg.getBonus());
            }
        }
    }

}
