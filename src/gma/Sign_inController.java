package gma;
import static gma.SubjectController.idClass;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author zaytona
 */
public class Sign_inController implements Initializable {
    public static int t_id;
    //public static int class_id;
    public static final ObservableList nos = FXCollections.observableArrayList();
    @FXML
    private TextField email;
    @FXML
    private PasswordField pass;
    @FXML
    private Label invalid;
    int flag=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void loginButt(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception {
       Connect c=new Connect();
       Connection con= c.connect_datbade();
        String email1=email.getText();
        String password1=pass.getText();
      	String q = "SELECT * FROM school_maneger";
        Statement statement=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
              ResultSet rs=statement.executeQuery(q);
          rs.absolute(0); //befor and afte first an dlast row
      while (rs.next()) {
              if(email1.equalsIgnoreCase(rs.getString("Email"))&&password1.equals(rs.getString("password")))
              {
              flag=1;
              break;
              }
      }
       	String q2 = "SELECT * FROM teacher";
        Statement statement2=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
              ResultSet rs2=statement2.executeQuery(q2);
          rs2.absolute(0); //befor and afte first an dlast row
      while (rs2.next()) {
              if(email1.equalsIgnoreCase(rs2.getString("Email"))&&password1.equals(rs2.getString("password")))
              {
               t_id =rs2.getInt("id_t");
              flag=2;
              /*String class0 = "SELECT * FROM tea_class WHERE id_teacher='"+rs2.getInt("id_t")+"'";
              Statement statement3=con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
              ResultSet rs3=statement3.executeQuery(class0);
                if (rs3.next()){
                    class_id = rs3.getInt("id_class");
               String idS = "SELECT * FROM subject WHERE class_id ='"+rs3.getInt("id_class")+"'";//choose id subject
        Statement statement5=con.createStatement( );
              ResultSet rs4=statement5.executeQuery(idS);
              while(rs4.next()){
                  nos.add(rs4.getString("name"));
              }
              //Sub.setItems(nos);*/
              break;
              }
              }
      if(flag==1){
        System.out.print("hello");
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
      if(flag==2){
        System.out.print("hello");
try {
                Stage stage = new Stage();
               Parent root;
            root = FXMLLoader.load(getClass().getResource("subject.fxml"));
               Scene scene = new Scene(root);
               stage.setScene(scene);
               stage.setTitle("Subject");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();}
catch (IOException ex) {
        }
            }
      else{
JOptionPane.showMessageDialog(null, "Please try Again !");
      }
    }
     @FXML
private void exitButtonOnAction(ActionEvent event){
    int c =JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION);
    if (c == JOptionPane.YES_OPTION) {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
} else {
}
         }
    @FXML
    private void forgot_butt(MouseDragEvent event) {
    }
}