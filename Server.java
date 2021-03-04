import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.HashMap;

/**
 * A server for a multi-player tic tac toe game. Loosely based on an example in
 * Deitel and Deitel’s “Java How to Program” book. For this project I created a
 * new application-level protocol called TTTP (for Tic Tac Toe Protocol), which
 * is entirely plain text. The messages of TTTP are:
 *
 * Client -> Server MOVE <n> QUIT
 *
 * Server -> Client WELCOME <char> VALID_MOVE OTHER_PLAYER_MOVED <n>
 * OTHER_PLAYER_LEFT VICTORY DEFEAT TIE MESSAGE <text>
 */

/*
 *
 * do registeration do login get login do comunication
 *
 */

class User {
    String name;
    PrintWriter out;

    public User(String givenName, PrintWriter givenOut) {
        name = givenName;
        out = givenOut;
    }
}

public class Server {

    public static HashMap<String, User> loggedInUsers = new HashMap<>();

    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running...");
        var pool = Executors.newFixedThreadPool(500);
        try (var listener = new ServerSocket(59001)) {
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
                        System.out.print(choice.split(",")[0]);
                        System.out.print("yarab");
                        // get password
                        System.out.print(choice.split(",")[1]);

                        // call the database

                        // send the result
                        out.println("true");

                    } else if (choice.equals("login")) {
                        choice = in.nextLine();
                        // get username
                        System.out.print(choice.split(",")[0]);
                        System.out.print("yarab");
                        // get password
                        System.out.print(choice.split(",")[1]);

                        // call the database

                        // if true add to active
                        loggedInUsers.put(choice.split(",")[0], new User(choice.split(",")[0], out));

                        // send the result
                        out.println("true");

                        // else
                        // out.println("false");

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
