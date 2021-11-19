/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author USER
 */
public class GMACompany extends Application {
    
   // private static Stage stg;
    

      private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("CompanySignInPage.fxml"));
        primaryStage.setTitle("Company Sign in Page");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

//    public void changeScene(String fxml) throws IOException {
//        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
//        stg.getScene().setRoot(pane);
//    }
     
    
    public static void main(String[] args){
        launch (args);
    }
    
    
}
