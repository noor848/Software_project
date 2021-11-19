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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    @FXML
    private Button signinbutt;
    @FXML 
     private Button bu1;        
    
    

    
    public static String defMail= "cc";

    public static String defPass= "22";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
            @FXML
            public void SignInAction(ActionEvent event) throws IOException {

                System.out.print("Inside sign in Action 123**" + emailTF.getText().toString()+"///"+passTF.getText().toString());
             if(emailTF.getText().toString().equals(defMail) && passTF.getText().toString().equals(defPass)){ 
                System.out.print("Inside If Tru Data");

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
                
                System.out.print("Inside sign in Exop"+ ex);
            
                    }
             }
             else{ 
              System.out.println("Inside else---");

             LabelError.setText("The Email or Password is incorrect");
             } 
        }
            


                        
           @FXML
            private void ExitAction(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
                
                
                int c =JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION);
                if (c == JOptionPane.YES_OPTION) {
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();  
                    }
                else {
    
                    }
            
            
            }
            

    
}
