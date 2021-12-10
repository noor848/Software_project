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
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */



public class CompanyMainPageController implements Initializable {
    
    Stage stage;
    
    /**
     * Initializes the controller class.
     */
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void CompInfoClick(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
                
      System.out.println("insige BTN info comp");

               try {
               Stage stage = new Stage();
               Parent root = FXMLLoader.load(getClass().getResource("CompEdit.fxml"));
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Edit Comp info");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } 
            catch (IOException ex) {
                
                System.out.print("Inside sign in Exop"+ ex);
            
                    }
            
              }

        @FXML
    private void SchoolsAction(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
                
      System.out.println("insige BTN info comp");
                          try {
                  
               Stage stage = new Stage();
               Parent root;
               root = FXMLLoader.load(getClass().getResource("CompanySchoolsPage.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Schools page");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
              }
            catch (IOException ex) {
            System.out.println("From Exp***"+ex);
                    }
            
              }
            @FXML
 
            private void ExitAction(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
                
                
 try {
               Stage stage = new Stage();
               Parent root = FXMLLoader.load(getClass().getResource("CompanySignInPage.fxml"));
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Edit Comp info");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } 
            catch (IOException ex) {
                
                System.out.print("Inside sign in Exop"+ ex);
            
                    }
            }
    
            
}
