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
    private Redirection redirect = new Redirection();
    private SqlHandler sql;
    private Alert alert;

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
        redirect.redirction("Login.fxml", event);
    }

    @FXML
    void signUpProccess(ActionEvent event) throws IOException {
        sql = new SqlHandler();
        if (username.getText().isEmpty() || password.getText().isEmpty() || confirmPassword.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Enter Your Data");
            alert.show();
            return;
        } else {
            if (password.getText().equals(confirmPassword.getText())) {
                if (sql.signUp(username.getText().toString(), password.getText().toString())) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Registered sucessfully");
                    alert.showAndWait();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Please Try again");
                    alert.show();
                    return;
                }
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Invalid Data please check it again");
                alert.show();
                return;
            }
        }
        redirect.redirction("Login.fxml", event);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
