package it.polimi.ingsw.server.network;

import java.io.*;
import java.net.*;
import java.util.*;


public class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }


    public void run() {

        try {
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String line;

            while (true) {
                line = in.nextLine();

                if (line.equals("quit")) {
                    System.out.println("Client disconnected");
                    break;
                } else {
                    out.println("ClientHandler: " + line);
                    out.flush();
                }
            }

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }

}