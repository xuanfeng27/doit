package com.doit.demo02;

import com.doit.utils.C3P0Utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/*
     转账基本案例 发现问题

          如果当 一个人 转出了钱  然后  抛出异常   另一个人并没有 收到钱  钱丢失了

          如何解决
            应该将转出钱 和  收钱 这两个操作 看做成一个整体 要么完全成功 要么 完全实现  不应该一个成功 一个失败
     事务
        事务指的是逻辑上的一组操作,组成这组操作的各个单元要么全都成功,要么全都失败.
        事务作用：保证在一个事务中多次SQL操作要么全都成功,要么全都失败.
        一组操作:一个连接下的多次操作

        事务的动作
             1. 开启事务
                   事务开启后 下面的所有操作(未提交之前) 都属于我当前事务
             2. 提交事务
                   将数据永久性保存到数据库中
             3. 回滚
                   将数据恢复到开启事务之前的状态  数据永久保存


         try{
            开启事务
             转出

             转入

            提交事务
         }catch(){

             回滚

         }


         java.sql.Connection
               方法
               开启事务
                  setAutoCommit(boolean b )  实际上 mysql可以自动提交事务 只不过mysql的自动提交事务 针对的是一条语句
                                             boolean b 默认值是true  代表着mysql的自动事务
                                             我们要想手动事务 针对多条语句 需要讲 b的值设置为 false
                                             关闭自动事务 开启手动事务
               提交事务
                   commit();

               回滚
                   rollback();


 */
public class Test {
    public static void main(String[] args)  {

        Connection con = null;
        Statement stat = null;
        try{
             con = C3P0Utils.getConnection();

             //开启事务
            con.setAutoCommit(false);

             stat = con.createStatement();

            String sql = "update account set balance = balance - 5000 where id = 1";
            int i = stat.executeUpdate(sql);

            int a = 1/0;

            sql = "update account set balance = balance  + 5000 where id = 2";
            int j = stat.executeUpdate(sql);

            if(i ==1 && j == 1){
                System.out.println("转账成功");
            }

            //提交事务
            con.commit();

        }catch (Exception e){

            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }finally {
            C3P0Utils.close(con,stat,null);
        }



    }
}
