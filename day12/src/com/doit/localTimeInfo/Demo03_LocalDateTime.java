package com.doit.localTimeInfo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Demo03_LocalDateTime {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        //可以获取时间中的 年月日 时分秒
//        int year = now.getYear();
//        System.out.println(year);
        //格式化
//        String sDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss E"));
//        System.out.println(sDate);

        //解析字符串
        LocalDateTime parse = LocalDateTime.parse("2021-06-19 17:46:43", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse);


        //转换为日期对象
//        Instant instant = now.toInstant(ZoneOffset.of("+8"));
//        Date date = Date.from(instant);
//        System.out.println(date);


        //Date转换为LocalDateTime
        Date d = new Date();
        Instant instant = d.toInstant();
        LocalDateTime localDateTime = instant.atOffset(ZoneOffset.of("+8")).toLocalDateTime();
        System.out.println(localDateTime);


    }
}
