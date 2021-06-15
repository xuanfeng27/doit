package com.doit.transforPoly;

/**
 * @ClassName: Transfor
 * @Author: zll
 * @CreateTime: 2021/6/14 15:47
 * @Desc: java 程序
 * @Version: 1.0
 */
public abstract class Transfor {
    String fu = "fu";

    public void fu(){
        System.out.println("fu");
    }
}


class SubTransfor extends Transfor{
    String fu = "fz";
    String zi = "zi";

    @Override
    public void fu() {
        System.out.println("zi override fu");
    }

    public void zi(){
        System.out.println("zi");
    }
}

class SubTransfor2 extends Transfor{
    public void zi2(){
        System.out.println("zi2");
    }
}

class  Test{

    public static void main(String[] args) {
        //default upcasting poly向上转型
        Transfor trans = new SubTransfor();
        trans.fu();//"zi override fu"
        //trans.zi(); 错误

        method_instanceof(trans);

       /* //force downcasting 向下转型
        SubTransfor subTrans = (SubTransfor)trans;
        subTrans.zi();//"zi"*/

    }

    public static void method_instanceof(Transfor trans){
        if(trans instanceof SubTransfor){//判断类型返回true or false
            SubTransfor s1 = (SubTransfor)trans;
            s1.zi();//zi
        }
        if(trans instanceof SubTransfor2){
            SubTransfor2 s2 = (SubTransfor2) trans;
            s2.zi2();//zi2
        }
    }

}