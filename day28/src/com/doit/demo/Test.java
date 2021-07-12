package com.doit.demo;

import com.doit.utils.C3P0Utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
      查询user表中 所有数据
      将查询到的每条记录的信息 封装到一个User对象中
      将User对象 放入到一个集合中
 */
public class Test {
    public static void main(String[] args) throws PropertyVetoException, SQLException {

        //使用工具类 从连接池中获取到连接对象
        Connection con = C3P0Utils.getConnection();

        //获取执行sql语句的对象
        String sql = "select * from user";
        PreparedStatement ps = con.prepareStatement(sql);

        //执行sql语句 获取到结果集
        ResultSet rs = ps.executeQuery();

        List<User> list = new ArrayList<>();

        while(rs.next()){
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");

            User u = new User();
            u.setId(id);
            u.setUsername(username);
            u.setPassword(password);
            list.add(u);
        }
        System.out.println(list);



        C3P0Utils.close(con,ps,rs);

    }
}
