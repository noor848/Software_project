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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButt(ActionEvent event) {
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
