/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_server;

import java.util.Arrays;

/**
 *
 * @author mohamed
 */
public class Game {
    private Player[] board = new Player[9];

    Player currentPlayer;

    public Game(Player initiator) {
        this.currentPlayer = initiator;
        this.setup();
    }

    private void setup() {
        currentPlayer.player.out.println("WELCOME " + currentPlayer.mark);
        // if (currentPlayer.mark == "X") {
        // currentPlayer = this;
        currentPlayer.player.out.println("MESSAGE Waiting for opponent to connect");
        // }
        // else {
        // opponent = currentPlayer;
        // opponent.opponent = this;
        // opponent.output.println("MESSAGE Your move");
        // }
    }

    public boolean hasWinner() {
        return (board[0] != null && board[0] == board[1] && board[0] == board[2])
                || (board[3] != null && board[3] == board[4] && board[3] == board[5])
                || (board[6] != null && board[6] == board[7] && board[6] == board[8])
                || (board[0] != null && board[0] == board[3] && board[0] == board[6])
                || (board[1] != null && board[1] == board[4] && board[1] == board[7])
                || (board[2] != null && board[2] == board[5] && board[2] == board[8])
                || (board[0] != null && board[0] == board[4] && board[0] == board[8])
                || (board[2] != null && board[2] == board[4] && board[2] == board[6]);
    }

    public boolean boardFilledUp() {
        return Arrays.stream(board).allMatch(p -> p != null);
    }

    public synchronized void move(int location, Player player) {
        if (player != currentPlayer) {
            throw new IllegalStateException("Not your turn");
        } else if (player.opponent == null) {
            throw new IllegalStateException("You don't have an opponent yet");
        } else if (board[location] != null) {
            throw new IllegalStateException("Cell already occupied");
        }
        board[location] = currentPlayer;
        currentPlayer = currentPlayer.opponent;
    }

    public void processMoveCommand(int location,Player player) {
        try {
            System.out.println("location"+location);
            this.move(location,player);
            currentPlayer.player.out.println("VALID_MOVE");
            currentPlayer.opponent.player.out.println("OPPONENT_MOVED " + location);
            if (hasWinner()) {
                currentPlayer.player.out.println("VICTORY");
                currentPlayer.opponent.player.out.println("DEFEAT");
            } else if (boardFilledUp()) {
                currentPlayer.player.out.println("TIE");
                currentPlayer.opponent.player.out.println("TIE");
            } 
        } catch (IllegalStateException e) {
            currentPlayer.player.out.println("MESSAGE " + e.getMessage());
        }
    }
}
