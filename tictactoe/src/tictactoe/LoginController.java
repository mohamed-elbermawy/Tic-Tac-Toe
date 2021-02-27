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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mohamed
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Redirection redirect = new Redirection();
    
    @FXML
    private AnchorPane anchorPaneLogin;
    
    @FXML
    private Button loginBtn;

    @FXML
    private Button backBtn;
    
    @FXML
    private Button signUp;

    @FXML
    void back(ActionEvent event) {
        redirect.closePages(event);
    }

    @FXML
    void loginProccess(ActionEvent event) throws IOException {
        redirect.redirction("FirstScreen.fxml",event);
    }
    
    @FXML
    void signUpPage(ActionEvent event) throws IOException {
        redirect.redirction("SignUp.fxml",event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
