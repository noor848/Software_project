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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Stu_Or_Tea_Or_ParController implements Initializable {

    @FXML
    private TextArea textArea;

    @FXML
     
    void add_AnnArea(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
        Connect c=new Connect();
        ResultSet rs = null;
        try{
       Connection con= c.connect_datbade();
      Statement st = con.createStatement();
     String query = "SELECT * FROM advertisment ORDER BY id DESC LIMIT 3";
   //  String query ="SELECT * FROM\n" +
//"   (SELECT * FROM advertisment ORDER BY id DESC LIMIT 3) z" +
//"ORDER BY z.id;" ;
//"LIMIT 3;";
       rs = st.executeQuery(query);
       while (rs.next()) {
      //rs.getString("content")
      String ann3 = rs.getString("content");
      
         // textArea.setText(fname);
          String query2 = "SELECT * FROM advertisment ORDER BY id DESC LIMIT 2";
          rs = st.executeQuery(query2);
           while (rs.next()){
               String ann2 = rs.getString("content");
      
         textArea.setText(ann2+"\n"+ann3);
          
          ///////
        /*  String query3 = "SELECT * FROM advertisment ORDER BY id DESC LIMIT 1";
          rs = st.executeQuery(query3);
         
               String ann1 = rs.getString("content");
      
          textArea.setText(ann1+"\n"+ann2+"\n"+ann3);*/
          
          
          
           }
           
           
          // }
          
         // System.out.println(rs.getString());
           // String lname = rs.getString("LastName");
           // System.out.println("FirstName:" + fname);
           // System.out.println("LastName:" + lname);
         }
       
        }
        catch (Exception e) {
       System.out.println("wrong");
        }
    }
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
}
