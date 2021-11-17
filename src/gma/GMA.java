/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import com.sun.javafx.application.LauncherImpl;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author zaytona
 */
public class GMA extends Application {
     private static final int count=50000;
    @FXML
    private AnchorPane pane;
    @FXML
    private Label progressLabel;
    @FXML
    private ProgressBar progress;
    @FXML
    private Label label;
    @FXML
    private AnchorPane AnchorPane;
    
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
       Parent root = FXMLLoader.load(getClass().getResource("schoolPage.fxml"));
        //String css = GMA.class.getResource("mystyle.css").toExternalForm();
       /// scene.getStylesheets().add(css);

      Scene scene = new Scene(root);  
                scene.setFill(Color.TRANSPARENT);
               stage.setScene(scene);
                 stage.initStyle(StageStyle.TRANSPARENT);
               stage.setTitle("Doctor profile");
               stage.show();
                System.out.print("hello world");
      
    }

    /**
     * @param args the command line arguments
     */
     public void init() throws Exception{
        for(int i =350 ; i<count ;i++){
            double prog = (100*i)/count;
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(prog));
        }
        
        
        
        
        
    }
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        LauncherImpl.launchApplication(GMA.class, myproc.class, args);
       
        
    }
    
}
