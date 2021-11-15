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
    private TextField title;
    
    @FXML 
    private TextField phone;
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
    
}
