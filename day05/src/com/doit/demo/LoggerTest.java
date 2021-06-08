package com.doit.demo;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;

/**
 * @ClassName: LoggerTest
 * @Author: zll
 * @CreateTime: 2021/6/8 20:46
 * @Desc: java 程序
 * @Version: 1.0
 */
public class LoggerTest {

    public static void main(String[] args) throws IOException {
        int a =10;
        String[] str =new String[5];
        Logger log = Logger.getLogger("LoggerTest");
        // all→finest→finer→fine→config→info→warning→server→off
        // 级别依次升高，后面的日志级别会屏蔽之前的级别
        log.setLevel(Level.INFO);
        log.finest("finest");
        log.finer("finer");
        log.fine("fine");
        log.config("config");
        log.info("info");
        log.warning("warning");
        log.severe("server");
        //控制台控制器
        ConsoleHandler consoleHandler =new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        log.addHandler(consoleHandler);
        //文件控制器
        FileHandler fileHandler = new FileHandler("D:/testDir/8888g.log");
        fileHandler.setLevel(Level.INFO);
        log.addHandler(fileHandler);

        log.info(String.valueOf(a));
        log.info(Arrays.toString(str));
    }
}






