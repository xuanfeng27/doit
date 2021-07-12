package com.doit.service;

import com.doit.dao.AccountDao;
import com.doit.utils.C3P0Utils;
import com.doit.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {

    /*
        转账功能
     */
     public void transfer(String outName,String inName,double money){

         AccountDao dao = new AccountDao();

         try{

            //开启事务
             ConnectionManager.begin();

             //转出
             dao.outMoney(outName,money);

           //  int i = 1/0;
             //转入
             dao.inMoney(inName,money);


            ConnectionManager.commit();
         }catch (Exception e){

             System.out.println(e);
             ConnectionManager.rollback();



         }finally {
                ConnectionManager.close();
         }

     }
}
