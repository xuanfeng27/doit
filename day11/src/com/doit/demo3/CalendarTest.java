package com.doit.demo3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: CalendarTest
 * @Author: zll
 * @CreateTime: 2021/6/18 11:25
 * @Desc: java 程序
 * @Version: 1.0
 */
//Calendar抽象类 静态方法: static Calendar  getInstance()
//方法： int get(int field)获取信息
//Date getTime()
//add() ;set()
public class CalendarTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        String month1 = month>9?month+"":"0"+month;
        int day = c.get(Calendar.DATE);
        System.out.println(year+"年"+month1+"月"+day+"日");

        //Calendar --->Date
        Date d1 = c.getTime();
        System.out.println(d1);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(d1);
        System.out.println(s);

        //add() ; set();
        c.add(Calendar.YEAR,2020);
        c.set(Calendar.YEAR,2014);
        c.set(2021,5,18);
        System.out.println(c);

        getDay(2021);
    }

    //获取指定年份的2月有多少天
    public static int getDay(int year){
        Calendar c = Calendar.getInstance();
        c.set(year,2,1);
        c.add(Calendar.DATE,-1);
        int day = c.get(Calendar.DATE);
        System.out.println(day);
        return day;
    }
}
