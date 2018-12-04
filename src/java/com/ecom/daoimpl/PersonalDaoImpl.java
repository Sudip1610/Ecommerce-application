/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecom.daoimpl;

import com.ecom.dbconnection.DbConnection;
import com.ecom.vo.PersonalVO;
import com.ecom.vo.ResultVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hello
 */
public class PersonalDaoImpl {
    
    Connection con = null;
    PreparedStatement ps= null;
    DbConnection dc = new DbConnection();
    ResultVO  rvo = new ResultVO();
    Statement st = null;
    ResultSet rs = null;
    
    public ResultVO dataInsert(PersonalVO pvo){
        String name=pvo.getName();
        String pass=pvo.getPass();
        try
        {
            con=dc.dbConnection();
            String insertQuery="insert into bca values(DEFAULT,?,?)";
            ps=con.prepareStatement(insertQuery);
            ps.setString(1, name);
            ps.setString(2, pass);
            int i=ps.executeUpdate();
            if(i>0)
                System.out.println("data inserted");
            else
                System.out.println("failed");
        }
        catch(Exception e){
            e.printStackTrace();
                }
        return rvo;
    }

    public boolean userLogin(String name, String pass) throws SQLException {
        boolean status=false;
        try
        {
             
         con=dc.dbConnection();
        st=con.createStatement();
        String sql ="SELECT *FROM bca WHERE name=? and pass=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,name);  
        ps.setString(2,pass);  
      
        rs=ps.executeQuery();  
        status=rs.next();
    }        
         catch(Exception e){
            e.printStackTrace();
                }
    return status;
}
}

    

