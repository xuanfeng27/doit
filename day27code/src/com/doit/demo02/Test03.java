package com.doit.demo02;

import com.doit.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test03 {
    public static void main(String[] args) throws SQLException {
        Connection con = JDBCUtils.getConnection();

        PreparedStatement ps = con.prepareStatement("delete from user where id = ?");
        ps.setObject(1,1);

        int row = ps.executeUpdate();
        System.out.println(row);


        JDBCUtils.close(con,ps,null);
    }
}
