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

/**
 * FXML Controller class
 *
 * @author G2
 */
public class NewgameController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Redirection redirect = new Redirection();
    
    @FXML
    private JFXButton singleBtn;

    @FXML
    private JFXButton twoPlayerOfflineBtn;

    @FXML
    private JFXButton twoPlayerOnineBtn;

    @FXML
    private JFXButton backBtn;

    @FXML
    void back(ActionEvent event) throws IOException {
        redirect.redirction("StartMenu.fxml", event);
    }

    @FXML
    void singleMode(ActionEvent event) throws IOException {
        redirect.redirction("GameLevels.fxml", event);
    }

    @FXML
    void twoPlayerOfflineMode(ActionEvent event) throws IOException {
        redirect.redirction("MultiPlayerLocal.fxml", event);
    }

    @FXML
    void twoPlayerOnineMode(ActionEvent event) throws IOException {
        redirect.redirction("Online.fxml", event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
