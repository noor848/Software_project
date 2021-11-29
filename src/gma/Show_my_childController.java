/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
    private TableView<ParentSee> tablef;
    @FXML
    private TextField search;
    @FXML
    private TableColumn<ParentSee,Integer> id_student;
    @FXML
    private TableColumn<ParentSee,String> name;
    @FXML
    private TableColumn<ParentSee, String> name_sub;
    @FXML
    private TableColumn<ParentSee, Integer > grade;

   
     ObservableList<ParentSee> listM;
     ObservableList<ParentSee> dataList;
       int index = -1;
       
       
       
       
    @FXML
    private TableColumn<ParentSee, Integer> class1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            listM = sqlconnect.getData();
        } catch (SQLException ex) {
            Logger.getLogger(Show_my_childController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Show_my_childController.class.getName()).log(Level.SEVERE, null, ex);
        }

           
        
      tablef.setItems(listM);
                try {
             listM = sqlconnect.getData();
                       

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Show_my_childController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Show_my_childController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Show_my_childController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
      tablef.setItems(listM);
        
        
         try {
          // TODO
         search_user();
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(Show_my_childController.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(Show_my_childController.class.getName()).log(Level.SEVERE, null, ex);
      } catch (Exception ex) {
            Logger.getLogger(Show_my_childController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    
    
    
void search_user() throws ClassNotFoundException, SQLException, Exception {  


        id_student.setCellValueFactory(new PropertyValueFactory<ParentSee,Integer>("studentId"));
         name.setCellValueFactory(new PropertyValueFactory<ParentSee,String>("studentName"));
          name_sub.setCellValueFactory(new PropertyValueFactory<ParentSee,String>("nameSubject"));
           grade.setCellValueFactory(new PropertyValueFactory<ParentSee,Integer>("grade"));
            class1.setCellValueFactory(new PropertyValueFactory<ParentSee,Integer>("classId"));
           
       dataList = sqlconnect.getData();
        tablef.setItems(dataList);
        
     FilteredList<ParentSee> filteredData = new FilteredList<>(dataList, b -> true);  
 search.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
      String lowerCaseFilter = newValue;
    
    if (person.nameSubject.toLowerCase().contains(lowerCaseFilter) ) {
     return true; // Filter matches username
    } else if (person.studentName.toLowerCase().contains(lowerCaseFilter)) {
     return true; // Filter matches password
    }
else if (String.valueOf(person.grade()).contains(lowerCaseFilter))return true;    
else if (String.valueOf(person.classId()).contains(lowerCaseFilter))return true;     
else if (String.valueOf(person.studentId()).contains(lowerCaseFilter))return true;     
         else  
          return false; // es not match.
   });
  });  
  SortedList<ParentSee> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(tablef.comparatorProperty());  
  tablef.setItems(sortedData); 
        
     
       
        
    }

    @FXML
    private void search(ActionEvent event) throws SQLException, Exception {
           search_user();
    }
}
