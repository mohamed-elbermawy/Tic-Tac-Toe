/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author mohamed
 */
public class StartMenuController implements Initializable {
    
    Redirection redirect = new Redirection();
    
    @FXML
    private Button newGameBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    private Button settingBtn;

    @FXML
    private Button aboutBtn;

    @FXML
    private Button exitBtn;
    
    Alert aler;

    @FXML
    void newGame(ActionEvent event) throws IOException {
        redirect.redirction("NewGame.fxml", event);
    }
    
    @FXML
    void signUp(ActionEvent event) throws IOException {
        //redirect.redirction("SignUp.fxml", event);
    }

    @FXML
    void setting(ActionEvent event) {
       aler = new Alert(Alert.AlertType.CONFIRMATION);
       aler.setContentText("Settings");
       aler.show();
    }
    
    @FXML
    void about(ActionEvent event) {
        aler = new Alert(Alert.AlertType.CONFIRMATION);
        aler.setContentText("About");
        aler.show();
    }

    @FXML
    void exit(ActionEvent event) {
       redirect.closePages(event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
