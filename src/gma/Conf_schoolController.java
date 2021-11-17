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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Conf_schoolController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private Label invalid;
    @FXML
    private TextField email1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void forgot_butt(MouseDragEvent event) {
    }

    @FXML
    private void loginButt(ActionEvent event) {
    }

    @FXML
    private void back_butt(ActionEvent event) {
    }
    
}
