package com.doit.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName: TestArrayList
 * @Author: zll
 * @CreateTime: 2021/6/9 9:01
 * @Desc: java 程序
 * @Version: 1.0
 */
public class TestArrayList {

    public static void main(String[] args) {
        ArrayList<Byte> listB = new ArrayList<>();
        ArrayList<Short> listS = new ArrayList<>();
        ArrayList<Integer> listInt = new ArrayList<>();
        ArrayList<Long> listL = new ArrayList<>();
        ArrayList<Float> listF = new ArrayList<>();
        ArrayList<Double> listDb = new ArrayList<>();
        ArrayList<Character> listChar = new ArrayList<>();
        ArrayList<Boolean> listBool = new ArrayList<>();

        ArrayList<String> listStr = new ArrayList<>();

        ArrayList<Person> listPreson = new ArrayList<>();
        addPerson(listPreson);
        /*Person p1 = new Person();
        p1.name = "p1";
        listPreson.add(2,p1);
        listPreson.set(3,p1);
        listPreson.remove(0);
        listPreson.clear();*/
        String listPresonStr =  toString(listPreson);
        System.out.println(listPresonStr);

        Person rlt = getPerson(listPreson);
        System.out.println(rlt.name);
    }

    public static String toString(ArrayList<Person> list) {
        String str = "[";
        for (int i = 0; i < list.size(); i++) {
            String s = "{name:" + list.get(i).name + "," + "age:" + list.get(i).age + "}";
            str = i==list.size()-1?str+s:str+s+",";
        }
        str+=']';
        return str;
    }

    public static void addPerson(ArrayList<Person> listPreson){
        for (int i = 0; i < 5; i++) {
            Person p = new Person();
            p.name ="name" +i;
            p.age = i*10;
            listPreson.add(p);
        }
    }

    public static Person getPerson(ArrayList<Person> list){
        int idx = new Random().nextInt(list.size());
         return list.get(idx);
    }
}
