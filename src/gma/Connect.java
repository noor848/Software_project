/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Noor
 */
public class Connect {
    
    Connection conn = null;
  
    
    public void connect_datbade() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                
try {
    conn =
       DriverManager.getConnection("jdbc:mysql://localhost:3306/gma?zeroDateTimeBehavior=convertToNull", "root", "");

    // Do something with the Connection

   
} catch (SQLException ex) {
    // handle any errors
  
    System.out.println("not connected");
}
    
    
    }
    
}
