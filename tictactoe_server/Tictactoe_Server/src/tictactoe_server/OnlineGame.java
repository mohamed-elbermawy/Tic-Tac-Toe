/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_server;

/**
 *
 * @author mohamed
 */
public class OnlineGame {
    // public String player1;
    // public String player2;
    public Player player1;
    public Player player2;
    public Game game;
    // public static String player1Mark = "X";
    // public static String player2Mark = "O";

    public OnlineGame(Player initiator) {
        player1 = initiator;
    }
}
