package it.polimi.ingsw;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientApp {


    public static void main(String[] args) throws IOException {

        String hostName = "127.0.0.1";
        int portNumber = 1234;
        String userInput;

        Scanner keyboard = new Scanner(System.in);
        Socket serverSocket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        try {

            while (!(userInput = keyboard.nextLine()).equals("quit")) {
                out.println(userInput);
                System.out.println(in.readLine());
            }
            out.println(userInput);
            System.out.println("Disconnected");
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }


}