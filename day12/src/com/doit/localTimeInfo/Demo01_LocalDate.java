package com.doit.localTimeInfo;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/*
     JDK1.8之后

     LocalDate
     LocalTime
     LocalDateTime

 */
public class Demo01_LocalDate {
    public static void main(String[] args) {
        //获取当前日期
        LocalDate now = LocalDate.now();

        System.out.println(now);

        //获取年
        int year = now.getYear();
        System.out.println(year);

//        Month month = now.getMonth();
//        System.out.println(month);
        //获取月份
        int monthValue = now.getMonthValue();
        System.out.println(monthValue);

        //获取日
        int dayOfMonth = now.getDayOfMonth();
        System.out.println(dayOfMonth);

        System.out.println(year+"年"+monthValue+"月"+dayOfMonth+"日");


        //修改年份
//        LocalDate localDate = now.withYear(2020);
//        System.out.println(localDate);

        //获取昨天的日期
//        LocalDate localDate = now.minusDays(1);
//        System.out.println(localDate);
//
//        //上周
//        LocalDate localDate1 = now.minusWeeks(1);
//        System.out.println(localDate1);


        //获取明天的日期
//        LocalDate localDate = now.plusDays(1);
//        System.out.println(localDate);

        System.out.println("--------------------------");
        //2021/06/19   2021年06月19日
        String sdate = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(sdate);

        System.out.println("-----------------------------");
        //指定日期
        LocalDate of = LocalDate.of(2020, 1, 30);
        System.out.println(of);


    }
}
