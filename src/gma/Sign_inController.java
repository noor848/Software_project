/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Sign_inController implements Initializable {

    @FXML 
    private TextField email; 
    @FXML 
    private PasswordField pass; 
    @FXML
    private Label invalid;
    int flag=0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButt(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
       
       Connection con= Connect.connect_datbade();
        
        String email1=email.getText();
        String password1=pass.getText();
        
   
      	String q = "SELECT * FROM school_maneger";
        Statement statement=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
              ResultSet rs=statement.executeQuery(q);
          rs.absolute(0); //befor and afte first an dlast row
      while (rs.next()) {
       
                System.out.println(rs.getString(1));
       
                       
                
      }
      
      
      
      
      
      if(flag==1){
      
         try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
       
    }
      
      
      
      }
      
      else{
      
 int c1 =JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION);
    if (c1 == JOptionPane.YES_OPTION) {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();  
} else {
    
}      
      
      
      }
      
      
      
    
        
        
        
        
    }

     @FXML
private void exitButtonOnAction(ActionEvent event){

    int c =JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION);
    if (c == JOptionPane.YES_OPTION) {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();  
} else {
    
}
         }

    @FXML
    private void forgot_butt(MouseDragEvent event) {
    }

  
}
