package client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * @author i
 */
public class TicTacToeAI {
    protected MediaPlayer videoForWinner;

    static ArrayList<Integer> PlayerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> CpuPositions = new ArrayList<Integer>();
    char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
    {'-', '+', '-', '+', '-'},
    {' ', '|', ' ', '|', ' '},
    {'-', '+', ' ', '+', '-'},
    {' ', '|', ' ', '|', ' '}};

    //funcction to check whether the position entered by the user is free or not
    public boolean checkPlayerPos(int position) {
        boolean status = true;
        int playerpos = position;
        if (PlayerPositions.contains(playerpos) || CpuPositions.contains(playerpos)) {
            System.out.println("Position taken! Enter a correct position");
            status = false;
        }
        if (status) {
            placePiece(gameBoard, playerpos, "player");
            printGameBoard(gameBoard);
        }
        return status;
    }

    //function to generate a random position for the cpu while checking this position is free or not
    public int CpuTurn() {
        Random rand = new Random();
        int CpuPos = rand.nextInt(9) + 1;
        while (PlayerPositions.contains(CpuPos) || CpuPositions.contains(CpuPos)) {
            CpuPos = rand.nextInt(9) + 1;
        }
        placePiece(gameBoard, CpuPos, "cpu");
        printGameBoard(gameBoard);
        return CpuPos;
    }

    //function to check if anybody won or a tie took place
    public String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);
        int i, j = 0;
        for (List l : winning) {
            if (PlayerPositions.containsAll(l)) {
                for (i = 0; i <= 4; i += 2) {
                    for (j = 0; j <= 4; j += 2) {
                        gameBoard[i][j] = ' ';
                    }
                }
                PlayerPositions.clear();
                CpuPositions.clear();
//               StackPane secondaryLayout2 = new StackPane();
//                             videoForWinner = new MediaPlayer( new Media(getClass().getResource("").toExternalForm()));
//                            MediaView mediaView2 = new MediaView(videoForWinner);
//                            secondaryLayout2.getChildren().addAll(mediaView2);
//                            Stage secondStage2 = new Stage();
//                            Scene secondScene2 = new Scene(secondaryLayout2, 900, 560);
//                            
//                                  secondStage2.setTitle("Congratulations");
//                            secondStage2.setResizable(false);
//                            secondStage2.setX(800);
//                            secondStage2.setY(60);
//                            secondStage2.setScene(secondScene2);
//                            secondStage2.show();
//                            videoForWinner.play();
                return "Congrats you won!";
                      
            } else if (CpuPositions.containsAll(l)) {
                for (i = 0; i <= 4; i += 2) {
                    for (j = 0; j <= 4; j += 2) {
                        gameBoard[i][j] = ' ';
                    }
                }
                PlayerPositions.clear();
                CpuPositions.clear();
//                          StackPane secondaryLayout2 = new StackPane();
//                             videoForWinner = new MediaPlayer( new Media(getClass().getResource("").toExternalForm()));
//                            MediaView mediaView2 = new MediaView(videoForWinner);
//                            secondaryLayout2.getChildren().addAll(mediaView2);
//                            Stage secondStage2 = new Stage();
//                            Scene secondScene2 = new Scene(secondaryLayout2, 900, 560);
//                            
//                                  secondStage2.setTitle("Congratulations");
//                            secondStage2.setResizable(false);
//                            secondStage2.setX(800);
//                            secondStage2.setY(60);
//                            secondStage2.setScene(secondScene2);
//                            secondStage2.show();
//                            videoForWinner.play();
                return "you lost, CPU Won!";
            } else if (PlayerPositions.size() + CpuPositions.size() == 9) {
                for (i = 0; i <= 4; i += 2) {
                    for (j = 0; j <= 4; j += 2) {
                        gameBoard[i][j] = ' ';
                    }
                }
                PlayerPositions.clear();
                CpuPositions.clear();
                
                
                
                return "No one won it's a tie";
            }
        }
        return "";
    }

    public void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = 'X';
        if (user.equals("player")) {
            symbol = 'X';
            PlayerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            CpuPositions.add(pos);
        }
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
        }
    }
}