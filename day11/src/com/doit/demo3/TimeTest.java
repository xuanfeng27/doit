package com.doit.demo3;

import java.time.*;//Java8新日期时间API
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;


/**
 * @ClassName: TimeTest
 * @Author: zll
 * @CreateTime: 2021/6/19 11:05
 * @Desc: java 程序
 * @Version: 1.0
 */
public class TimeTest {
    public static void main(String[] args) {
        System.out.println( LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd E HH:mm:ss")));
        System.out.println(Instant.now().toEpochMilli());//返回1970-01-01 00:00:00到当前时间的毫秒数，即为时间戳

        // TemporalAdjuster:时间校正器
        // 获取当前日期的下一个周日是哪天？
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.SUNDAY);
        LocalDateTime localDateTime = LocalDateTime.now().with(temporalAdjuster);
        System.out.println(localDateTime);
        // 获取下一个工作日是哪天？
        LocalDate localDate = LocalDate.now().with(new TemporalAdjuster() {
            @Override
            public Temporal adjustInto(Temporal temporal) {
                LocalDate date = (LocalDate) temporal;//强制转换downcasting
                if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                    return date.plusDays(3);
                } else if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                    return date.plusDays(2);
                } else {
                    return date.plusDays(1);
                }
            }
        });
        System.out.println("下一个工作日是：" + localDate);
    }

}
