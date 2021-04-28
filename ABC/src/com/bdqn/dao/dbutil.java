package com.bdqn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author chao
 * @create 2021-01-11 14:57
 */
public class dbutil {

    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection(){
        Connection connection=null;
        try {
             connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pet","root","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	
		}

        return  connection;
    }


}
