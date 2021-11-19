/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.SQLException;
=======
>>>>>>> master
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import others.Student;


/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class SignUp_studentClassController implements Initializable {

    @FXML
<<<<<<< HEAD
    private TextField email;
=======
    private TextField idc;
>>>>>>> master

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     
<<<<<<< HEAD
   

    @FXML
    private void Add(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
             Connect c= new Connect();
       Connection con= c.connect_datbade();

                String q="INSERT INTO studentclass (student_id,class_id)\n" +
"VALUES (?,?)";
          PreparedStatement rs =con.prepareStatement(q);
            
            rs.setInt(1,Student.id);
             rs.setInt(2,Integer.parseInt(email.getText()));
            rs.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "Added Successfuly ");
                    
                
=======
     @FXML
    private void Add (ActionEvent event) throws Exception{
        
      
       
       Connect c=new Connect();
 
       Connection con= c.connect_datbade();
       
     
         String query1 = " insert into studentclass(student_id,class_id)"
        + " values (?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt2 = con.prepareStatement(query1);
      System.out.print(StudentCLass.id);
      preparedStmt2.setInt(1,StudentCLass.id);
      preparedStmt2.setInt(2,Integer.parseInt(idc.getText()));
  
      preparedStmt2.execute();
      
      
      
      
      
      
        
>>>>>>> master
        
        
        
    }

    @FXML
    private void back(ActionEvent event) {
        
        
             try {
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("schoolPage.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
              
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();} 
catch (IOException ex) {
           
        } 
    }
}
