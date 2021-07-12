package com.doit.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TestCp30
 * @Author: zll
 * @CreateTime: 2021/7/12 9:50
 * @Desc: java ³ÌÐò
 * @Version: 1.0
 */
public class TestC3p0 {
    public static void main(String[] args) throws SQLException {
        Connection con = UtilsC3p0.getConnection();
        String sql = "select * from  category";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<User> list = new ArrayList<>();

        while (rs.next()){
            String cid = rs.getString("cid");
            String cname = rs.getString("cname");
            User user = new User();
            user.setCid(cid);
            user.setCname(cname);
            list.add(user);
        }

        System.out.println(list);
        UtilsC3p0.close(con,ps,rs);
    }
}
