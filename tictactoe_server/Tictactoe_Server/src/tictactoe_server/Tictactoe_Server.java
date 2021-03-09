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
         * Constructs a handler thread, squirreling away the socket. All the interesting
         * work is done in the run method. Remember the constructor is called from the
         * server's main method, so this has to be as short as possible.
         */
        public Handler(Socket socket) {
            this.socket = socket;
        }

        /**
         * Services this thread's client by repeatedly requesting a screen name until a
         * unique one has been submitted, then acknowledges the name and registers the
         * output stream for the client in a global set, then repeatedly gets inputs and
         * broadcasts them.
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
                        if(sql.signUp(username, password)){
                            // send the result
                            out.println("true");
                        }else{
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
                        if(sql.login(username, password)){
                            // send the result
                            out.println("true");
                            // if true add to active
                            loggedInUsers.put(choice.split(",")[0], new User(choice.split(",")[0], out));
                        }else{
                            // send the result
                            out.println("false");
                        }                        
                    } else if (choice.equals("getLogedIn")) {
                        String users = "";
                        for (String name : loggedInUsers.keySet())
                            users = name + users;

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
                    }else if (choice.equals("logout")) {
                        String user = in.nextLine();
                        loggedInUsers.remove(user);

                        // call the database

                        // send the result
                        out.println("true");
                    }
                     else {
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
