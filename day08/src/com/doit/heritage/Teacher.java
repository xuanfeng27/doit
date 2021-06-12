package com.doit.heritage;

/**
 * @ClassName: Teacher
 * @Author: zll
 * @CreateTime: 2021/6/12 10:33
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Teacher extends Employee {
    private String adress;

    public Teacher() {
    }

    //子类方法的访问权限应该大于等于父类方法的访问权限
    //返回值类型 如果是基本类型，要一致.
    // 如果是引用类型，子类方法的返回值类型可以说父类方法的返回值类型的子类
    @Override
    public int play() {
        return 8;
    }

    @Override
    public Teacher work() {
        return new Teacher();
    }

    @Override
    public void eat(){
        System.out.println("teacher eat");//覆写
    }

    public void eat(int a){
        System.out.println("teacher eat"+a);//重载
    }

    public void hit(){
        System.out.println("teacher hit bean");
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
