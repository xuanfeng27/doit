package com.doit.lombokTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: LombokTest
 * @Author: zll
 * @CreateTime: 2021/7/6 20:41
 * @Desc: java 程序
 * @Version: 1.0
 */
public class LombokTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("aaa");
        System.out.println(person.getName());
        Person person1 = new Person("bbb",12,'男');
        System.out.println(person1);
    }
}



//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    private String name;
    private int age;
    private char sex;
}
