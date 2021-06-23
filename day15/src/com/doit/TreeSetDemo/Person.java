package com.doit.TreeSetDemo;

/**
 * @ClassName: Person
 * @Author: zll
 * @CreateTime: 2021/6/23 17:04
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Person implements Comparable<Person> {
    private int age;
    private double score;

    public Person() {
    }

    public Person(int age, double score) {
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if(this.age == o.age){
            return Double.compare(this.score, o.score);
        }
        return this.age - o.age;
    }
}
