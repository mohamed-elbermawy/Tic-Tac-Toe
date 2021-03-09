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
public class SingleController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Redirection redirect = new Redirection();
    @FXML
    private JFXButton playBtn;

    @FXML
    private JFXButton backBtn;

    @FXML
    void back(ActionEvent event) throws IOException {
        redirect.redirction("GameLevels.fxml", event);
    }

    @FXML
    void play(ActionEvent event) throws IOException {
        redirect.redirction("PlayingWithComp.fxml", event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
