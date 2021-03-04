/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author mohamed
 */
public class Tictactoe extends Application {
    
//    private static SqlHandler sql;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        root.getStylesheets().add(getClass().getResource("css/menu-background.css").toString());
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe Game");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        launch(args);
    }
    
}
