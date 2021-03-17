/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author G2
 */
public class MediaScreenWinnerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private File file;
    private Media media;
    public static MediaPlayer mediaPlayer;
    
    private Redirection redirect = new Redirection();
    @FXML
    private MediaView mediaplyer;
    
    @FXML
    private JFXButton backBtn;

    @FXML
    private Label winner;

    @FXML
    void back(ActionEvent event) throws IOException {
        mediaPlayer.stop();
        redirect.redirction("StartMenu.fxml", event);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mediaPlayer = new MediaPlayer(new Media(getClass().getResource("2.mp4").toExternalForm()));
        mediaplyer.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }    
    

    
}
