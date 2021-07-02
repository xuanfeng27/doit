package com.doit.demoObjStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: DemoObjStream
 * @Author: zll
 * @CreateTime: 2021/7/2 16:00
 * @Desc: java 程序
 * @Version: 1.0
 */

public class DemoObjStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       File file = new File("day21\\src\\com\\doit\\demoObjStream\\Person.txt");

       //writeObj(file);
       //readObj(file);
       /*序列号冲突异常
       Exception in thread "main" java.io.InvalidClassException: com.doit.demoObjStream.Person;
       local class incompatible: stream classdesc serialVersionUID = -1364389640633781340,
        local class serialVersionUID = 1182048678479915249
        */

        //writeObjList(file);//集合序列化
        //readObjList(file);
    }

    public static void writeObj(File file) throws IOException {
        //对象序列化
        OutputStream out = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        Person p = new Person("liuyan",38);
        oos.writeObject(p);
        oos.close();
    }

    public static void readObj(File file) throws IOException, ClassNotFoundException {
        //反序列化 不会调用构造方法
        InputStream in = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object o = ois.readObject();//p 多态
        System.out.println(o);
        ois.close();
    }

    public static void writeObjList(File file) throws IOException {
        //多个对象序列化
        OutputStream out = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        ArrayList<Person> list = new ArrayList<Person>();
        Person p = new Person("liuyan",38);
        Person p2 = new Person("dalang",8);
        Person p3 = new Person("tangyan",18);
        list.add(p);
        list.add(p2);
        list.add(p3);
        oos.writeObject(list);
        oos.close();
    }

    public static void readObjList(File file) throws IOException, ClassNotFoundException {
        //反序列化 不会调用构造方法
        InputStream in = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object o = ois.readObject();//p 多态
        ois.close();
        ArrayList<Person> list = (ArrayList<Person>) o;
        for (Person p : list) {
            System.out.println(p);
        }
    }
}

/*
      java.io.ObjectOutputStream 序列化流
           构造方法
               public ObjectOutputStream(OutputStream out)
                            OutputStream out:可以传入其任意子类对象 FileOutputStream BufferedOutputStream

           方法
               writeObject(Object obj)  写对象


     java.io.ObjectInputStream  反序列化流
           构造方法
              public ObjectInputStream(InputStream in)
                           InputStream in:可以传入其任意子类对象 FileInputStream BufferedInputStream
           方法
              Object readObject() 读对象



       private int age 序列化  将private改为public   直接反序列化

       序列号冲突异常
       Exception in thread "main" java.io.InvalidClassException:
       com.doit.demo04.Person;
       local class incompatible:
       stream classdesc serialVersionUID = 9169567022208465930,
       local class serialVersionUID = -4499969095818480457
 */