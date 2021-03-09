/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author G2
 */
public class MultiplayerLocalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Redirection redirect = new Redirection();
    
    @FXML
    private TextField playerOneName;

    @FXML
    private JFXButton play;

    @FXML
    private TextField playerTwoName;

    @FXML
    private JFXButton back;

    @FXML
    void backProcess(ActionEvent event) throws IOException {
        redirect.redirction("NewGame.fxml", event);
    }

    @FXML
    void playProcess(ActionEvent event) throws IOException {
        redirect.redirction("TwoPlayersLocalPlay.fxml", event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
