package com.doit.demo02;

import com.doit.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/*
      用户输入用户名 和 密码

      使用用户输入的用户名 和密码 去user表中查询数据
      如果有数据 说明 登陆成功
      如果没有对应的数据 登陆失败

      sql注入攻击



      使用PreparedStatement防止SQL的注入攻击
        Connection
             方法
                 PreparedStatement prepareStatement(String sql)

 */
@SuppressWarnings("all")
public class Test02 {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner( System.in);
        System.out.println("请输入用户名:");
        String username = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();

        //获取连接
        Connection con = JDBCUtils.getConnection();

        //获取执行sql语句对象
        String sql = "SELECT * FROM USER WHERE username =? AND password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        //setObject(第几个?号, 要赋的值)
        ps.setObject(1,username);
        ps.setObject(2,password);


        //执行查询的sql语句
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }

        JDBCUtils.close(con,ps,rs);
    }
}
