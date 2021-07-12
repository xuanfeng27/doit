package com.doit.demoC3p0;

import com.doit.demo.UtilsC3p0;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: DemoMoney
 * @Author: zll
 * @CreateTime: 2021/7/12 15:35
 * @Desc: java ����
 * @Version: 1.0
 */
public class DemoService {
    public static void main(String[] args) {

        try {
            //��������
            ConManger.begin();

            DemoDao.deMoney();
            //int a = 1/0;
            DemoDao.addMoney();

            //�ύ����
           ConManger.commit();

        }catch (Exception e) {
            System.out.println(e);
            ConManger.rollback();
        }finally {
            ConManger.close();
        }
    }
}
