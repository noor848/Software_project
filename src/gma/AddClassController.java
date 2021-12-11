/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ayaha
 */
public class AddClassController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField classN;

    @FXML
    void addClass(MouseEvent event) {
       int id = 1;
   try{
    Connect c=new Connect();
        Connection con= c.connect_datbade();
        String name = classN.getText();
        String q = "SELECT * FROM class where 1";
        
        Statement statement=con.createStatement( );
              ResultSet rs=statement.executeQuery(q);
              while (rs.next()) {
                  id=rs.getInt("id");
                  ++id;
              }
     String add = "INSERT INTO class(`name`, `id`) VALUES ('"+name+"','"+id+"')";
     java.sql.Statement statement2=con.createStatement( );
        statement2.executeUpdate(add); 
         JOptionPane.showMessageDialog(null, "Add SUCCESSFULLY");
        
    
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(ActionEvent event) {
        
            try {
                Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Admin profile");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();} 
catch (IOException ex) {
            
        }
        
    }
    
}
