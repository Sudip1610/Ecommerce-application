/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecom.dbconnection;

/**
 *
 * @author hello
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author SUBHAM
 */
public class DbConnection {
    Connection con = null;
    public Connection dbConnection(){
        try {
            System.out.println("DB trying to connect...");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ecom_db","root","");
            System.out.println("DB Connected");
            
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
    public static void main(String[] args) {
        DbConnection dc = new DbConnection();
        dc.dbConnection();
    }

    Connection dbConnect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



