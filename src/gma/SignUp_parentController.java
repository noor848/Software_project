/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class SignUp_parentController implements Initializable {

    @FXML
    private TextField phone;

    /**
     * Initializes the controller class.
     */
    static String s ="";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButt(ActionEvent event) throws IOException { 
         Stage stage = new Stage();
               
                Parent root = FXMLLoader.load(getClass().getResource("schoolPage.fxml"));
        //String css = GMA.class.getResource("mystyle.css").toExternalForm();
       /// scene.getStylesheets().add(css);

      Scene scene = new Scene(root);  
                scene.setFill(Color.TRANSPARENT);
               stage.setScene(scene);
                 stage.initStyle(StageStyle.TRANSPARENT);
               stage.setTitle("Welcome to GMA");
                ((Node)(event.getSource())).getScene().getWindow().hide();
               stage.show();
               
    }
    @FXML
    private void Add (ActionEvent event) throws Exception{
        
      
         Connect c1=new Connect();
 
       Connection con= c1.connect_datbade();
       
       
       
          String query = " insert into parent(id_p,phone,name,password,Email,id_parent)"
        + " values (?,?,?,?,?,?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = con.prepareStatement(query);
      System.out.print(parent_phone.id);
      preparedStmt.setInt(1,parent_phone.id);
      preparedStmt.setString(2,phone.getText());
      preparedStmt.setString(3,parent_phone.name);
      System.out.print(parent_phone.name);
       preparedStmt.setString(4,parent_phone.password);
       preparedStmt.setString(5,parent_phone.email);
       preparedStmt.setInt(6,4);
      preparedStmt.execute();
       JOptionPane.showMessageDialog(null, "Parent Added");
       
     
    }
    

}