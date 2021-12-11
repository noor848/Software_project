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
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AddSubjectNewController implements Initializable {

    @FXML
    private TextField subjectName;
    @FXML
    private TextField SubjectID;
    @FXML
    private TextField ClassID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddAction(ActionEvent event) throws Exception {
        
        
        try{
                Connect c=new Connect();
 
       Connection con= c.connect_datbade();
       
        String quer = " insert into subject(name,id,class_id)\n"
        + " values ( ?, ? , ?)";
        System.out.println("DaaaaaTa"+subjectName.getText().toString()
                +SubjectID.getText()
                +ClassID.getText());
        
      PreparedStatement preparedStmt2 = con.prepareStatement(quer);
      preparedStmt2.setString(1,subjectName.getText());
      preparedStmt2.setInt(2,Integer.parseInt(SubjectID.getText()));
      preparedStmt2.setInt(3,Integer.parseInt(ClassID.getText()));
        preparedStmt2.execute();

      System.out.println("Subject added successfully");
      
//      JFrame f=new JFrame();  
//      JOptionPane.showMessageDialog(f,"Subjict added successfully.");
//      //
//      
      JOptionPane.showMessageDialog(null, "Subject added successfully");
      
        }
        catch(IOException ex){
//            
//                  JFrame f=new JFrame();  
//      JOptionPane.showMessageDialog(f,"something is wrong in data");

        System.out.println(ex);
//            
       JOptionPane.showMessageDialog(null, "something is wrong in data");

        
        }
      
    }

    @FXML
    private void BackAct(ActionEvent event) {
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
