/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_server;

import java.io.PrintWriter;

/**
 *
 * @author mohamed
 */
class User {
    String name;
    PrintWriter out;
    public Boolean isFree = true;

    public User(String givenName, PrintWriter givenOut) {
        name = givenName;
        out = givenOut;
    }
}
