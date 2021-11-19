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
    

     // private Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception{
       Stage stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("CompanySignInPage.fxml"));
        stg.setTitle("Company Sign in Page");
        stg.setScene(new Scene(root));
        stg.show();
    }

    
    public static void main(String[] args){
        launch (args);
    }
    
    
}
