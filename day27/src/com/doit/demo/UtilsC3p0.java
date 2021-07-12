package com.doit.demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.*;

/**
 * @ClassName: UtilsCp30
 * @Author: zll
 * @CreateTime: 2021/7/12 9:50
 * @Desc: java 程序
 * @Version: 1.0
 */
public class UtilsC3p0 {
    private static ComboPooledDataSource ds;

    private UtilsC3p0() { }

    static {
        try {
            init();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void init() throws PropertyVetoException {
        try {
            ds = new ComboPooledDataSource();
            //配置连接池信息， 使用xml文件自动配置，放在src下
           /* ds.setDriverClass(className);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(password);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection con = ds.getConnection();
        return con;
    }

    public static void close(Connection con, Statement stmt, ResultSet rs){
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
