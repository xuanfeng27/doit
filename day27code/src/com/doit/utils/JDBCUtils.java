package com.doit.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String url;
    private static String username;
    private static String password;
    private static String className;

    private JDBCUtils() {
    }


    static {
        try {

            //对成员变量初始化值
            init();

            //注册驱动
            Class.forName(className);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public static void init() throws IOException {
        Properties p = new Properties();
        //当前类名.class.getClassLoader.getResourceAsStream("文件名");
        InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");
        p.load(in);
        in.close();

        className = p.getProperty("driverClassName");
        url = p.getProperty("url");
        username = p.getProperty("username");
        password = p.getProperty("password");
    }


    public static Connection getConnection() throws SQLException {

        Connection con = DriverManager.getConnection(url, username, password);
        return con;

    }


    public static void close(Connection con, Statement stat, ResultSet rs) {
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (stat != null)
                stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
