package com.doit.constructor;

/**
 * @ClassName: Student
 * @Author: zll
 * @CreateTime: 2021/6/12 11:49
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Student extends Person {
    String a = "subclass string";
    private double id;

    public Student() {
        System.out.println("student 空参构造");
    }

    public Student(double id) {
        this.id = id;
        System.out.println("student 带参构造");
    }

    public Student(String name, int age, String a, double id) {
        super(name, age);
        this.a = a;
        this.id = id;
    }

    public Student(double id, String name, int age) {
        //在子类的每个构造方法的 第一行 都默认有一个父类的无参构造super（），不写也有，写了就Java不提供
        super(name,age);
        this.id = id;
        System.out.println("student 满参构造");
    }

    public Student(double id,int n) {
        this(id);//调用自己的其它构造方法，放在第一行   public Student(double id)
        for (int i = 0; i < n; i++) {
            System.out.println("n");
        }
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public void thisAndSuper(){
        String a = "method string";
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(super.a);

        this.testSup();
        super.testSup();
    }

    public void testSup(){
        System.out.println("subclass func");
    }
}
