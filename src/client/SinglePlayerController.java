/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author i
 */
public class SinglePlayerController implements Initializable {

    
     TicTacToeAI cpu = new TicTacToeAI();
    boolean GameOver = false;

    @FXML
    private Label winloselabel;
    @FXML
    private Button b1;
    @FXML
    private Button b4;
    @FXML
    private Button b7;
    @FXML
    private Button b2;
    @FXML
    private Button b5;
    @FXML
    private Button b8;
    @FXML
    private Button b6;
    @FXML
    private Button b9;
    @FXML
    private Button b3;
    public Button[] buttons = new Button[9];
    @FXML
    private Label playerChoice;
    @FXML
    private Label playerChoice1;
    @FXML
    private Button replayBtn;
    @FXML
    private Button vollome;
    @FXML
    private Button small;
    @FXML
    private Button exitBtn1;

 
    public void init() {
        buttons[0] = b1;
        buttons[1] = b2;
        buttons[2] = b3;
        buttons[3] = b4;
        buttons[4] = b5;
        buttons[5] = b6;
        buttons[6] = b7;
        buttons[7] = b8;
        buttons[8] = b9;
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


     @FXML
    private void b1pressed(ActionEvent event) {
        //first check whether the game is over or the position chosenis not available
        if (GameOver == false && cpu.checkPlayerPos(1)) {
            b1.setText("X");
            //check if the player won so the cpu will play or not
            String result = cpu.checkWinner();
            if (result == "") {
                //the game is not over yet, allow the computer to play its turn
                int pos = cpu.CpuTurn();
                init();
                for (int i = 0; i <= 9; i++) {
                    if (i == pos) {
                        buttons[i - 1].setText("O");
                    }
                }
                result = cpu.checkWinner();
                if (result != "") {
                    GameOver = true;
                    winloselabel.setText(result);

                }
            } else {
                GameOver = true;
                winloselabel.setText(result);
            }
        }
    }

    @FXML
    private void b2pressed(ActionEvent event) {
        if (GameOver == false && cpu.checkPlayerPos(2)) {
            b2.setText("X");
            //check if the player won so the cpu will play or not
            String result = cpu.checkWinner();
            if (result == "") {
                int pos = cpu.CpuTurn();
                init();
                for (int i = 0; i <= 9; i++) {
                    if (i == pos) {
                        buttons[i - 1].setText("O");
                    }
                }
                result = cpu.checkWinner();
                if (result != "") {
                    GameOver = true;
                    winloselabel.setText(result);
                }
            } else {
                GameOver = true;
                winloselabel.setText(result);
            }
        }

    }

    @FXML
    private void b3pressed(ActionEvent event) {
        if (GameOver == false && cpu.checkPlayerPos(3)) {
            b3.setText("X");
            //check if the player won so the cpu will play or not
            String result = cpu.checkWinner();
            if (result == "") {
                int pos = cpu.CpuTurn();
                init();
                for (int i = 0; i <= 9; i++) {
                    if (i == pos) {
                        buttons[i - 1].setText("O");
                    }
                }
                result = cpu.checkWinner();
                if (result != "") {
                    GameOver = true;
                    winloselabel.setText(result);
                }
            } else {
                GameOver = true;
                winloselabel.setText(result);
            }
        }

    }

    @FXML
    private void b4pressed(ActionEvent event) {
        if (GameOver == false && cpu.checkPlayerPos(4)) {
            b4.setText("X");
            //check if the player won so the cpu will play or not
            String result = cpu.checkWinner();
            if (result == "") {
                int pos = cpu.CpuTurn();
                init();
                for (int i = 0; i <= 9; i++) {
                    if (i == pos) {
                        buttons[i - 1].setText("O");
                    }
                }
                result = cpu.checkWinner();
                if (result != "") {
                    GameOver = true;
                    winloselabel.setText(result);
                }
            } else {
                GameOver = true;
                winloselabel.setText(result);
            }
        }

    }

    @FXML
    private void b5pressed(ActionEvent event) {
        if (GameOver == false && cpu.checkPlayerPos(5)) {
            b5.setText("X");
            //check if the player won so the cpu will play or not
            String result = cpu.checkWinner();
            if (result == "") {
                int pos = cpu.CpuTurn();
                init();
                for (int i = 0; i <= 9; i++) {
                    if (i == pos) {
                        buttons[i - 1].setText("O");
                    }
                }
                result = cpu.checkWinner();
                if (result != "") {
                    GameOver = true;
                    winloselabel.setText(result);
                }
            } else {
                GameOver = true;
                winloselabel.setText(result);
            }
        }

    }

    @FXML
    private void b6pressed(ActionEvent event) {
        if (GameOver == false && cpu.checkPlayerPos(6)) {
            b6.setText("X");
            //check if the player won so the cpu will play or not
            String result = cpu.checkWinner();
            if (result == "") {
                int pos = cpu.CpuTurn();
                init();
                for (int i = 0; i <= 9; i++) {
                    if (i == pos) {
                        buttons[i - 1].setText("O");
                    }
                }
                result = cpu.checkWinner();
                if (result != "") {
                    GameOver = true;
                    winloselabel.setText(result);
                }
            } else {
                GameOver = true;
                winloselabel.setText(result);
            }
        }

    }

    @FXML
    private void b7pressed(ActionEvent event) {
        if (GameOver == false && cpu.checkPlayerPos(7)) {
            b7.setText("X");
            //check if the player won so the cpu will play or not
            String result = cpu.checkWinner();
            if (result == "") {
                int pos = cpu.CpuTurn();
                init();
                for (int i = 0; i <= 9; i++) {
                    if (i == pos) {
                        buttons[i - 1].setText("O");
                    }
                }
                result = cpu.checkWinner();
                if (result != "") {
                    GameOver = true;
                    winloselabel.setText(result);
                }
            } else {
                GameOver = true;
                winloselabel.setText(result);
            }
        }

    }

    @FXML
    private void b8pressed(ActionEvent event) {
        if (GameOver == false && cpu.checkPlayerPos(8)) {
            b8.setText("X");
            //check if the player won so the cpu will play or not
            String result = cpu.checkWinner();
            if (result == "") {
                int pos = cpu.CpuTurn();
                init();
                for (int i = 0; i <= 9; i++) {
                    if (i == pos) {
                        buttons[i - 1].setText("O");
                    }
                }
                result = cpu.checkWinner();
                if (result != "") {
                    GameOver = true;
                    winloselabel.setText(result);
                }
            } else {
                GameOver = true;
                winloselabel.setText(result);
            }
        }

    }

    @FXML
    private void b9pressed(ActionEvent event) {
        if (GameOver == false && cpu.checkPlayerPos(9)) {
            b9.setText("X");
            //check if the player won so the cpu will play or not
            String result = cpu.checkWinner();
            if (result == "") {
                int pos = cpu.CpuTurn();
                init();
                for (int i = 0; i <= 9; i++) {
                    if (i == pos) {
                        buttons[i - 1].setText("O");
                    }
                }
                result = cpu.checkWinner();
                if (result != "") {
                    GameOver = true;
                    winloselabel.setText(result);
                }
            } else {
                GameOver = true;
                winloselabel.setText(result);
            }
        }

    }

    @FXML
    private void replayPressed(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("SinglePlayer.fxml"));
        Scene scene = new Scene(root);
        Main.mystage.setScene(scene);
    }

    @FXML
    private void exitPressed(ActionEvent event) {

              
//         Parent root = FXMLLoader.load(getClass().getResource(""));
//        Scene scene = new Scene(root);
//        Main.mystage.setScene(scene);

    }
    
}
