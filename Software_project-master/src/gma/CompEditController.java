/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import static gma.CompanySignInPageController.*;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CompEditController implements Initializable {

    @FXML
    private TextField pass1;
    @FXML
    private TextField pass2;    
    @FXML
    private Label ErrorLabel;
   // @FXML
   // private Label email;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
        
    @FXML
    private void updateAction(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        
        if(false){
            //email.getText().toString(). isEmpty();
        ErrorLabel.setText("Email is required!");
   }
      else if(!pass1.getText().toString().equals(pass2.getText().toString()) ){
        ErrorLabel.setText("Password does not match!");
}
else{
         
        defPass =  pass1.getText();
        ErrorLabel.setText("Password has been updated!");
        //defMail= email.getText();
 } 
}
  
 @FXML
public void BackAction(ActionEvent event) throws IOException {
//        
                try {
               Stage stage = new Stage();
               Parent root;
        
               root = FXMLLoader.load(getClass().getResource("CompanyMainPage.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Main page");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
  } 
           catch (IOException ex) {
                
               System.out.print("Inside sign in Exop"+ ex);
}
}

// @FXML
//    private void BackAction(ActionEvent event) {
//   }
//    
    
}
