package com.doit.duoTai;

public interface HomeKeeper {
    public abstract void lookHome();

    default void lookMe(){//java8 默认方法
        System.out.println("default func interface");
        HomeKeeper.staticIface();//
    }

    static void staticIface(){//静态方法 Java8
        System.out.println("interface static func");
    }
}
