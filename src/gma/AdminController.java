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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class AdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logout(ActionEvent event) throws IOException {
        
         Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("schoolPage.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();} 

    @FXML
    private void chang_pass(ActionEvent event) throws IOException {
          Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("Admin_pass.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        
    }

    @FXML
    private void add_announce(ActionEvent event) throws IOException {
        
            Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("Add_Ann.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide(); 
        
        
        
    }

    @FXML
    private void add_class(ActionEvent event) throws IOException {
        
        
             Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("AddClass.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        
    }

    @FXML
    private void add_sub(ActionEvent event) throws IOException {
        
             Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("AddSubjectNew.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
        
        
    }
    }
    
