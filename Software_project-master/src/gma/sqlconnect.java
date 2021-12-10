/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class sqlconnect {
    
 Connection conn = null;
  

    
    public   Connection connect_datbade() throws Exception{
                Class.forName("com.mysql.jdbc.Driver");
                

   
      

    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gma","root","");


    // Do something with the Connection
    System.out.println("connected to database 11111");
    
  
    return conn;

    
    
    
  
   
}
      
    public static ObservableList<ParentSee> getData() throws ClassNotFoundException, SQLException, Exception{
        
      
       
        ObservableList<ParentSee> list = FXCollections.observableArrayList();

        return list;
    }
    
  
}