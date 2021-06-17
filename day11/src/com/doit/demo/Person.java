package com.doit.demo;

import java.util.Objects;

/**
 * @ClassName: Person
 * @Author: zll
 * @CreateTime: 2021/6/17 10:01
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public Person(int age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

  /*  @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj == null){
            return false;
        }

        if(!(obj instanceof Person)){
            return false;
        }

        Person other = (Person) obj;

        if(!(this.age == other.age)){
            return false;
        }

        if(this.name==null||!(this.name.equals(other.name))){
            return false;
        }

        return true;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        if (name==null)
            return 0;
        int result = age;
        result = 31 * result + name.hashCode();
        return result;
    }
}
