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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mohamed
 */
public class SignUpController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    Redirection redirect = new Redirection();
    
    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField confirmPassword;

    @FXML
    private Button registerSignUpBtn;

    @FXML
    private Button registerBackBtn;

    @FXML
    void back(ActionEvent event) throws IOException {
        redirect.redirction("FirstScreen.fxml", event);
    }

    @FXML
    void signUpProccess(ActionEvent event) throws IOException {
        redirect.redirction("FirstScreen.fxml", event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
