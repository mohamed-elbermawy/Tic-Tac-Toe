/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import com.jfoenix.controls.JFXButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
//import java.awt.Font;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author mohamed
 */
public class TwoPlayersLocalPlayController implements Initializable {

    private Scanner in;
    private PrintWriter out;
    private Socket socket;
    private Redirection redirect = new Redirection();
    @FXML
    private Label playerscore;
    @FXML
    private JFXButton playBtn;
    Stage stage;

    @FXML
    private JFXButton stopBtn;

    Parent root = null;

    @FXML
    private Label playerOneName;

    @FXML
    private Label playerTwoName;

    @FXML
    private JFXButton btn0;

    @FXML
    private JFXButton btn1;

    @FXML
    private JFXButton btn2;

    @FXML
    private JFXButton btn3;

    @FXML
    private JFXButton btn4;

    @FXML
    private JFXButton btn5;

    @FXML
    private JFXButton btn6;

    @FXML
    private JFXButton btn7;

    @FXML
    private JFXButton btn8;

    private JFXButton[] buttons = new JFXButton[9];

    Random random = new Random();
    boolean player1_turn;
    boolean tie_check = true;
    int pressedButtons = 0;

    @FXML
    private JFXButton backBtn;

    @FXML
    void back(ActionEvent event) throws IOException {
        redirect.redirction("StartMenu.fxml", event);
    }

    @FXML
    void play(ActionEvent event) {
        tictactoe.Tictactoe.mediaPlayer.play();
        playBtn.setVisible(false);
        stopBtn.setVisible(true);
    }

    @FXML
    void stop(ActionEvent event) {
        tictactoe.Tictactoe.mediaPlayer.stop();
        playBtn.setVisible(true);
        stopBtn.setVisible(false);
    }

    public void handleButtonAction(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        for (int i = 0; i < 9; i++) {
            if (event.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setStyle("-fx-text-fill: #FF533E");
                        buttons[i].setText("X");
                        player1_turn = false;

                        tie_check = check();
                        pressedButtons++;

                    }

                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setStyle("-fx-text-fill: #9B9FFA");
                        buttons[i].setText("O");
                        player1_turn = true;
                        //label.setText("X turn");

                        tie_check = check();
                        pressedButtons++;

                    }
                }
                if (pressedButtons == 9 && tie_check == false) {
                    tie();
                }
            }
        }
    }

    public void firstTurn() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;

        } else {
            player1_turn = false;

        }
    }

    public boolean check() {

        //check X win conditions
        if ((buttons[0].getText() == "X")
                && (buttons[1].getText() == "X")
                && (buttons[2].getText() == "X")) {

            xWins(0, 1, 2);
            return true;
        }

        if ((buttons[3].getText() == "X")
                && (buttons[4].getText() == "X")
                && (buttons[5].getText() == "X")) {

            xWins(3, 4, 5);
            return true;
        }

        if ((buttons[6].getText() == "X")
                && (buttons[7].getText() == "X")
                && (buttons[8].getText() == "X")) {

            xWins(6, 7, 8);
            return true;
        }

        if ((buttons[0].getText() == "X")
                && (buttons[3].getText() == "X")
                && (buttons[6].getText() == "X")) {

            xWins(0, 3, 6);
            return true;
        }

        if ((buttons[1].getText() == "X")
                && (buttons[4].getText() == "X")
                && (buttons[7].getText() == "X")) {

            xWins(1, 4, 7);
            return true;
        }

        if ((buttons[2].getText() == "X")
                && (buttons[5].getText() == "X")
                && (buttons[8].getText() == "X")) {

            xWins(2, 5, 8);
            return true;
        }

        if ((buttons[0].getText() == "X")
                && (buttons[4].getText() == "X")
                && (buttons[8].getText() == "X")) {

            xWins(0, 4, 8);
            return true;
        }

        if ((buttons[2].getText() == "X")
                && (buttons[4].getText() == "X")
                && (buttons[6].getText() == "X")) {

            xWins(2, 4, 6);
            return true;
        }

        //check O win conditions
        if ((buttons[0].getText() == "O")
                && (buttons[1].getText() == "O")
                && (buttons[2].getText() == "O")) {

            oWins(0, 1, 2);
            return true;
        }

        if ((buttons[3].getText() == "O")
                && (buttons[4].getText() == "O")
                && (buttons[5].getText() == "O")) {

            oWins(3, 4, 5);
            return true;
        }

        if ((buttons[6].getText() == "O")
                && (buttons[7].getText() == "O")
                && (buttons[8].getText() == "O")) {

            oWins(6, 7, 8);
            return true;
        }

        if ((buttons[0].getText() == "O")
                && (buttons[3].getText() == "O")
                && (buttons[6].getText() == "O")) {

            oWins(0, 3, 6);
            return true;
        }

        if ((buttons[1].getText() == "O")
                && (buttons[4].getText() == "O")
                && (buttons[7].getText() == "O")) {

            oWins(1, 4, 7);
            return true;
        }

        if ((buttons[2].getText() == "O")
                && (buttons[5].getText() == "O")
                && (buttons[8].getText() == "O")) {

            oWins(2, 5, 8);
            return true;
        }

        if ((buttons[0].getText() == "O")
                && (buttons[4].getText() == "O")
                && (buttons[8].getText() == "O")) {

            oWins(0, 4, 8);
            return true;
        }

        if ((buttons[2].getText() == "O")
                && (buttons[4].getText() == "O")
                && (buttons[6].getText() == "O")) {

            oWins(2, 4, 6);
            return true;
        }
        return false;
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setStyle("-fx-background-color: yellow; ");
        buttons[b].setStyle("-fx-background-color: yellow; ");
        buttons[c].setStyle("-fx-background-color: yellow; ");

        for (int i = 0; i < 9; i++) {
            buttons[i].setDisable(true);
        }
        tictactoe.Tictactoe.mediaPlayer.stop();
        winVideo(MultiplayerLocalController.playerOne);
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setStyle("-fx-background-color: #f0e54d; ");
        buttons[b].setStyle("-fx-background-color: #f0e54d; ");
        buttons[c].setStyle("-fx-background-color: #f0e54d; ");

        for (int i = 0; i < 9; i++) {
            buttons[i].setDisable(true);
        }
        
        int xscore = Integer.parseInt(playerscore.getText()) + 5;
        Integer xxscore = new Integer(xscore);
        String usernameScore = xscore + "," + tictactoe.LoginController.usernamePlayer;
        tictactoe.LoginController.score = xxscore.toString();
        playerscore.setText(xxscore.toString());
        out.println("insertscore");
        out.println(usernameScore);
        System.out.println(usernameScore);
        
        tictactoe.Tictactoe.mediaPlayer.stop();
        winVideo(MultiplayerLocalController.playerTwo);

    }

    public void tie() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setDisable(true);
        }
    }

    public void winVideo(String player) {
        try {
            root = FXMLLoader.load(getClass().getResource("MediaScreenWinner.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(TwoPlayersLocalPlayController.class.getName()).log(Level.SEVERE, null, ex);
        }
        root.getStylesheets().add(getClass().getResource("css/menu-background.css").toString());

        Scene scene = new Scene(root);
        stage.setTitle(player);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            socket = new Socket("localhost", 5005);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        buttons[0] = btn0;
        buttons[1] = btn1;
        buttons[2] = btn2;
        buttons[3] = btn3;
        buttons[4] = btn4;
        buttons[5] = btn5;
        buttons[6] = btn6;
        buttons[7] = btn7;
        buttons[8] = btn8;
        System.out.println(MultiplayerLocalController.playerOne);
        System.out.println(MultiplayerLocalController.playerTwo);
        playerOneName.setText(MultiplayerLocalController.playerOne);
        playerTwoName.setText(MultiplayerLocalController.playerTwo);
        playerscore.setText(tictactoe.LoginController.score);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText("");
        }

        firstTurn();

    }
}
