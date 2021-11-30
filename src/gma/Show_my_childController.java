/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Noor
 */
public class Show_my_childController implements Initializable {

    @FXML
    private TextField search;
    @FXML
    private TextField classid;
    @FXML
    private TextField studentid;
    @FXML
    private TextField name;
    @FXML
    private ListView  <String>grade1;
    
    private TextField subejcet_name;
    @FXML
    private Button search_button;
    @FXML
    private TextField subject;

ObservableList  observableList ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    
        
    }
    
    
    
    

    @FXML
    private void search_handle(ActionEvent event) throws Exception {
        
          
       Connect c=new Connect();
       
       Connection con= c.connect_datbade();
        
                        try {
         PreparedStatement ps = con.prepareStatement("SELECT\n" +
"subject.name,grades.grade,student.name_s,student.id_s,class.id from  student\n" +
"INNER JOIN studentclass ON studentclass.student_id=student.id_s\n" +
"INNER JOIN class ON studentclass.class_id=class.id\n" +
"INNER JOIN  subject on subject.class_id=class.id\n" +
"INNER JOIN grades on grades.id_sub =subject.id  where id_s = ?  ");
      ps.setInt(1,Integer.parseInt(search.getText())); 
        // ps.setString(1,subject.getText().trim().toString());

                       Statement statement=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = ps.executeQuery();
              rs.absolute(0); //befor and afte first an dlast row
            while (rs.next()){  
         classid.setText(Integer.toString(rs.getInt("id"))); 
           studentid.setText(Integer.toString(rs.getInt("id_s")));  
           name.setText(rs.getString("name_s"));  
               subejcet_name.setText(rs.getString("name")); 
                        grade1.getItems().add("hello");
                
                   }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
                        
            
        
      
    }
}
