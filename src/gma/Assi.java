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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class Assi implements Initializable {

    @FXML
    private AnchorPane AnchorPane;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
         @FXML
        private void AddGrade(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        
               try {
               Stage stage = new Stage();
               Parent root = FXMLLoader.load(getClass().getResource("grades.fxml"));
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Grades Page");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } 
            catch (IOException ex) {
                
                System.out.print("Inside Ass.."+ ex);
            
                    }
            
        }
            
    
    
}
