/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.nio.file.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author mohamed
 */
public class Tictactoe extends Application {
   
    public MediaPlayer mediaPlayer;
    @Override
    public void start(Stage stage) throws Exception {
//        play();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("GameLevels.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("NewClass.fxml"));
        root.getStylesheets().add(getClass().getResource("css/menu-background.css").toString());
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe Game");
        stage.setScene(scene);
        stage.show();
    }
    
    public void play(){
        String source = "/media/mohamed/Data1/courses/ITI Courses/Java/Project Java/Tictactoe/src/tictactoe/songs/1.mp3";
        Media media = new Media(Paths.get(source).toUri().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        launch(args);
    }
    
}
