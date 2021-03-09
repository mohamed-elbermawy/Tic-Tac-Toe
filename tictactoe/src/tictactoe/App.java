package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A simple Swing-based client for the chat server. Graphically it is a frame
 * with a text field for entering messages and a textarea to see the whole
 * dialog.
 *
 * The client follows the following Chat Protocol. When the server sends
 * "SUBMITNAME" the client replies with the desired screen name. The server will
 * keep sending "SUBMITNAME" requests as long as the client submits screen names
 * that are already in use. When the server sends a line beginning with
 * "NAMEACCEPTED" the client is now allowed to start sending the server
 * arbitrary strings to be broadcast to all chatters connected to the server.
 * When the server sends a line beginning with "MESSAGE" then all characters
 * following this string should be displayed in its message area.
 */
public class App {

    String serverAddress;
    Scanner in;
    PrintWriter out;
    String name;

    /**
     * Constructs the client by laying out the GUI and registering a listener with
     * the textfield so that pressing Return in the listener sends the textfield
     * contents to the server. Note however that the textfield is initially NOT
     * editable, and only becomes editable AFTER the client receives the
     * NAMEACCEPTED message from the server.
     */

    public App(String serverAddress) {
        this.serverAddress = serverAddress;
        try {
            Socket socket = new Socket(serverAddress, 5005);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

        } catch (Exception e) {
            System.out.println(e);
        } finally {

        }

    }

    public String login(String uname, String upass) {
        String line;
        out.println("login");
        name=uname;
        out.println(uname + "," + upass);
        line = in.nextLine();
        return line;
    }

    public String signUp(String name, String pass) {
        String line;
        out.println("register");
        out.println(name + "," + pass);
        line = in.nextLine();
        return line;
    }

    public String getLogedIn() {
        String line;
        out.println("getLogedIn");
        line = in.nextLine();
        return line;
    }

    public String logout() {
        String line;
        out.println("logout");
        out.println(name);
        line = in.nextLine();
        return line;
    }

    public String comunicate(String name, String message) {
        String line;
        out.println("comunicate");
        out.println(name);
        out.println(message);
        line = in.nextLine();
        return line;
    }

}


