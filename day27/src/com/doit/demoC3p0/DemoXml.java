package com.doit.demoC3p0;


import com.doit.demo.UtilsC3p0;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: DemoXml
 * @Author: zll
 * @CreateTime: 2021/7/12 10:44
 * @Desc: java 程序
 * @Version: 1.0
 */
public class DemoXml {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt = null;
        try {
            con = UtilsC3p0.getConnection();
            //开启事务
            con.setAutoCommit(false);

            stmt = con.createStatement();

            String sql = "update account set balance=balance-5000 where id=1";
            int i = stmt.executeUpdate(sql);
            //int a = i/0;
            String sql2 = "update account set balance=balance+5000 where id=2";
            int j = stmt.executeUpdate(sql2);

            if (i == 1 && j == 1) {
                System.out.println("转账成功");
            }
            //提交事务
            con.commit();

        }catch (Exception e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }finally {
            UtilsC3p0.close(con,stmt,null);
        }
    }
}
