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
public class Player {

    public User player;
    public String mark;
    public Player opponent;

    public Player(User _player, String _mark) {
        this.player = _player;
        this.mark = _mark;
    }

}
