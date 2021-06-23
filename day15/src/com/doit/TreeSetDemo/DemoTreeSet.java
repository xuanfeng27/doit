package com.doit.TreeSetDemo;

import com.doit.demoCollections.Student;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName: DemoTreeSet
 * @Author: zll
 * @CreateTime: 2021/6/23 16:46
 * @Desc: java 程序
 * @Version: 1.0
 */

public class DemoTreeSet {
    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>();
        set.add(new Person(22,78.5));
        set.add(new Person(12,68.9));
        set.add(new Person(42,58.2));
        set.add(new Person(32,88.1));
        set.add(new Person(32,68.1));
        System.out.println(set);



        Set<Student> set2 = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o2.getScore() == o1.getScore()) {
                    return o1.getId().compareTo(o2.getId());
                }
                return Double.compare(o1.getScore(), o2.getScore());
            }
        });
        set2.add(new Student("22",78.5));
        set2.add(new Student("12",68.9));
        set2.add(new Student("42",58.2));
        set2.add(new Student("32",88.1));
        set2.add(new Student("05",68.9));
        System.out.println(set2);
    }
}
