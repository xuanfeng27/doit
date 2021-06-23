package com.doit.demo1;

import java.util.ArrayList;

/**
 * @ClassName: DemoArrayList
 * @Author: zll
 * @CreateTime: 2021/6/23 9:17
 * @Desc: java 程序
 * @Version: 1.0
 */

class Person{
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 /*   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }*/

}

public class DemoArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        System.out.println(list.contains("aaa"));//true

        ArrayList<Person> list2 = new ArrayList<>();
        list2.add(new Person(11,"aaa"));
        System.out.println(list2.contains(new Person(11, "aaa")));//false 没改写equals

    }
}
/*
  public boolean contains(Object o) {//多态 Object o = new Person(11, "aaa");
        return indexOf(o) >= 0;
    }

public int indexOf(Object o) {
    if (o == null) {
        for (int i = 0; i < size; i++)
            if (elementData[i]==null)
                return i;
    } else {
        for (int i = 0; i < size; i++)
            if (o.equals(elementData[i]))
                return i;
    }
    return -1;
}

  public boolean equals(Object obj) {//改写equals()
        return (this == obj);
    }
 */