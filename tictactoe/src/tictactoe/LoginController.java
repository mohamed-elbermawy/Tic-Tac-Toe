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
    private Alert alert;
//    private Scanner in;
//    private PrintWriter out;
//    private Socket socket;
public App app = new App("127.0.0.1");
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
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Enter Your Data");
            alert.show();
            return;
        } else {
            if (parseBoolean(app.login(username.getText().toString(), password.getText().toString()))) {
                redirect.redirction("StartMenu.fxml", event);
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Please Try again");
                alert.show();
                return;
            }
        }
    }
    
//    boolean login(String username,String password){
//        boolean line;
//        out.println("login");
//        out.println(username + "," + password);
//        line = parseBoolean(in.nextLine());
//        return line;
//    }

    @FXML
    void signUpPage(ActionEvent event) throws IOException {
        redirect.redirction("SignUp.fxml", event);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        try {
//            socket = new Socket("localhost", 5005);
//            in = new Scanner(socket.getInputStream());
//            out = new PrintWriter(socket.getOutputStream(), true);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        app = new App("127.0.0.1");
    }

}
