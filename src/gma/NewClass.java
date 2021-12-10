/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Noor
 */
public class NewClass {
    public void start(Stage primaryStage) throws Exception{
       Stage stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("show_my_child.fxml"));
        stg.setTitle("Company Sign in Page");
        stg.setScene(new Scene(root));
        stg.show();
    }

    
    public static void main(String[] args){
        launch (args);
    }
    
}
