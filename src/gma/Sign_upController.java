/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
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
    private RadioButton studentButton;
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



    @FXML
    private void choosedStudent(ActionEvent event) throws Exception {
        
        
        if(studentButton.isSelected()){
            System.out.print("hello");
             StudentCLass c= new  StudentCLass(Integer.parseInt(id.getText()),FullName.getText(),email.getText(),pass.getText());
        
        try {
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("signUp_studentClass.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
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
        
    }
    
}
