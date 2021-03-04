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
public class GamelevelsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Redirection redirect = new Redirection();
    
    @FXML
    private JFXButton easyBtn;

    @FXML
    private JFXButton mediumBtn;

    @FXML
    private JFXButton hardBtn;

    @FXML
    private JFXButton back;

    @FXML
    void back(ActionEvent event) throws IOException {
        redirect.redirction("NewGame.fxml", event);
    }

    @FXML
    void easyLevel(ActionEvent event) throws IOException {
        redirect.redirction("Single.fxml", event);
    }

    @FXML
    void hardLevel(ActionEvent event) throws IOException {
        redirect.redirction("Single.fxml", event);
    }

    @FXML
    void mediumlevel(ActionEvent event) throws IOException {
        redirect.redirction("Single.fxml", event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
