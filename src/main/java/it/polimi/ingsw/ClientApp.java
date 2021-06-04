package it.polimi.ingsw;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.frames.IPInitialFrame;

import java.io.IOException;

public class ClientApp {

    private static String hostName;
    private static int portNumber;

    public static void main(String[] args) throws IOException {
        hostName = "127.0.0.1";

        portNumber = 1236;


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
            //new IPInitialFrame();

            View gui = new Gui();
            SocketClient socketClient = new SocketClient(hostName, portNumber, gui);
            gui.startView();
            new Thread() {
                public void run() {
                    socketClient.readMessage();
                }
            }.start();
        //}
    }


    public static void setIPAddress(String ipAddress){
        hostName = ipAddress;
    }

    public static void setIPAddress(int portNumber){
        portNumber = portNumber;
    }
}

