/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.awt.Panel;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ayaha
 */

public class SubjectController implements Initializable {
     @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;
   @FXML
            public static int teacher = 5;
            public static int idClass =12;
            public static int idSub =5;
             public ComboBox Sub;
             //private Button[] btns = new Button[10];
            public final Button [] bAss = {b1,b2,b3,b4};
            final ObservableList nos = FXCollections.observableArrayList();
            public static String assName;
            public static String Assignment0 = null ;
              int selectButton = 0;
     

    /**
     *
     */
    //public Button[] buttons = new Button[10];
    /**
     * Initializes the controller class.
     */
        
    
   // private Pane bks;      
   

   @FXML
   
    private Pane p1;
    @FXML
    private Button dA;
    @FXML
    private Button Ag;
 
       @FXML
    void subChoose(ActionEvent event) {
       //b1.setVisible(true);
      // b1.setText("aya");
      String[] a = new String[20] ;
      int[] a2 = new int[20] ;
     assName = (String)Sub.getValue();
        String value = null;
        int j=0;
        int i=0;
        try{
        Connect c=new Connect();
        Connection con= c.connect_datbade();
        //SELECT * FROM `subject` WHERE `class_id` = 12 & `name` = 'Math';
        String idS = "SELECT * FROM subject WHERE class_id ='"+idClass+"'&& name='"+assName+"'";///choose id subject 
        Statement statement0=con.createStatement( );
        ResultSet rs=statement0.executeQuery(idS); 
     if(rs.next()) {
         
      String q = "SELECT * FROM assignments where id_teacher ='"+teacher+"'&& id='"+rs.getInt("id")+"'";//choose from assig that have same teacher id & Id-subject
      Statement statement1=con.createStatement();
       ResultSet rs2=statement1.executeQuery(q);
     while(rs2.next()){
        value = rs2.getString("name");
          a[i]=value;
          j = rs2.getInt("duration");
          a2[i]=j;
          i++; 
     }
     }
    
      else{
        JOptionPane.showMessageDialog(null, "empty");  
      }
     if(a[0]!= null){
         b1.setVisible(true);
         b1.setText(""+a[0]);
     }
     if(a[1]!= null){
         b1.setVisible(true);
         b1.setText(a[1]);
     }
     if(a[2]!= null){
         b1.setVisible(true);
         b1.setText(a[2]);
     }
     if(a[3]!= null){
         b1.setVisible(true);
         b1.setText(a[3]);
     }
        }
     catch(Exception e){
             
             }
    
    }
    @FXML
    void toAssi(MouseEvent event) throws IOException {
         ((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); 
         Stage stage = new Stage();
               Parent root ;
               root = FXMLLoader.load(getClass().getResource("assignment.fxml"));
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Assignment");
               stage.show();
    }

    @FXML
    void toChat(MouseEvent event) {

    }
    @FXML
    void toGrades(ActionEvent event) throws IOException {
     ((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); 
         Stage stage = new Stage();
               Parent root ;
               root = FXMLLoader.load(getClass().getResource("grades.fxml"));
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Grades");
               stage.show();
    }
    @FXML
    void toHome(MouseEvent event) throws IOException {
 ((Stage)(((Label)event.getSource()).getScene().getWindow())).close(); 
         Stage stage = new Stage();
               Parent root ;
               root = FXMLLoader.load(getClass().getResource("assignment.fxml"));
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Assignment");
               stage.show();
    }
     @FXML
    void delete(ActionEvent event) {
        //String []aa = new String[20];
       
        
     try{
         if(selectButton==1){
             Assignment0=b1.getText();
            // aa = Assignment0.split("Duration",5);
             //b1.setText("");
             b1.setVisible(false);
         }
         if(selectButton==2){
             Assignment0=b2.getText();
            // aa = Assignment0.split("  ",5);
              b2.setVisible(false);
         }
         if(  selectButton ==3){
             Assignment0=b3.getText();
             //aa = Assignment0.split("  ",5);
              b3.setVisible(false);
         }
         if(selectButton ==4){
             Assignment0=b4.getText();
          // aa = Assignment0.split("Duration",5);
              b4.setVisible(false);
         }
      
        
         
    
     int Tid =5;
    Connect c=new Connect();
     Connection con= c.connect_datbade();
      String q0 = "SELECT * FROM assignments WHERE name ='"+Assignment0+"'&& id_teacher ='"+Tid+"'";
         java.sql.Statement statment=con.createStatement( );
       ResultSet rs =statment.executeQuery(q0);
         
          if(rs.next()==true){
      
         String q5 = "DELETE FROM assignments WHERE name ='"+Assignment0+"'&& id_teacher ='"+Tid+"'";
        java.sql.Statement statement5=con.createStatement( );
        statement5.executeUpdate(q5);
                 JOptionPane.showMessageDialog(null,"Delete SUCCESSFULLY");
                // assN.setText("");
                // details.setText("");
             
          }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"can't delete");
        }
    }
     @FXML
    void select(ActionEvent event) {
    
      dA.setDisable(false);
      Ag.setDisable(false);
      if(event.getSource()==b1){
           selectButton=1;
         }
         if(event.getSource()==b2){
             selectButton=2;
         }
         if(event.getSource()==b3){
             selectButton=3;
         }
         if(event.getSource()==b4){
            selectButton=4;
         }
         
      
    }
   @FXML
        void fillcombo(MouseEvent event) {

       try{
           Connect c=new Connect();
        Connection con= c.connect_datbade();
        String idS = "SELECT * FROM subject WHERE class_id ='"+idClass+"'";//choose id subject 
        Statement statement0=con.createStatement( );
              ResultSet rs=statement0.executeQuery(idS);
              while(rs.next()){
                  nos.add(rs.getString("name"));
                 
              }
             
              Sub.setItems(nos);
      }
      catch(Exception e){
          
      }
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    
      //  this.notifyAll();
      /*
        Sub.setEditable(true);
       try{
        Connect c=new Connect();
        Connection con= c.connect_datbade();
       	String q = "SELECT * FROM subject-teacher WHERE id-teacher ='"+teacher+"'";
        Statement statement=con.createStatement( );
              ResultSet rs=statement.executeQuery(q);
      
      while (rs.next()) {
          
              q2 = "SELECT * FROM subject WHERE id ='"+rs.getInt("id-sub")+"'& class_id ='"+idClass+"'";
              Statement statement2=con.createStatement( );
              ResultSet rs2=statement.executeQuery(q2);
              n = rs.getString("name");
              nos.add(n);
              //Sub.setId(n);
              
              //JOptionPane.showMessageDialog(null, n);
           
      }
      Sub = new ComboBox(nos);
        }
      catch(Exception e){
               JOptionPane.showMessageDialog(null, "aya");
              }*/
    }    
    
}
