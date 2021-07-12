package com.doit.demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName: UtilsJdbc
 * @Author: zll
 * @CreateTime: 2021/7/12 8:59
 * @Desc: java ³ÌÐò
 * @Version: 1.0
 */
public class UtilsJdbc {
   static String className;
   static String url;
   static String user;
   static String password;

    private UtilsJdbc() { }

    static {
        init();
    }

    public static void init() {
        Properties props = new Properties();
        InputStream in = TestJDBC.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        className = props.getProperty("className");
        url = props.getProperty("url");
        user = props.getProperty("user");
        password = props.getProperty("password");
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }

    public static void close(Connection con, Statement stmt, ResultSet rs){
        try {
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
