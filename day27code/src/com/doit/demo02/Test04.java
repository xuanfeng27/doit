package com.doit.demo02;

import com.doit.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class Test04 {
    public static void main(String[] args) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        System.out.println(con);
    }
}
