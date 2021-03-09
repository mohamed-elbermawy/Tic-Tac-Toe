/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

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
import javafx.stage.Stage;
import tictactoe.App;
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
    private Alert alert;
    private Scanner in;
    private PrintWriter out;
    private Socket socket;

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
        if (username.getText().isEmpty() || password.getText().isEmpty() || confirmPassword.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Enter Your Data");
            alert.show();
            return;
        } else {
            if (password.getText().equals(confirmPassword.getText())) {
                if (signUp(username.getText().toString(), password.getText().toString())) {
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
    
    boolean signUp(String username,String password){
        boolean line;
        out.println("register");
        out.println(username + "," + password);
        line = parseBoolean(in.nextLine());
        return line;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        try {
//            Socket socket = new Socket("localhost", 5005);
//            in = new Scanner(socket.getInputStream());
//            out = new PrintWriter(socket.getOutputStream(), true);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

}
