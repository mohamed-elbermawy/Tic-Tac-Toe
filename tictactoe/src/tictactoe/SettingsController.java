/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.parseBoolean;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mohamed
 */
public class SettingsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Redirection redirect = new Redirection();
    
    @FXML
    private AnchorPane anchorPaneLogin;

    @FXML
    private JFXButton backBtn;

    @FXML
    private JFXButton playBtn;

    @FXML
    private JFXButton stopBtn;

    @FXML
    void play(ActionEvent event) {
        tictactoe.Tictactoe.mediaPlayer.play();
        playBtn.setVisible(false);
        stopBtn.setVisible(true);

    }

    @FXML
    void stop(ActionEvent event) {
        tictactoe.Tictactoe.mediaPlayer.stop();
        playBtn.setVisible(true);
        stopBtn.setVisible(false);

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        redirect.redirction("StartMenu.fxml", event);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        playBtn.setVisible(false);
    }

}
