/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CompanyConfirmLoginController implements Initializable {


    @FXML
    private TextField CodeConfirm;
    
    @FXML
    private Label ErrorLabel;
    
    //The confirmCode need to be git from what the email send.. not lilke this.
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

       
    }   
    @FXML 
     public void verify(ActionEvent event) throws Exception { 
         sendMail("gmacompany2000@gmail.com"); 
     }
           static int x=0; 
         @FXML 
        private void ConfirmAction(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {{ 
         if (CodeConfirm.getText().equals(Integer.toString(x))){
             try {
               Stage stage = new Stage();
               Parent root;
        
               root = FXMLLoader.load(getClass().getResource("CompanyMainPage.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Welcome to GMA");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } 
            catch (IOException ex) {
                
                System.out.print("Inside sign in Exop"+ ex);
            
                    }}
              else{
              ErrorLabel.setText("Incorrect Code");
              }
        
     }
        }
        @FXML
        private void BackAction(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
            
            // any way to retrave prv. page? 
            
                          try {
               Stage stage = new Stage();
               Parent root;
        
               root = FXMLLoader.load(getClass().getResource("CompanySignInPage.fxml"));
        
               Scene scene = new Scene(root);  
               stage.setScene(scene);
               stage.setTitle("Company Sign in Page");
               stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } 
            catch (IOException ex){
            
                    }
            
        
        }


       
    
     public static void sendMail(String r) throws Exception{
        
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        
        String account= "schoolprivate95@gmail.com";
        String pass = "Sura@1234";
        
        Session s = Session.getInstance(p, new Authenticator(){
        @Override
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(account,pass);
           
        }
    });
         Message m = prepareMessage(s,account,r);
         Transport.send(m);
    }
    private static Message prepareMessage(Session s,String account, String r) throws Exception{
        Random rand = new Random(); //instance of random class
      int upperbound = 99999;
      int  random = rand.nextInt(upperbound); 
      x=random;
        try {
        Message m=new MimeMessage(s);
        m.setFrom(new InternetAddress(account));
        m.setRecipient(Message.RecipientType.TO, new InternetAddress(r));
        m.setSubject("Confirm GMA Company");
        String t = "your code is: "+Integer.toString(random);
        m.setText(t);
        return m;
           
        } catch (MessagingException ex) {
            Logger.getLogger(CompanyConfirmLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    } 
