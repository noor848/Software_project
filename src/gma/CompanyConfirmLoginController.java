/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CompanyConfirmLoginController implements Initializable {


    @FXML
    private TextField CodeConfirm;
    
    @FXML
    private Label ErrorLabel;
    
    //The confirmCode need to be git from what the email send.. not lilke this.
    String confCode ="0000";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

            
    }   
    
        @FXML
        private void ConfirmAction(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        
            System.out.println(CodeConfirm.getText().toString());
            
              if(CodeConfirm.getText().toString().equals(confCode)){
            
              try {
                  
               Stage stage = new Stage();
               Parent root;
               root = FXMLLoader.load(getClass().getResource("CompanyMainPage.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("confirm page");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
              }
            catch (IOException ex) {
            System.out.println("From Exp***"+ex);
                    }
            
              }
              else{
              ErrorLabel.setText("Incorrect Code");
              }
        }
        
        @FXML
        private void BackAction(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
            
            // any way to retrave prv. page? 
            
                          try {
               Stage stage = new Stage();
               Parent root;
        
               root = FXMLLoader.load(getClass().getResource("CompanySignInPage.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Company Sign in Page");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } 
            catch (IOException ex){
            
                    }
            
        
        }


    
}
