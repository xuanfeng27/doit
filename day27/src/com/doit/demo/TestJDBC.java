package com.doit.demo;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @ClassName: TestJDBC
 * @Author: zll
 * @CreateTime: 2021/7/11 17:00
 * @Desc: java 程序
 * @Version: 1.0
 */

/* 开发步骤
        1. 注册驱动.
        2. 获得连接.
        3. 获得执行sql语句的对象
        4. 执行sql语句，并返回结果
        5. 处理结果
        6. 释放资源.
* DriverManager:用于注册驱动
* Connection: 表示与数据库创建的连接
* Statement: 操作数据库sql语句的对象
* ResultSet: 结果集或一张虚拟表
*/
//下载地址:  https://dev.mysql.com/downloads/connector/j/
public class TestJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        //System.out.println("select * from category WHERE cid='' AND cid='" +     "aaa' OR 'a'='a"    +"'");
        //testSqlLogin2();
        //methodUtil();

    }

    @Test
    public void method() throws ClassNotFoundException, SQLException {
        //Driver driver = new Driver();new对象注册只为执行静态代码块,使用反射最好
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/day03";
        String user = "root";
        String password = "daydayup";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        //查询
        ResultSet resultSet = statement.executeQuery("select * from category limit 0,3");
        while (resultSet.next()){
            Object cid = resultSet.getObject("cid");
            String cname = resultSet.getString("cname");
            System.out.println(cid + "  "+ cname);
        }
        //cud
        int i = statement.executeUpdate("delete from category where cid>5");
        System.out.println(i);//被删除的行数

        //关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }

    // 测试 xxx'  OR 'a'='a
    public static void testSqlLogin() throws ClassNotFoundException, SQLException {
        System.out.println("testSqlLogin");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/day03";
        String user = "root";
        String password = "daydayup";

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入name");
        String username = sc.nextLine();
        System.out.println("请输入psword");
        String psword = sc.nextLine();

        Connection con = DriverManager.getConnection(url, user, password);
        Statement stat = con.createStatement();
        //查询
        String strSql = "select * from category WHERE cname='" + "xxx'  OR 1='1" + username + "' AND cid='" + psword +"'";
        ResultSet resultSet = stat.executeQuery(strSql);
        System.out.println(resultSet.next());

        //关闭资源
        resultSet.close();
        stat.close();
        con.close();
        sc.close();
    }

    //推荐写法 ，防止SQL注入
    @Test
    public void getJDBC() throws ClassNotFoundException, SQLException {
        System.out.println("getJDBC");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/day03";
        String user = "root";
        String password = "daydayup";
        Connection connection = DriverManager.getConnection(url,user,password);
        //查询
        PreparedStatement preparedStatement = connection.prepareStatement("select * from category limit 0,2");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Object cid = resultSet.getObject("cid");
            String cname = resultSet.getString("cname");
            System.out.println(cid + "  "+ cname);
        }
        //cud
        int i = connection.prepareStatement("delete from category where cid>5").executeUpdate();
        System.out.println(i);//被删除的行数

        //关闭资源
        resultSet.close();
        connection.close();
    }

    //防止SQL注入 测试 xxx'  OR 'a'='a
    public static void testSqlLogin2() throws ClassNotFoundException, SQLException {
        System.out.println("testSqlLogin2");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/day03";
        String user = "root";
        String password = "daydayup";

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入name");
        String username = sc.nextLine();
        System.out.println("请输入psword");
        String psword = sc.nextLine();

        String strSql = "select * from category WHERE cname=? AND cid=?";

        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = con.prepareStatement(strSql);
        ps.setString(1,username);
        ps.setString(2, psword);
        //查询
        ResultSet rs = ps.executeQuery();
        System.out.println(rs.next());

        //关闭资源
        rs.close();
        ps.close();
        con.close();
        sc.close();
    }

    //使用配置文件properties
    public static void methodUtil() throws ClassNotFoundException, IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入cname");
        String cname = sc.nextLine();
        System.out.println("请输入cid");
        String cid = sc.nextLine();

        Properties props = new Properties();
        InputStream in = TestJDBC.class.getClassLoader().getResourceAsStream("jdbc.properties");
        props.load(in);
        in.close();

        String className = props.getProperty("className");
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        Class.forName(className);
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "select * from category WHERE cname=? AND cid=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cname);
        ps.setString(2, cid);

        ResultSet rs = ps.executeQuery();
        System.out.println(ps.toString());
        //com.mysql.jdbc.JDBC42PreparedStatement@6d5380c2: select * from category WHERE cname='aa' AND cid='aaa\' or \'a\'=a'
        if (rs.next()){
            System.out.println("success");
        }else {
            System.out.println("fail");
        }

        rs.close();
        ps.close();
        con.close();
    }

    //使用UtilsJdbc
    public static void methodTestUtils() throws SQLException {
        String sql = "select * from category ";
        Connection con = UtilsJdbc.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String cid = rs.getString("cid");
            String cname = rs.getString("cname");
            System.out.println(cid + "  "+cname);
        }

        UtilsJdbc.close(con,ps,rs);
    }


}
