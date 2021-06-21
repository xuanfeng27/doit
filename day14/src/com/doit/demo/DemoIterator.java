package com.doit.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @ClassName: DemoIterator
 * @Author: zll
 * @CreateTime: 2021/6/21 10:24
 * @Desc: java 程序
 * @Version: 1.0
 */
public class DemoIterator {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        c.add("aaa");
        c.add("bbb");
        Iterator<String> it = c.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        //System.out.println(it.next());//NoSuchElementException 只能使用一次
        Person p1 = new Person("CCC",11);
        Person p2 = new Person("DDD",22);
        Collection<Person> c1 = new ArrayList<Person>();
        c1.add(p1);
        c1.add(p2);
        Iterator<Person> it2 = c1.iterator();
        while (it2.hasNext()){
            System.out.println(it2.next());
            //System.out.println(it2.next().getName() + it2.next().getAge());
            // 陷阱cursor++; 上一个元素name CCC + 下一个元素age 22
        }

        Collection<String> c2 = new ArrayList<>();
        c2.add("柳岩");
        c2.add("唐嫣");
        c2.add("大郎");
        c2.add("金莲");
        Iterator<String> it4 = c2.iterator();
        while (it4.hasNext()){
            String next = it4.next();
          /*  if("唐嫣".equals(next)){//字符串放在equals前面，防止nullPointException报错
                c2.add("西门");//add成功后，报并发修改异常modCount++ != exceptedModCount
            }*/

          /*  if("大郎".equals(next)){
          //remove成功，因为是倒数第二个集合元素，size-- modCount++ ---> curse==size ---> hasNext()返回false
                c2.remove("大郎");//ArrayList的remove操作报错；
            }*/
            if("唐嫣".equals(next)){
                it4.remove();//迭代器自己的remove方法可以用
                //删除“唐嫣”，it4中调用ArrayList.this.remove()方法，重新赋值expectedModCount=(++modCount)
            }
        }

        System.out.println("-----------------------------------------------------------");
        //增强for循环 JDK1.5 加上，也是使用的iterator ，
        Collection<String> c3 = new ArrayList<>();
        c3.add("1");
        c3.add("2");
        c3.add("3");
        c3.add("4");
        Iterator<String> it3 = c3.iterator();
        for (String s:c3) {
            if(it3.hasNext()){
                System.out.println(it3.next());
            }
        }

        for (Person p:c1){
            System.out.println(p.getName()+" "+p.getAge());
        }

    }
}
