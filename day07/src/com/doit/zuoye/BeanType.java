package com.doit.zuoye;

/**
 * @ClassName: BeanType
 * @Author: zll
 * @CreateTime: 2021/6/11 16:51
 * @Desc: java 程序
 * @Version: 1.0
 */
public class BeanType {
    private String name;
    private String adress;
    private int age;

    public BeanType(){

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAdress(){
        return adress;
    }

    public void setAdress(String adress){
        this.adress = adress;
    }
}
