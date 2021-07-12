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
 * @Desc: java ����
 * @Version: 1.0
 */

/* ��������
        1. ע������.
        2. �������.
        3. ���ִ��sql���Ķ���
        4. ִ��sql��䣬�����ؽ��
        5. ������
        6. �ͷ���Դ.
* DriverManager:����ע������
* Connection: ��ʾ�����ݿⴴ��������
* Statement: �������ݿ�sql���Ķ���
* ResultSet: �������һ�������
*/
//���ص�ַ:  https://dev.mysql.com/downloads/connector/j/
public class TestJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        //System.out.println("select * from category WHERE cid='' AND cid='" +     "aaa' OR 'a'='a"    +"'");
        //testSqlLogin2();
        //methodUtil();

    }

    @Test
    public void method() throws ClassNotFoundException, SQLException {
        //Driver driver = new Driver();new����ע��ֻΪִ�о�̬�����,ʹ�÷������
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/day03";
        String user = "root";
        String password = "daydayup";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        //��ѯ
        ResultSet resultSet = statement.executeQuery("select * from category limit 0,3");
        while (resultSet.next()){
            Object cid = resultSet.getObject("cid");
            String cname = resultSet.getString("cname");
            System.out.println(cid + "  "+ cname);
        }
        //cud
        int i = statement.executeUpdate("delete from category where cid>5");
        System.out.println(i);//��ɾ��������

        //�ر���Դ
        resultSet.close();
        statement.close();
        connection.close();
    }

    // ���� xxx'  OR 'a'='a
    public static void testSqlLogin() throws ClassNotFoundException, SQLException {
        System.out.println("testSqlLogin");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/day03";
        String user = "root";
        String password = "daydayup";

        Scanner sc = new Scanner(System.in);
        System.out.println("������name");
        String username = sc.nextLine();
        System.out.println("������psword");
        String psword = sc.nextLine();

        Connection con = DriverManager.getConnection(url, user, password);
        Statement stat = con.createStatement();
        //��ѯ
        String strSql = "select * from category WHERE cname='" + "xxx'  OR 1='1" + username + "' AND cid='" + psword +"'";
        ResultSet resultSet = stat.executeQuery(strSql);
        System.out.println(resultSet.next());

        //�ر���Դ
        resultSet.close();
        stat.close();
        con.close();
        sc.close();
    }

    //�Ƽ�д�� ����ֹSQLע��
    @Test
    public void getJDBC() throws ClassNotFoundException, SQLException {
        System.out.println("getJDBC");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/day03";
        String user = "root";
        String password = "daydayup";
        Connection connection = DriverManager.getConnection(url,user,password);
        //��ѯ
        PreparedStatement preparedStatement = connection.prepareStatement("select * from category limit 0,2");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Object cid = resultSet.getObject("cid");
            String cname = resultSet.getString("cname");
            System.out.println(cid + "  "+ cname);
        }
        //cud
        int i = connection.prepareStatement("delete from category where cid>5").executeUpdate();
        System.out.println(i);//��ɾ��������

        //�ر���Դ
        resultSet.close();
        connection.close();
    }

    //��ֹSQLע�� ���� xxx'  OR 'a'='a
    public static void testSqlLogin2() throws ClassNotFoundException, SQLException {
        System.out.println("testSqlLogin2");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/day03";
        String user = "root";
        String password = "daydayup";

        Scanner sc = new Scanner(System.in);
        System.out.println("������name");
        String username = sc.nextLine();
        System.out.println("������psword");
        String psword = sc.nextLine();

        String strSql = "select * from category WHERE cname=? AND cid=?";

        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = con.prepareStatement(strSql);
        ps.setString(1,username);
        ps.setString(2, psword);
        //��ѯ
        ResultSet rs = ps.executeQuery();
        System.out.println(rs.next());

        //�ر���Դ
        rs.close();
        ps.close();
        con.close();
        sc.close();
    }

    //ʹ�������ļ�properties
    public static void methodUtil() throws ClassNotFoundException, IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("������cname");
        String cname = sc.nextLine();
        System.out.println("������cid");
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

    //ʹ��UtilsJdbc
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
