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
  
    
    public  static Connection connect_datbade() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                

    conn = DriverManager.getConnection("jdbc:mysql://localhost/phpmyadmin/index.php?route=/database/structure&server=1&db=gma","root","");
    // Do something with the Connection
    System.out.println("connected to database");
    
  
    return conn;
    
    
    
}
    
    }
    
    
    
    
    
}
