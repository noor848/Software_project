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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Stu_Or_Tea_Or_ParController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private void school(ActionEvent event) throws Exception {
        Stage stage = new Stage();
               Parent root;
        
               root = FXMLLoader.load(getClass().getResource("conf_school.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Welcome to GMA");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    private void teacher(ActionEvent event) throws Exception {
        Stage stage = new Stage();
               Parent root;
        
               root = FXMLLoader.load(getClass().getResource("Teacher_sign_in.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Welcome to GMA");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
    }
      @FXML
    private void parent(ActionEvent event) throws Exception {
        Stage stage = new Stage();
               Parent root;
        
               root = FXMLLoader.load(getClass().getResource("parent_sign_in.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Welcome to GMA");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
    }
      @FXML
private void exitButtonOnAction(ActionEvent event){

    int c =JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION);
    if (c == JOptionPane.YES_OPTION) {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();  
} else {
    
}
         }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
}
