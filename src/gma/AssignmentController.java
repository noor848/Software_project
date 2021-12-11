package gma;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.JSType.toInteger;
/**
 * FXML Controller class
 *
 * @author ayaha
 */
public class AssignmentController implements Initializable {
     SubjectController s= new SubjectController();
     int Tid = s.teacher;
     int Sid = s.idSub;
     String subject = s.subject;
     public static int Assid = SubjectController.idAss;
    // String Sub = s.assName;
     //String assi = s.Assignment0;
    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField assName;
    private Label b;
    @FXML
    private TextArea details;
    @FXML
    void add(MouseEvent event)  {
        if(assName.getText().equals("") || details.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please add Name and duration");
        }
        else{
        int id =0;
        try{
       Connect c=new Connect();
       Connection con= c.connect_datbade();
        String assName0=assName.getText();//duration`, `id`, `id_teacher`
        //String password1;
        int duration =toInteger(details.getText()) ;
        //JOptionPane.showMessageDialog(null, ":"+duration);
      	
       String q0 = "SELECT * FROM assignments WHERE name ='"+assName0+"'&& id_subject ='"+Sid+"'&& id_teacher='"+Tid+"'";//SELECT `name`, `duration`, `id`, `id_teacher` FROM `assignments` WHERE `name`="aya";
         java.sql.Statement statment=con.createStatement( );
       ResultSet rs =statment.executeQuery(q0);
             if(rs.next()==true){
                 JOptionPane.showMessageDialog(null,"Theis assignment is already exist ");
             }
             else{
                 String qq = "SELECT * FROM assignments where 1";
                 Statement statement=con.createStatement( );
                 ResultSet rs5=statement.executeQuery(qq);
                 while (rs5.next()) {
                  id=rs5.getInt("id");
                  ++id;
                  }
        String q = "INSERT INTO assignments(`name`, `duration`, `id`, `id_teacher`, `id_subject`) VALUES ('"+assName.getText()+"','"+duration+"','"+id+"','"+Tid+"','"+Sid+"')";
        java.sql.Statement statement5=con.createStatement( );
        statement5.executeUpdate(q);
            //  ResultSet rs=statement.executeQuery(q);
          //rs.absolute(0); //befor and afte first an dlast row
         /* while (rs.next()) {
              duration = rs.getInt("duration");
          }*/
         JOptionPane.showMessageDialog(null,"Add SUCCESSFULLY");
          details.setText(" ");
          assName.setText("");
             }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"can't add");
        }
        }
    }
    //@FXML
    /*void delete(MouseEvent event)  {
        try{
     String assName0=assName.getText();
     int Tid =1;
    Connect c=new Connect();
     Connection con= c.connect_datbade();
      String q0 = "SELECT * FROM assignments WHERE name ='"+assName0+"'& id_teacher ='"+Tid+"'";
         java.sql.Statement statment=con.createStatement( );
       ResultSet rs =statment.executeQuery(q0);
          if(rs.next()==true){
         String q5 = "DELETE FROM assignments WHERE name ='"+assName0+"'& id_teacher ='"+Tid+"'";
        java.sql.Statement statement5=con.createStatement( );
        statement5.executeUpdate(q5);
                 JOptionPane.showMessageDialog(null,"Delete SUCCESSFULLY");
                 assName.setText("");
                 details.setText("");
             }
             else{
               JOptionPane.showMessageDialog(null,"not exist!");
             }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"can't delete");
        }
    // String q = "SELECT * FROM assignments WHERE name ='"+assName0+"'";
     //   Statement statement=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
      //        ResultSet rs=statement.executeQuery(q);
       //   rs.absolute(0); //befor and afte first an dlast row
      /*while (rs.next()) {
          String q5 = "DELETE FROM `assignments` WHERE `name` ='"+assName0+"'";
        Statement statement5=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
              ResultSet rs5=statement5.executeQuery(q5);
      }*/
   // }
    @FXML
    void update(MouseEvent event) {
 try{
     String assName0=assName.getText();
     //int Tid =5;
     //int id = 5;
     int du = toInteger(details.getText());
    Connect c=new Connect();
     Connection con= c.connect_datbade();
      String q0 = "SELECT * FROM assignments WHERE name ='"+assName0+"'&& id_subject ='"+Sid+"'&& id_teacher='"+Tid+"'";
         java.sql.Statement statment=con.createStatement( );
       ResultSet rs =statment.executeQuery(q0);
          if(rs.next()){
              Statement st=con.createStatement();
           String update ="UPDATE assignments SET name='"+assName0+"',duration='"+du+"',id='"+rs.getInt("id")+"',id_teacher='"+Tid+"' WHERE name ='"+assName0+"'&& id_subject='"+Sid+"'&& id_teacher='"+Tid+"'";
           st.executeUpdate(update);
            JOptionPane.showMessageDialog(null,"UPDATE SUCCESSFULLY");
             details.setText(" ");
          assName.setText("");
          }
          else{
             JOptionPane.showMessageDialog(null,"not exist");
          }
 }
 catch(Exception e){
     JOptionPane.showMessageDialog(null,e);
 }
    }
    @FXML
    void tosub(MouseEvent event) {
    }
     @FXML
    void bk(MouseEvent event) throws IOException {
      ((Stage)(((Label)event.getSource()).getScene().getWindow())).close();
      Stage stage = new Stage();
               Parent root ;
               root = FXMLLoader.load(getClass().getResource("subject.fxml"));
               Scene scene = new Scene(root);
               stage.setScene(scene);
               stage.setTitle("Subject");
               stage.show();
    }
     /*@FXML
    void toGrades(MouseEvent event) throws IOException {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
               Stage stage = new Stage();
               Parent root ;
               root = FXMLLoader.load(getClass().getResource("grades.fxml"));
               Scene scene = new Scene(root);
               stage.setScene(scene);
               stage.setTitle("Grades");
               stage.show();
    }*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}





