/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import com.jfoenix.controls.JFXButton;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author i
 */
public class PlayingWithCompController implements Initializable {

    Image x = new Image("assets/x_1.png");
    Image o = new Image("assets/o_1.png");
    Image img;
    //int player; //flag to detect win player
    static String playerNickname;
    private int xCount = 0;
    private int oCount = 0;

    int[] clickChecker = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1};
    int[] playerPosition = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    private char[][] gameBoard = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    int flag = 1;
    int counter = 0;

    @FXML
    private JFXButton playBtn;

    @FXML
    private JFXButton stopBtn;
    @FXML
    private Label playerName;
    @FXML
    private ImageView topleft;
    @FXML
    private ImageView topcenter;
    @FXML
    private ImageView topright;
    @FXML
    private ImageView centerleft;
    @FXML
    private ImageView centercenter;
    @FXML
    private ImageView centerright;
    @FXML
    private ImageView bottomleft;
    @FXML
    private ImageView bottomcenter;
    @FXML
    private ImageView bottomright;

    private static PlayingWithCompController instance;
    @FXML
    private Font x1;

    public void computerMove() {
        System.out.println("hen fe computermove ");

        Random rgen = new Random();              // Computer

        if (rgen.nextBoolean()) {  // sometimes blocks when easy
            if (blockWin()) {
                return;
            }
        }

        if (playOppositeCorner()) {
            return;
        }
        if (playEmptyCorner()) {
            return;
        }
        playEmptySide();

    }

    // Plays an empty corner and returns true if move is made.
    private boolean playEmptyCorner() {
        System.out.println("hen fe playempty momken return false");
        if (gameBoard[0][0] == ' ') {
            makeMoveInSquare(0, 0);
            return true;
        } else if (gameBoard[0][2] == ' ') {
            makeMoveInSquare(0, 2);
            return true;
        } else if (gameBoard[2][0] == ' ') {
            makeMoveInSquare(2, 0);
            return true;
        } else if (gameBoard[2][2] == ' ') {
            makeMoveInSquare(2, 2);
            return true;
        }
        return false;
    }

    // Plays a corner opposite a corner already played by 'x'
    // and returns true if move is made.
    private boolean playOppositeCorner() {
        System.out.println("hen fe playOppositeCorner momken return false");
        if (gameBoard[0][0] == 'x' && gameBoard[2][2] == ' ') {
            makeMoveInSquare(2, 2);
            return true;
        } else if (gameBoard[2][2] == 'x' && gameBoard[0][0] == ' ') {
            makeMoveInSquare(0, 0);
            return true;
        } else if (gameBoard[0][2] == 'x' && gameBoard[2][0] == ' ') {
            makeMoveInSquare(2, 0);
            return true;
        } else if (gameBoard[2][0] == 'x' && gameBoard[0][2] == ' ') {
            makeMoveInSquare(0, 2);
            return true;
        }
        return false;
    }

    // Plays the center and returns true if move is made.
    private boolean playCenter() {
        System.out.println("hen fe playcenter momken return false");
        if (gameBoard[1][1] == ' ') {
            System.out.println("da5l el if w el mafrod gggggggggg");
            makeMoveInSquare(1, 1);
            return true;
        }
        return false;
    }

    private void playEmptySide() {
        System.out.println("hen fe emptyside momken return false");
        if (gameBoard[0][1] == ' ') {
            makeMoveInSquare(0, 1);
        } else if (gameBoard[1][0] == ' ') {
            makeMoveInSquare(1, 0);
        } else if (gameBoard[1][2] == ' ') {
            makeMoveInSquare(1, 2);
        } else if (gameBoard[2][1] == ' ') {
            makeMoveInSquare(2, 1);
        }
    }
// Prevents fork scenarios that allow x to win

    private boolean preventForkScenarios() {
        System.out.println("hen fe preventForkScenarios momken return false");
        if (counter == 3) {
            if (gameBoard[0][0] == 'x' && gameBoard[1][1] == 'o' && gameBoard[2][2] == 'x') {
                playEmptySide();
                return true;
            }
            if (gameBoard[2][0] == 'x' && gameBoard[1][1] == 'o' && gameBoard[0][2] == 'x') {
                playEmptySide();
                return true;
            }
            if (gameBoard[2][1] == 'x' && gameBoard[1][2] == 'x') {
                makeMoveInSquare(2, 2);
                return true;
            }
        }
        return false;
    }

    private boolean blockWin() {
        System.out.println("hen fe blockwin ");
        return false;
    }

    public void makeMoveInSquare(int row, int col) {  //hena h3ml nestedloop check beha 3la el makan elly el mafrod a7d feh el img bt3ati
        System.out.println("hen fe makeMoveInSquare ");
        gameBoard[row][col] = 'o';
        //img = o;
        //check squre empty or not
        if (row == 0 && col == 0) {
            //need to detect position that i will set img in 
            topleft.setImage(setImage());
        }
        if (row == 0 && col == 1) {
            //need to detect position that i will set img in 
            topcenter.setImage(setImage());
        }
        if (row == 0 && col == 2) {
            //need to detect position that i will set img in 
            topright.setImage(setImage());
        }
        if (row == 1 && col == 0) {
            //need to detect position that i will set img in 
            centerleft.setImage(setImage());
        }
        if (row == 1 && col == 1) {
            //need to detect position that i will set img in 
            centercenter.setImage(setImage());
        }
        if (row == 1 && col == 2) {
            //need to detect position that i will set img in 
            centerright.setImage(setImage());
        }
        if (row == 2 && col == 0) {
            //need to detect position that i will set img in 
            bottomleft.setImage(setImage());
        }
        if (row == 2 && col == 1) {
            //need to detect position that i will set img in 
            bottomcenter.setImage(setImage());
        }
        if (row == 2 && col == 2) {
            //need to detect position that i will set img in 
            bottomright.setImage(setImage());
        }
    }

    private Image setImage() {

        System.out.println("set img befoer inc  " + counter);
        if (counter % 2 == 0) {
            img = x;
        } else {
            img = o;
        }

        counter++;
        return img;

    }

    private void alertMsg(String w) {

        try {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            if (w == "X" || w == "O") {
                alert.setContentText("play " + w + " is winner \n score X : " + xCount + "\n score O : " + oCount);

            } else {

                alert.setContentText(w);
            }
            alert.showAndWait();

        } catch (Exception e) {
            System.out.println("error in alert");
        }
    }

    private void reset() {
        try {
            topleft.setImage(null);
            topcenter.setImage(null);
            topright.setImage(null);

            centerleft.setImage(null);
            centercenter.setImage(null);
            centerright.setImage(null);

            bottomleft.setImage(null);
            bottomcenter.setImage(null);
            bottomright.setImage(null);

            counter = 0;

            // Arrays.fill(clickChecker,1);
            for (int i = 0; i < 9; i++) {
                clickChecker[i] = 1;
                playerPosition[i] = 0;
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    gameBoard[i][j] = ' ';
                }
            }

        } catch (Exception e) {
            System.out.println("error in reset");
        }
        flag = 0;
    }

    private void winningGame() {
        System.out.println("win check  " + counter);

        Image b1 = topleft.getImage();
        Image b2 = topcenter.getImage();
        Image b3 = topright.getImage();

        Image b4 = centerleft.getImage();
        Image b5 = centercenter.getImage();
        Image b6 = centerright.getImage();

        Image b7 = bottomleft.getImage();
        Image b8 = bottomcenter.getImage();
        Image b9 = bottomright.getImage();

        try {
            if (b1 == x && b2 == x && b3 == x) {
                xCount++;
                alertMsg("X");

                reset();

                //   gameScore();
            } else if (b4 == x && b5 == x && b6 == x) {

                xCount++;
                alertMsg("X");

                reset();

                //gameScore();
            } else if (b7 == x && b8 == x && b9 == x) {
                xCount++;
                alertMsg("X");

                reset();

                //gameScore();
            } else if (b1 == x && b4 == x && b7 == x) {
                xCount++;
                alertMsg("X");

                reset();

                //gameScore();
            } else if (b2 == x && b5 == x && b8 == x) {
                xCount++;
                alertMsg("X");

                reset();

                //gameScore();
            } else if (b3 == x && b6 == x && b9 == x) {
                xCount++;
                alertMsg("X");

                reset();

                //gameScore();
            } else if (b1 == x && b5 == x && b9 == x) {
                xCount++;
                alertMsg("X");

                reset();
                //gameScore();
            } else if (b3 == x && b5 == x && b7 == x) {
                xCount++;
                alertMsg("X");
                reset();
                //gameScore();
            } //player O
            else if (b1 == o && b2 == o && b3 == o) {
                oCount++;
                alertMsg("O");
                reset();
                //gameScore()
            } else if (b4 == o && b5 == o && b6 == o) {
                oCount++;
                alertMsg("O");
                reset();
                //gameScore()
            } else if (b7 == o && b8 == o && b9 == o) {
                oCount++;
                alertMsg("O");
                //gameScore()
            } else if (b1 == o && b4 == o && b7 == o) {
                oCount++;
                alertMsg("O");
                reset();
                //gameScore()
            } else if (b2 == o && b5 == o && b8 == o) {
                oCount++;
                alertMsg("O");
                reset();
                //gameScore()
            } else if (b3 == o && b6 == o && b9 == o) {
                oCount++;
                alertMsg("O");
                reset();
                //gameScore()
            } else if (b1 == o && b5 == o && b9 == o) {
                oCount++;
                alertMsg("O");
                reset();
                //gameScore();
            } else if (b3 == o && b5 == o && b7 == o) {
                oCount++;
                alertMsg("O");
                reset();
                //gameScore()
            } else if (clickChecker[0] == 0 && clickChecker[1] == 0 && clickChecker[2] == 0 && clickChecker[3] == 0 && clickChecker[4] == 0 && clickChecker[5] == 0 && clickChecker[6] == 0 && clickChecker[7] == 0 && clickChecker[8] == 0) {
                alertMsg("NO player wins");
                reset();
            }
        } catch (Exception e) {
            System.out.println("clicked");
        }
        if (counter == 9) {
            alertMsg(" equal state no one win  ");
            reset();
            return;
        }

    }

    @FXML
    public void drawTopLeft() throws FileNotFoundException {
//        Client client = new Client("playWithOther","0","1",onlinePlayer.getValue().toString());
        System.out.println(playerNickname + "essssssslam");
        if (clickChecker[0] == 1) {
            topleft.setImage(setImage());
            if (img == x) {
                playerPosition[0] = 1;
                gameBoard[0][0] = 'x';

            } else {
                playerPosition[0] = 2;
            }

            clickChecker[0] = 0;
            winningGame();
            if (flag == 1) {
                computerMove();
                winningGame();
            }
            flag = 1;
        }

    }

    @FXML
    private void drawTopCenter() throws FileNotFoundException {

        if (clickChecker[1] == 1) {
            topcenter.setImage(setImage());
            if (img == x) {
                playerPosition[1] = 1;
                gameBoard[0][1] = 'x';
            } else {
                playerPosition[1] = 2;
            }
            clickChecker[1] = 0;
            winningGame();
            if (flag == 1) {
                computerMove();
                winningGame();
            }
            flag = 1;
        }

    }

    @FXML
    private void drawTopRight() throws FileNotFoundException {

        if (clickChecker[2] == 1) {
            topright.setImage(setImage());
            if (img == x) {
                playerPosition[2] = 1;
                gameBoard[0][2] = 'x';
            } else {
                playerPosition[2] = 2;
            }
            clickChecker[2] = 0;
            winningGame();
            if (flag == 1) {
                computerMove();
                winningGame();
            }
            flag = 1;
        }

    }

    @FXML
    private void drawCenterLeft() throws FileNotFoundException {

        if (clickChecker[3] == 1) {
            centerleft.setImage(setImage());
            if (img == x) {
                playerPosition[3] = 1;
                gameBoard[1][0] = 'x';
            } else {
                playerPosition[3] = 2;
            }
            winningGame();
            clickChecker[3] = 0;
            if (flag == 1) {
                computerMove();
                winningGame();
            }
            flag = 1;
        }

    }

    @FXML
    private void drawCenterCenter() throws FileNotFoundException {

        if (clickChecker[4] == 1) {
            centercenter.setImage(setImage());
            if (img == x) {
                playerPosition[4] = 1;
                gameBoard[1][1] = 'x';
            } else {
                playerPosition[4] = 2;
            }
            clickChecker[4] = 0;
            winningGame();
            if (flag == 1) {
                computerMove();
                winningGame();
            }
            flag = 1;
        }

    }

    @FXML
    private void drawCenterRight() throws FileNotFoundException {

        if (clickChecker[5] == 1) {
            centerright.setImage(setImage());
            if (img == x) {
                playerPosition[5] = 1;
                gameBoard[1][2] = 'x';
            } else {
                playerPosition[5] = 2;
            }
            clickChecker[5] = 0;
            winningGame();
            if (flag == 1) {
                computerMove();
                winningGame();
            }
            flag = 1;
        }

    }

    @FXML
    private void drawBottomLeft() throws FileNotFoundException {

        if (clickChecker[6] == 1) {
            bottomleft.setImage(setImage());
            if (img == x) {
                playerPosition[6] = 1;
                gameBoard[2][0] = 'x';
            } else {
                playerPosition[6] = 2;
            }
            clickChecker[6] = 0;
            winningGame();
            if (flag == 1) {
                computerMove();
                winningGame();
            }
            flag = 1;
        }

    }

    @FXML
    private void drawBottomCenter() throws FileNotFoundException {

        if (clickChecker[7] == 1) {
            bottomcenter.setImage(setImage());
            if (img == x) {
                playerPosition[7] = 1;
                gameBoard[2][1] = 'x';
            } else {
                playerPosition[7] = 2;
            }
            clickChecker[7] = 0;
            winningGame();
            if (flag == 1) {
                computerMove();
                winningGame();
            }
            flag = 1;
        }

    }

    @FXML
    private void drawBottomRight() throws FileNotFoundException {

        if (clickChecker[8] == 1) {
            bottomright.setImage(setImage());
            if (img == x) {
                playerPosition[8] = 1;
                gameBoard[2][2] = 'x';
            } else {
                playerPosition[8] = 2;
            }
            clickChecker[8] = 0;
            winningGame();
            if (flag == 1) {
                computerMove();
                winningGame();
            }
            flag = 1;

        }
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(SingleController.playername);
        playerName.setText(SingleController.playername);
    }

}
