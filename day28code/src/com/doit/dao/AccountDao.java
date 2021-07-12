package com.doit.dao;

import com.doit.utils.C3P0Utils;
import com.doit.utils.ConnectionManager;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDao {


    //减钱
    public void outMoney(String outName, double outMoney) throws PropertyVetoException, SQLException {

        Connection con = ConnectionManager.getConnection();
        String sql = "update account set balance = balance - ? where name = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setObject(1,outMoney);
        ps.setObject(2,outName);

        ps.executeUpdate();



    }


    //加钱
    public void inMoney(String inName, double inMoney) throws PropertyVetoException, SQLException {

        Connection con = ConnectionManager.getConnection();
        String sql = "update account set balance = balance + ? where name = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setObject(1,inMoney);
        ps.setObject(2,inName);

        ps.executeUpdate();


    }
}
