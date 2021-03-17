/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author mohamed
 */
public class Tictactoe_Server {

    /**
     * @param args the command line arguments
     */
    private static SqlHandler sql = new SqlHandler();

    private static HashMap<String, User> loggedInUsers = new HashMap<>();
    public static HashMap<String, OnlineGame> onlineGames = new HashMap<>();

    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running...");
        ExecutorService pool = Executors.newFixedThreadPool(500);
        try (ServerSocket listener = new ServerSocket(5005)) {
            while (true) {
                pool.execute(new Handler(listener.accept()));
            }
        }
    }

    /**
     * The client handler task.
     */
    private static class Handler implements Runnable {

        private Socket socket;
        private Scanner in;
        private PrintWriter out;
        private String choice;

        /**
         * Constructs a handler thread, squirreling away the socket. All the
         * interesting work is done in the run method. Remember the constructor
         * is called from the server's main method, so this has to be as short
         * as possible.
         */
        public Handler(Socket socket) {
            this.socket = socket;
        }

        /**
         * Services this thread's client by repeatedly requesting a screen name
         * until a unique one has been submitted, then acknowledges the name and
         * registers the output stream for the client in a global set, then
         * repeatedly gets inputs and broadcasts them.
         */
        public void run() {
            try {

                in = new Scanner(socket.getInputStream());
                out = new PrintWriter(socket.getOutputStream(), true);

                // out.println("Enter Choice");
                while (true) {
                    choice = in.nextLine();
                    if (choice.equals("register")) {
                        choice = in.nextLine();
                        // get username
                        System.out.println(choice.split(",")[0]);
                        String username = choice.split(",")[0];
                        System.out.println("yarab");
                        // get password
                        System.out.println(choice.split(",")[1]);
                        String password = choice.split(",")[1];

                        // call the database
                        if (sql.signUp(username, password)) {
                            // send the result
                            out.println("true");
                        } else {
                            // send the result
                            out.println("false");
                        }
                    } else if (choice.equals("login")) {
                        choice = in.nextLine();
                        // get username
                        System.out.println(choice.split(",")[0]);
                        String username = choice.split(",")[0];
                        System.out.println("yarab");
                        // get password
                        System.out.println(choice.split(",")[1]);
                        String password = choice.split(",")[1];
                        // call the database
                        if (sql.login(username, password)) {
                            // send the result
                            out.println("true");
                            // if true add to active
                            loggedInUsers.put(choice.split(",")[0], new User(choice.split(",")[0], out));
                        } else {
                            // send the result
                            out.println("false");
                        }
                    } else if (choice.equals("getLogedIn")) {
                        String users = "";
                        for (String name : loggedInUsers.keySet()) {
                            users = name + users;
                        }

                        // send the result
                        out.println(users);
                        System.out.print(users);
                    } else if (choice.equals("comunicate")) {
                        //get user
                        String toUser = in.nextLine();
                        // get message
                        String message = in.nextLine();

                        System.out.print(toUser);
                        System.out.print(message);

                        loggedInUsers.get(toUser).out.println(message);

                        // call the database
                        // send the result
                        out.println("true");
                    } else if (choice.equals("logout")) {
                        String user = in.nextLine();
                        loggedInUsers.remove(user);

                        // call the database
                        // send the result
                        out.println("true");
                    } else if (choice.equals("init2Game")) {
                        // get the data from the message
                        String message = in.nextLine();
                        System.out.println(message);
                        String player1Name = message.split(",")[0];
                        String player2Name = message.split(",")[1];
                        System.out.println("initGame" + player1Name + player2Name);
                        User user1 = loggedInUsers.get(player1Name);
                        user1.isFree = false;
                        User user2 = loggedInUsers.get(player2Name);
                        Player player1 = new Player(user1, "X");
                        System.err.println();
//                        player1.player.out.println(player1.mark);
                        System.out.println(player1.mark);
                        user1.out.println("X");
                        // put a game opject to the onlinegames hash map
                        onlineGames.put(player1Name, new OnlineGame(player1));
                        // send message to the next user to accept the game
                        String toSendMessage = "INVITE" + " " + player1Name;
                        user2.out.println(toSendMessage);
                    } else if (choice.equals("accept2Game")) {
                        // get the data from the message
                        String message = in.nextLine();
                        System.out.println("accept2Game handler" + message);
                        String player1Name = message.split(",")[0];
                        String player2Name = message.split(",")[1];
                        User user1 = loggedInUsers.get(player1Name);
                        User user2 = loggedInUsers.get(player2Name);
                        // put the second player in the game
                        OnlineGame new2playerGame = onlineGames.get(player1Name);
                        Player player2 = new Player(user2, "O");
                        player2.player.out.println("O");
                        new2playerGame.player2 = player2;
                        // start the game
                        Game game = new Game(onlineGames.get(player1Name).player1);
                        // put it in the hashmap
                        onlineGames.get(player1Name).game = game;
                        System.out.println("accepted");
                    } else if (choice.equals("2playerCommunicate")) {
                        // get the data from the message the game is defined by the first player
                        String gameName = in.nextLine();
                        System.out.println("gameName" + gameName);
                        OnlineGame onlineGame = onlineGames.get(gameName);
                        Game game = onlineGame.game;
                        // get the data from the message the game is defined by the first player
                        String playerName = in.nextLine();
                        System.out.println("playerName" + playerName);
                        Player player;
                        String message = in.nextLine();
                        System.out.println("message" + message);
                        if (onlineGame.player1.player.name == playerName) {
                            player = onlineGame.player1;
                        } else {
                            player = onlineGame.player2;
                        }
                        if (message.startsWith("MOVE")) {
                            System.out.println("heeeeeeeeeeeeeeer");
                            game.processMoveCommand(Integer.parseInt(message.substring(5)), player);
                        }

                    } else {
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            } finally {

                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }

}
