package com.doit.demoCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: DemoCollections
 * @Author: zll
 * @CreateTime: 2021/6/23 14:40
 * @Desc: java 程序
 * @Version: 1.0
 */
//Collections.sort()
//1.自然排序
//2.定制排序
public class DemoCollections {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("liuyan",38,170.3));
        list.add(new Person("dalang",45,150.2));
        list.add(new Person("tangyan",23,166.5));
        list.add(new Person("ximen",56,173.8));

        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list,new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge()- o1.getAge();
            }
        });
        System.out.println(list);



        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(2);
        list2.add(1);
        list2.add(4);
        Collections.sort(list2,new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        System.out.println(list2);


        List<Student> list3 = new ArrayList<Student>();
        list3.add(new Student("011",87));
        list3.add(new Student("002",64));
        list3.add(new Student("007",78));
        list3.add(new Student("003",90));
        Collections.sort(list3,new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getScore(),o2.getScore());
            }
        });
        System.out.println(list3);
    }
}
