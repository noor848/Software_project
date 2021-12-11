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
import javafx.scene.control.TextField;
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
            Sign_inController r = new Sign_inController();
            public static int teacher = Sign_inController.t_id;
            public static int idClass ;
            public static int idSub ;
            public static int idAss;
             public static String subject;
             public ComboBox Sub;
             //private Button[] btns = new Button[10];
            public final Button [] bAss = {b1,b2,b3,b4};
            final ObservableList nos = FXCollections.observableArrayList();
            public static String assName;
            public static String Assignment0 = null ;
              int selectButton = 0;
               int flage = 0;
               String Assignment;
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
    private Button ud;
       @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    @FXML
    void subChoose(ActionEvent event) {
      b1.setVisible(false);
      t1.setVisible(false);
      b2.setVisible(false);
      t2.setVisible(false);
      b3.setVisible(false);
      t3.setVisible(false);
      b4.setVisible(false);
      t4.setVisible(false);
      String[] a = new String[20] ;
      int[] a2 = new int[20] ;
      subject = (String)Sub.getValue();
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
         idSub = rs.getInt("id");
      String q = "SELECT * FROM assignments where id_teacher ='"+teacher+"'&& id_subject='"+idSub+"'";//choose from assig that have same teacher id & Id-subject
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
         t1.setVisible(true);
         t1.setText(""+a2[0]);
     }
     if(a[1]!= null){
         b2.setVisible(true);
         b2.setText(a[1]);
          t2.setVisible(true);
         t2.setText(""+a2[1]);
     }
     if(a[2]!= null){
         b3.setVisible(true);
         b3.setText(a[2]);
          t3.setVisible(true);
         t3.setText(""+a2[2]);
     }
     if(a[3]!= null){
         b4.setVisible(true);
         b4.setText(a[3]);
          t4.setVisible(true);
         t4.setText(""+a2[3]);
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
               if(event.getSource()==ud){
               }
    }
    @FXML
    void toChat(MouseEvent event) {
    }
    @FXML
    void toGrades(ActionEvent event) throws IOException {
        try{
         Connect c=new Connect();
        Connection con= c.connect_datbade();
        String id0 = "SELECT * FROM assignments WHERE name ='"+Assignment+"'&& id_subject='"+idSub+"'";///choose id subject
        Statement statement0=con.createStatement( );
        ResultSet rs=statement0.executeQuery(id0);
        while(rs.next()){
        idAss = rs.getInt("id");
        }
        }
        catch(Exception e){
        }
     ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
         Stage stage = new Stage();
               Parent root ;
               root = FXMLLoader.load(getClass().getResource("Grd.fxml"));
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
               root = FXMLLoader.load(getClass().getResource("sign_in.fxml"));
               Scene scene = new Scene(root);
               stage.setScene(scene);
               stage.setTitle("Sign_in");
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
             t1.setVisible(false);
         }
         if(selectButton==2){
             Assignment0=b2.getText();
            // aa = Assignment0.split("  ",5);
              b2.setVisible(false);
              t2.setVisible(false);
         }
         if(selectButton==3){
             Assignment0=b3.getText();
             //aa = Assignment0.split("  ",5);
              b3.setVisible(false);
              t3.setVisible(false);
         }
         if(selectButton==4){
             Assignment0=b4.getText();
          // aa = Assignment0.split("Duration",5);
              b4.setVisible(false);
              t4.setVisible(false);
         }
    Connect c=new Connect();
     Connection con= c.connect_datbade();
      String q0 = "SELECT * FROM assignments WHERE name ='"+Assignment0+"'&& id_teacher ='"+teacher+"'&& id_subject='"+idSub+"'";
         java.sql.Statement statment=con.createStatement( );
       ResultSet rs =statment.executeQuery(q0);
          if(rs.next()==true){
         String q5 = "DELETE FROM assignments WHERE name ='"+Assignment0+"'&& id_teacher ='"+teacher+"'&& id_subject='"+idSub+"'";
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
      if(event.getSource()==b1){
           selectButton=1;
           dA.setDisable(false);
           Assignment = b1.getText();
      Ag.setDisable(false);
         }
         if(event.getSource()==b2){
             selectButton=2;
             dA.setDisable(false);
              Assignment = b2.getText();
      Ag.setDisable(false);
         }
         if(event.getSource()==b3){
             selectButton=3;
           dA.setDisable(false);
            Assignment = b3.getText();
      Ag.setDisable(false);
         }
         if(event.getSource()==b4){
            selectButton=4;
            dA.setDisable(false);
             Assignment = b4.getText();
      Ag.setDisable(false);
         }
    }
   @FXML
        void fillcombo(MouseEvent event) {
           if(flage ==0){
       try{
           Connect c=new Connect();
        Connection con= c.connect_datbade();
        String class0 = "SELECT * FROM tea_class WHERE id_teacher='"+teacher+"'";
              Statement statement3=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
              ResultSet rs3=statement3.executeQuery(class0);
                while (rs3.next()){
                    idClass= rs3.getInt("id_class");
                }
        ///
        String idS = "SELECT * FROM subject WHERE class_id ='"+idClass+"'";//choose id subject
        Statement statement0=con.createStatement( );
              ResultSet rs=statement0.executeQuery(idS);
              while(rs.next()){
                  nos.add(rs.getString("name"));
              }
              Sub.setItems(nos);
              flage =1;
      }
      catch(Exception e){
      }
           }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Sub.setItems(nos);
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