package com.doit.demoC3p0;

import com.doit.demo.UtilsC3p0;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName: ConManger
 * @Author: zll
 * @CreateTime: 2021/7/12 15:21
 * @Desc: java ³ÌÐò
 * @Version: 1.0
 */

public class ConManger {
    private static ThreadLocal<Connection> t = new ThreadLocal<>();

    public static Connection getConnection() throws SQLException {
        Connection con=t.get();
        if (con == null) {
            con = UtilsC3p0.getConnection();
            t.set(con);
        }
        return con;
    }

    public static void begin() {
        try {
            ConManger.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit()  {
        try {
            ConManger.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback()  {
        try {
            ConManger.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close()  {
        try {
            ConManger.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
