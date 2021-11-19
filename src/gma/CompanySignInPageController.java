/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
public class CompanySignInPageController implements Initializable {

    @FXML
    private TextField emailTF;
    @FXML
    private TextField passTF;
    @FXML
    private Label LabelError;

    
    String defMail= "comp@gmail.com";
    String defPass= "Comp123456";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
            @FXML
            private void SignInAction(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
            
             if(emailTF.getText().equals(defMail) && passTF.getText().equals(defPass)){ 
                 
                 // Send email with code
                 
            try {
               Stage stage = new Stage();
               Parent root;
        
               root = FXMLLoader.load(getClass().getResource("CompanyConfirmLogin.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("confirm page");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } 
            catch (IOException ex) {
            
                    }
             }
             else{
                 
             LabelError.setText("The Email or Password is incorrect");

             } 
        }
            

    
}
