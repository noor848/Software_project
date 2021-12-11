/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import static gma.AssignmentController.Assid;
import static gma.SubjectController.idClass;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author USER
 */
public class GrdController implements Initializable {

    @FXML
    private AnchorPane saveGrade;
    @FXML
    private ListView<String> stID;
    @FXML
    private ListView<Integer> stGrade;
    @FXML
    private TextField txtfield;

    /**
     * Initializes the controller class.
     */
    
     int AssID = Assid; //this from prev page!
     int ClassID = idClass; //this from prev page!

    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("inside inetialize");
        try {
            loadDataFromDB();
        } catch (Exception ex) {
            Logger.getLogger(GrdController.class.getName()).log(Level.SEVERE, null, ex);
        }

}
    private void loadDataFromDB() throws Exception {
        
            stID.getItems().clear();
            stGrade.getItems().clear();
        
    try{
            Connect c=new Connect();
            Connection con= c.connect_datbade();
            String query = "SELECT * from  grades INNER JOIN student on student.id_s=grades.id_student";
           Statement statement=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           ResultSet rs=statement.executeQuery(query);
           System.out.println("inside set load data 3");

         while(rs.next()){

             String m=rs.getString(4);
             String name= rs.getString(6);
             int grade= rs.getInt(2);
             System.out.println(m+name);
             stID.getItems().add(m+" | "+name);
             stGrade.getItems().add(grade);
         }
}
 catch(Exception ex){
        
        }
    
    }
    
    @FXML
    private void onSave(ActionEvent event) throws Exception {
        
        
            Connect c=new Connect();
            Connection con= c.connect_datbade();
            String query = "UPDATE grades SET grade = "+txtfield.getText()+" WHERE id_student ="+stID.getSelectionModel().getSelectedItem().split(" ")[0];

            Statement stmt = con.createStatement(); 
            stmt.executeUpdate(query);
           System.out.println("after add grade");
           loadDataFromDB();
        
        
    }
}