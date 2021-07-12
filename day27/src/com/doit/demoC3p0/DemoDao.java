package com.doit.demoC3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: DemoDao
 * @Author: zll
 * @CreateTime: 2021/7/12 15:44
 * @Desc: java ³ÌÐò
 * @Version: 1.0
 */
public class DemoDao {

    public static void deMoney() throws SQLException {
        Connection con = ConManger.getConnection();
        String sql = "update account set balance=balance-? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "5000");
        ps.setString(2, "1");
        ps.executeUpdate();
        ps.close();
    }

    public static void addMoney() throws SQLException {
        Connection con = ConManger.getConnection();
        String sql = "update account set balance=balance+? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "5000");
        ps.setString(2, "2");
        ps.executeUpdate();
        ps.close();
    }
}
