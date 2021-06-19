package com.doit.localTimeInfo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Demo02_LocalTime {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);


//        String format = now.format(DateTimeFormatter.ofPattern("时:HH  分:mm   秒:ss"));
//        System.out.println(format);


        //将字符串转换为 LocalTime
        LocalTime parse = LocalTime.parse("17:41:48", DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(parse);

    }
}
