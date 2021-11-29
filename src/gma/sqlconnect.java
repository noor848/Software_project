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
        
        
       Connect c=new Connect();
       
       Connection con= c.connect_datbade();
       
        ObservableList<ParentSee> list = FXCollections.observableArrayList();
                try {
         PreparedStatement ps = con.prepareStatement("SELECT\n" +
"subject.name,grades.grade,student.name_s,student.id_s,class.id\n" +
"from  student\n" +
"INNER JOIN studentclass ON studentclass.student_id=student.id_s\n" +
"\n" +
"INNER JOIN class ON studentclass.class_id=class.id\n" +
"INNER JOIN  subject on subject.class_id=class.id\n" +
"INNER JOIN grades on grades.id_sub =subject.id\n" +
"\n" +
"\n" +
"");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){  
              System.out.print(rs.getString("name"));
                list.add(new ParentSee(rs.getString("name_s"),rs.getInt("grade"), rs.getInt("id_s"),rs.getString("name") ,rs.getInt("id")));               
                   }
        } catch (Exception e) {
        }
        return list;
    }
    
  
}