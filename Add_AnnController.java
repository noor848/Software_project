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
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Add_AnnController implements Initializable {
    

    /**
     * Initializes the controller class.
     * 
     */
    @FXML
    private TextField email;

    @FXML
    private Button Add_ann;

    @FXML
    private Label invalid;

    @FXML
    private TextArea text_area;


    @FXML
    void back_butt(ActionEvent event) throws IOException{
        Stage stage = new Stage();
               Parent root;
        
            root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();}

    

    @FXML
    void forgot_butt(MouseDragEvent event) {

    }

    @FXML
    void loginButt(ActionEvent event) {

    }
   Connection conn = null;
   ResultSet rs =null;
   
   public  int ID ;
  
   public void Add_ann (ActionEvent event) throws Exception{
      // conn =Connect.connect_datbade();
      Connect c1=new Connect();
     // PreparedStatement pst=null;
     
 
 
       Connection con= c1.connect_datbade();
       String q0="SELECT * FROM advertisment where 1";
     Statement statement0 = con.createStatement();
     ResultSet rs0=statement0.executeQuery(q0);
     while(rs0.next()){
         ID=rs0.getInt("id");
         ++ID;
     }
       
       String sql= " insert into advertisment(name,id,date,content,id_maneger)"
        + " values (?,?,?,?,?)";
       
       try{
           PreparedStatement pst=con.prepareStatement(sql);
          // pst =con.prepareStatement(sql);
           pst.setString(1,email.getText() );
           pst.setInt(2,ID);

    

           
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
    pst.setString(3,dtf.format(now)); 
    
           pst.setString(4,text_area.getText() );
           pst.setInt(5,4 );
           pst.execute();
           JOptionPane.showMessageDialog(null, "saved");
           
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, "can't be saved");
       }
   }
   
   
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

     
    
}
