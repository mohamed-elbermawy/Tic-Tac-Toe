/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author G2
 */
public class OnlineController implements Initializable {

//    private Scanner in;
//    private PrintWriter out;
//    private Socket socket;
    /**
     * Initializes the controller class.
     */
    Redirection redirect = new Redirection();

    @FXML
    private TextField playerName;

    @FXML
    private JFXButton inviteBtn;
    @FXML
    private JFXButton backBtn;

    @FXML
    void back(ActionEvent event) throws IOException {
        redirect.redirction("NewGame.fxml", event);
    }

    @FXML
    void invite(ActionEvent event) {
        String xMark = init2playerGame("mohamed", "islam");
        System.out.println(xMark);
    }
    
     public String init2playerGame(String player1Name, String player2Name) {
        String line;
        tictactoe.LoginController.out.println("init2Game");
        tictactoe.LoginController.out.println(player1Name + "," + player2Name);
        // out.println(message);
        line = tictactoe.LoginController.in.nextLine();
        return line;
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
    }

}
