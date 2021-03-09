/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
//import java.awt.Font;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author mohamed
 */
public class TwoPlayersLocalPlayController implements Initializable{
     
    @FXML
    private Label label;

    @FXML
    private Button btn0;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;
    
    private Button[] buttons = new Button[9];
    
    Random random = new Random();
    boolean player1_turn;
    boolean tie_check=true;
    int pressedButtons=0;
    
    public void handleButtonAction(ActionEvent event) {
    
        for (int i = 0; i < 9; i++) {
            //buttons[i].setFocusable(false);
            if (event.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setStyle("-fx-text-fill: blue");
                        buttons[i].setText("X");
                        player1_turn = false;
                        label.setText("O turn");

                        tie_check = check();
                        pressedButtons++;

                    }

                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setStyle("-fx-text-fill: red");
                        buttons[i].setText("O");
                        player1_turn = true;
                        label.setText("X turn");

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
        //System.out.println("first turn test");
        label.setText("Tic-Tac-Toe");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            label.setText("X turn");

        } else {
            player1_turn = false;
            label.setText("O turn");
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
        buttons[a].setStyle("-fx-background-color: #1aff00; ");
        buttons[b].setStyle("-fx-background-color: #1aff00; ");
        buttons[c].setStyle("-fx-background-color: #1aff00; ");

        for (int i = 0; i < 9; i++) {
            buttons[i].setDisable(true);
        }
        
        label.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setStyle("-fx-background-color: #1aff00; ");
        buttons[b].setStyle("-fx-background-color: #1aff00; ");
        buttons[c].setStyle("-fx-background-color: #1aff00; ");
        
        for (int i = 0; i < 9; i++) {
            buttons[i].setDisable(true);
        }

        label.setText("O wins");
    }
    
    public void tie() {
     for (int i = 0; i < 9; i++) {
            buttons[i].setDisable(true);
        }

        label.setText("Tie");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        buttons[0]= btn0 ;
        buttons[1]= btn1 ;
        buttons[2]= btn2 ;
        buttons[3]= btn3 ;
        buttons[4]= btn4 ;
        buttons[5]= btn5 ;
        buttons[6]= btn6 ;
        buttons[7]= btn7 ;
        buttons[8]= btn8 ;
       
        firstTurn();
    }
}
