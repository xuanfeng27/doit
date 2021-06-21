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
            //System.out.println(it2.next().getName() + it2.next().getAge());//CCC 22
        }

        Collection<String> c2 = new ArrayList<>();
        c2.add("liuyan");
        c2.add("tangyan");
        c2.add("dalang");
        c2.add("jinlian");
        Iterator<String> it4 = c2.iterator();
        while (it4.hasNext()){
            String next = it4.next();
          /*  if("tangyan".equals(next)){//字符串放在equals前面，防止nullPointException
                c2.add("ximenqing");//add成功，并发修改异常modCount++ != exceptedModCount
            }*/

          /*  if("dalang".equals(next)){
          //成功，倒数第二个集合元素，size-- modCount++ ---> curse==size ---> hasNext()返回false
                c2.remove("dalang");
            }*/
            if("tangyan".equals(next)){
                it4.remove();
                //删除“tangyan”，it4中调用ArrayList.this.remove()方法，重新赋值expectedModCount=(++modCount)
            }
        }

        //增强for循环 JDK1.5
        Iterator<Person> it3 = c1.iterator();
        for (Person p:c1) {
            if(it3.hasNext()){
                System.out.println(it3.next());
            }
        }

        for (Person p:c1){
            System.out.println(p.getName()+" "+p.getAge());
        }

    }
}
