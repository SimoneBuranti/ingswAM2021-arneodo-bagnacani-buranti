package it.polimi.ingsw;

import com.google.gson.Gson;
import it.polimi.ingsw.server.network.SocketClient;
import it.polimi.ingsw.server.network.messages.Message;
import it.polimi.ingsw.server.network.messages.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {


    public static void main(String[] args) throws IOException {

        String hostName = "127.0.0.1";

        /*InetAddress hostAddress = InetAddress.getByName("95.248.220.116");*/

        int portNumber = 1234;

        SocketClient socketClient = new SocketClient(hostName, portNumber);

        socketClient.readMessage();
        String userInput;

        Scanner keyboard = new Scanner(System.in);
        Socket serverSocket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        try {

            while (!(userInput = keyboard.nextLine()).equals("quit")) {
                String line;
                Gson g = new Gson();
                line = in.readLine();
                Message msg = g.fromJson(line, Message.class);
                if(msg.getMessageType() == MessageType.PING) {
                    msg = new Message(MessageType.PONG);
                    out.write(g.toJson(msg));
                }
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
    }}

