/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author mohamed
 */
public class Tictactoe extends Application {

    public static MediaPlayer mediaPlayer;

    @Override
    public void start(Stage stage) throws Exception {
        
//        Parent root = FXMLLoader.load(getClass().getResource("MediaScreenWinner.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
//       Parent root = FXMLLoader.load(getClass().getResource("GameLevels.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("NewClass.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
        root.getStylesheets().add(getClass().getResource("css/menu-background.css").toString());

        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe Game");
        stage.setScene(scene);
        stage.show();
        

        //playMusic("/media/mohamed/Data1/courses/ITI Courses/Java/Project Java/tictactoe/src/tictactoe/songs/musicGame.wav");
        music();
    }

    public static void music() {
        String s = "/home/mohamed/Desktop/bb/TicTacTok-final/TicTacTok-final/tictactoe/src/tictactoe/songs/musicGame.wav";
        s = Paths.get(s).toUri().toString();
        mediaPlayer = new MediaPlayer(new Media(s));
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(javafx.util.Duration.ZERO));
        mediaPlayer.play();
    }

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    /**
     *
     * @author G2
     */
//    public static void playMusic(String filepath) {
//        try {
//            File musicPath = new File(filepath);
//
//            if (musicPath.exists()) {
//                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
//                Clip clip = AudioSystem.getClip();
//                clip.open(audioInput);
//                clip.loop(Clip.LOOP_CONTINUOUSLY);
//
//                clip.loop(3);
//                clip.setLoopPoints(0, -1);
//                clip.start();
//
//            } else {
//
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
