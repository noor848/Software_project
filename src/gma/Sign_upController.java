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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
<<<<<<< HEAD
import others.Student;

=======
import gma.StudentCLass;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
>>>>>>> master
/**
 * FXML Controller class
 *
 * @author zaytona
 */

public class Sign_upController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
    private TextField FullName;
    @FXML 
    private TextField email; 
    @FXML 
    private PasswordField pass;
    @FXML 
    private TextField id;
    @FXML
<<<<<<< HEAD
    private RadioButton student;
=======
    private RadioButton studentButton;
>>>>>>> master
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void exitButtonOnAction(ActionEvent event) {
         int c =JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION);
    if (c == JOptionPane.YES_OPTION) {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();  
} else {
    
}
    }

<<<<<<< HEAD
    @FXML
    private void student_choosed(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        if(student.isSelected()){
          Connect c= new Connect();
       Connection con= c.connect_datbade();

        
          Student s= new   Student(FullName.getText(),email.getText(),pass.getText(),Integer.parseInt(id.getText()));
          System.out.print("helo");
            try {
                
                
                
                
                String q="INSERT INTO student (id_s,name_s,Email, password,id_maneger)\n" +
"VALUES (?,?,?,?,?)";
          PreparedStatement rs =con.prepareStatement(q);
            
            rs.setInt(1,Integer.parseInt(id.getText()));
           rs.setString(2,FullName.getText());
            rs.setString(3,email.getText());
            rs.setString(4,pass.getText());
            rs.setInt(5,4);
            rs.executeUpdate(); 
                
                
                
         
=======


    @FXML
    private void choosedStudent(ActionEvent event) throws Exception {
        
        
        if(studentButton.isSelected()){
            System.out.print("hello");
             StudentCLass c= new  StudentCLass(Integer.parseInt(id.getText()),FullName.getText(),email.getText(),pass.getText());
        
        try {
>>>>>>> master
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("signUp_studentClass.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
<<<<<<< HEAD
              
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            
            
            
            
            
            
            
            
            
            } 
catch (IOException ex) {
           
        } 
            
        
        
        
        
        }
        
        
=======
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();} 
catch (IOException ex) {
            
        } 
        
        
        
         Connect c1=new Connect();
 
       Connection con= c1.connect_datbade();
       
       
       
          String query = " insert into student(id_s,name_s,Email,password,id_maneger)"
        + " values (?,?,?,?,?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = con.prepareStatement(query);
      System.out.print(StudentCLass.id);
      preparedStmt.setInt(1,StudentCLass.id);
      preparedStmt.setString(2,StudentCLass.name);
       preparedStmt.setString(3,StudentCLass.email);
        preparedStmt.setString(4,StudentCLass.password);
         preparedStmt.setInt(5,4);
  
      preparedStmt.execute();
       
       
        
        
        
        }
>>>>>>> master
        
    }
    
}
