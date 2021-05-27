package it.polimi.ingsw;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.gui.Gui;

import java.io.IOException;

public class ClientApp {


    public static void main(String[] args) throws IOException {
        String hostName = "127.0.0.1";

        int portNumber = 1235;

        boolean cliParam = false;

     /*   for (String arg : args) {
            if (arg.equals("--cli") || arg.equals("-c")) {
                cliParam = true;
                break;
            }
        }


        if (cliParam) {
            View cli = new Cli();
            SocketClient socketClient = new SocketClient(hostName, portNumber, cli );
            cli.startView();
            new Thread() {
                public void run() {
                    socketClient.readMessage();
                }
            }.start(); }*/

       // else {
            View gui = new Gui();
            SocketClient socketClient = new SocketClient(hostName, portNumber, gui);
            gui.startView();
            new Thread() {
                public void run() {
                    socketClient.readMessage();
                }
            }.start();
        }
   // }
}

