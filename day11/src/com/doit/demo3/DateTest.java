package com.doit.demo3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName: DateTest
 * @Author: zll
 * @CreateTime: 2021/6/18 9:48
 * @Desc: java 程序
 * @Version: 1.0
 */
//java.util.Date 构造方法：public Date()当前日期对象; public Date(long date)指定毫秒的日期对象
//时间原点1970-01-01 00：00：00 毫秒 1s = 1000ms;
//方法:long getTime()获取毫秒值;setTime(long time)设置毫秒值
//java.text.DateFormat抽象类其子类SimpleDateFormat  Date---> String 方法：String format(Date date)
//构造方法：public SimpleDateFormat();public SimpleDateFormat(String pattern);
//y---年 M---月 d---日  H---时  m---分 s----秒  E----星期
public class DateTest {
    public static void main(String[] args) throws ParseException {
        Date now = new Date();
        System.out.println(now);
        Date d = new Date(1000L*60*60*24*365*51);
        System.out.println(d);

        long t = now.getTime();
        System.out.println(t);
        now.setTime(0);
        System.out.println(now);//东八区 玩8h
        now.setTime(1000L*60*60*24*365*51);
        System.out.println(now);

        //DateFormat
        //Date--->String
        //y---年 M---月 d---日  H---时  m---分 s----秒  E----星期
        Date now1 = new Date();
        DateFormat df2 = new SimpleDateFormat();
        System.out.println(df2.format(now1));//空参构造 默认格式: 21-6-18 上午10:56
        //多态upcasting 带参构造
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");//2021年06月18日 10:56:32 星期五
        String str = df.format(now1);
        System.out.println(str);

        //String---->Date
        //Date parse(String str)
        String str1 = "1945-03-22";
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = df1.parse(str1);
        long time1 = d1.getTime();
        System.out.println(time1);

        countLiveDay("");
    }

    //计算一个人活了多少天？
    public static String countLiveDay(String str) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入生日（yyyy-MM-dd）：");
        String st = sc.nextLine();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(st);
        long time = d.getTime();
        Date d1 = new Date();
        long time1 = d1.getTime();
        long time2 = time1 - time;
        long day = time2/(1000*60*60*24L);
        System.out.println(day);
        return day+"天";
    }

}
