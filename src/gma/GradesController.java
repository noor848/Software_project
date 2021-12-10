/*

- To change this license header, choose License Headers in Project Properties.
- To change this template file, choose Tools | Templates
- and open the template in the editor.
*/
package gma;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**

- FXML Controller class
- 
- @author USER
*/
public abstract class GradesController implements Initializable {
    
    //TABLE VIEW AND DATA
    private ObservableList<ObservableList> data;
    private TableView tableview;
    int classID =11;
    
    //MAIN EXECUTOR
    public static void main(String[] args) {
    launch(args);
    }
    
    //CONNECTION DATABASE
    public void buildData(){
    data = FXCollections.observableArrayList();
    Connect c = new Connect();
    try{
    
    
    Connection con= c.connect_datbade();
    
    PreparedStatement ps = con.prepareStatement("SELECT student.name_s, student.id_s from student, studentclass where student.id_s = studentclass.student_id and studentclass.class_id="+classID);
            ResultSet rs = ps.executeQuery();
       
    
//ResultSet
    
         //SQL FOR SELECTING ALL OF CUSTOMER
//         String SQL = "SELECT student.name_s, student.id_s from student, studentclass where student.id_s = studentclass.student_id and studentclass.class_id="+classID;
         //ResultSet
//         ResultSet rs = c.createStatement().executeQuery(SQL);
    
         /**********************************
          * TABLE COLUMN ADDED DYNAMICALLY *
          **********************************/
         for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
             //We are using non property style for making dynamic table
             final int j = i;
             TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
             col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                 public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                     return new SimpleStringProperty(param.getValue().get(j).toString());
                 }
             });
    
             tableview.getColumns().addAll(col);
             System.out.println("Column ["+i+"] ");
         }
    
         /********************************
          * Data added to ObservableList *
          ********************************/
         while(rs.next()){
             //Iterate Row
             ObservableList<String> row = FXCollections.observableArrayList();
             for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                 //Iterate Column
                 row.add(rs.getString(i));
             }
             System.out.println("Row [1] added "+row );
             data.add(row);
    
         }
    
         //FINALLY ADDED TO TableView
         tableview.setItems(data);
       }catch(Exception e){
           e.printStackTrace();
           System.out.println("Error on Building Data");
       }
    
    
    }
    
    public void start(Stage stage) throws Exception {
    //TableView
    tableview = new TableView();
    buildData();
    
     //Main Scene
     Scene scene = new Scene(tableview);
    
     stage.setScene(scene);
     stage.show();
    
    
    }
}
