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
import javafx.scene.control.TextField;
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
    private Redirection redirect = new Redirection();
    private SqlHandler sql;
    private Alert alert;

    @FXML
    private AnchorPane anchorPaneLogin;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button loginBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Button signUp;

    @FXML
    void exit(ActionEvent event) {
        redirect.closePages(event);
    }

    @FXML
    void loginProccess(ActionEvent event) throws IOException {
        sql = new SqlHandler();
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Enter Your Data");
            alert.show();
            return;
        } else {
            if (sql.login(username.getText().toString(), password.getText().toString())) {
                redirect.redirction("FirstScreen.fxml", event);
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Please Try again");
                alert.show();
                return;
            }
        }
    }

    @FXML
    void signUpPage(ActionEvent event) throws IOException {
        redirect.redirction("SignUp.fxml", event);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
