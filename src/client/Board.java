
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author i
 */
import java.util.Arrays;

public class Board{

    private String[][] board = new String[3][3];
    private String status = "Tie";
    Board() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                this.board[i][j] = "-";
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return (row < board.length && col < board.length && board[row][col].equals("-"));
    }

    public void makeMove(int row, int col, String s) {
        if (isValidMove(row,col))
            this.board[row][col] = s;
    }

    public String getTile(int row, int col) {
        return board[row][col];
    }
    public String getStatus() {
        String[] logicXO = new String[9];
        boolean tie = true;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                logicXO[count] = board[i][j];
                count++;
                if (board[i][j].equals("-")) tie = false;
            }
        }

        // diagonal from 0,0
        if (logicXO[0].equals("X") && logicXO[4].equals("X") && logicXO[8].equals("X")) return "X";
        if (logicXO[0].equals("O") && logicXO[4].equals("O") && logicXO[8].equals("O")) return "O";
        // diagonal from 0, 2
        if (logicXO[2].equals("X") && logicXO[4].equals("X") && logicXO[6].equals("X")) return "X";
        if (logicXO[2].equals("O") && logicXO[4].equals("O") && logicXO[6].equals("O")) return "O";
        // first row
        if (logicXO[0].equals("X") && logicXO[1].equals("X") && logicXO[2].equals("X")) return "X";
        if (logicXO[0].equals("O") && logicXO[1].equals("O") && logicXO[2].equals("O")) return "O";
        // second row
        if (logicXO[3].equals("X") && logicXO[4].equals("X") && logicXO[5].equals("X")) return "X";
        if (logicXO[3].equals("O") && logicXO[4].equals("O") && logicXO[5].equals("O")) return "O";
        // third row
        if (logicXO[6].equals("X") && logicXO[7].equals("X") && logicXO[8].equals("X")) return "X";
        if (logicXO[6].equals("O") && logicXO[7].equals("O") && logicXO[8].equals("O")) return "O";
        // first column
        if (logicXO[0].equals("X") && logicXO[3].equals("X") && logicXO[6].equals("X")) return "X";
        if (logicXO[0].equals("O") && logicXO[3].equals("O") && logicXO[6].equals("O")) return "O";
        // second column
        if (logicXO[1].equals("X") && logicXO[4].equals("X") && logicXO[7].equals("X")) return "X";
        if (logicXO[1].equals("O") && logicXO[4].equals("O") && logicXO[7].equals("O")) return "O";
        // third column
        if (logicXO[2].equals("X") && logicXO[5].equals("X") && logicXO[8].equals("X")) return "X";
        if (logicXO[2].equals("O") && logicXO[5].equals("O") && logicXO[8].equals("O")) return "O";

        if (tie) return "tie";
        return "NONE";
    }

    @Override
    public String toString() {
        return Arrays.toString(board[0]) + "\n" + Arrays.toString(board[1]) + "\n" + Arrays.toString(board[2]);
    }

}
