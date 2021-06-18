package com.doit.demo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: SystemTest
 * @Author: zll
 * @CreateTime: 2021/6/18 14:55
 * @Desc: java 程序
 * @Version: 1.0
 */
//final类无法继承
//方法：static void exit(0)退出JVM；
// System.gc();  Object有finalize()方法由垃圾回收器调用
//System.currentTimeMillis();计算程序运行时间
//System.arrayCopy(srcArr,fromIndex,dest,fromIndex,length)
public class SystemTest {
    public static void main(String[] args) {
        long time1 = new Date().getTime();
        long time2 = Calendar.getInstance().getTimeInMillis();
        long time3 = System.currentTimeMillis();
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);

        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            //System.out.println(i);
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);

        new Person();
        new Person();
        new Person();
        new Person();
        System.gc();

        int[] arr = new int[]{2,3,7,5,6};
        int[] arr1 = new int[10];
        System.arraycopy(arr,1,arr1,0,3);
        System.out.println(Arrays.toString(arr1));

        arrayListTest();
    }

    public static void arrayListTest(){
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add(2,"z");
        System.out.println(list);
        System.out.println(list.size());

        //add()原理
        String[] str = {"1","2","3","4","5",null,null,null,null,null};
        System.arraycopy(str,2,str,2+1,5-2);//index  index+1   size-index
        System.out.println(Arrays.toString(str));
        str[2] = "z";
        //size++;
        System.out.println(Arrays.toString(str));

        //remove()原理 index+1  index  size-index-1
        list.remove(1);

        String[] str1 = {"1","2","3","4","5",null,null,null,null,null};
        System.arraycopy(str1,1+1,str1,1,5-1-1);//index  index+1  size-index
        System.out.println(Arrays.toString(str1));
        str1[5-1] = null;
        //size--;
        System.out.println(Arrays.toString(str1));

    }
}
