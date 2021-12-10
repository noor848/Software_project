/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Noor
 */
public class Connect {
    
    Connection conn = null;

    Connect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
    public   Connection connect_datbade() throws Exception{
                Class.forName("com.mysql.jdbc.Driver");
                

   
      

    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gma","root","");


    // Do something with the Connection
    System.out.println("connected to database");
    
  
    return conn;

    
    
    
  
   
}
    
    }

    
    
    

