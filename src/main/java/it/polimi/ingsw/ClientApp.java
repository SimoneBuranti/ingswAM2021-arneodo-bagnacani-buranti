package it.polimi.ingsw;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.client.view.gui.Gui;
import it.polimi.ingsw.client.view.gui.frames.IPInitialFrame;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ClientApp {

    public static final String defHostName = "127.0.0.1";
    public static final int defPortNumber = 12345;


    private static String hostName;
    private static int portNumber;

    public static void main(String[] args) throws IOException {
        hostName = null;
        portNumber = -1;


        if (false) {

            do {
                Scanner in = new Scanner(System.in);
                hostName = in.nextLine();
            } while (!IPInitialFrame.correctHostName(hostName));

            View cli = new Cli();
            SocketClient socketClient = new SocketClient(hostName, 12345, cli );
            cli.startView();
            new Thread() {
                public void run() {
                    socketClient.readMessage();
                }
            }.start(); }

        else {



            new IPInitialFrame();

            while(ClientApp.getIPAddress() == null || ClientApp.getPortNumber() == -1){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            View gui = new Gui();
            SocketClient socketClient = new SocketClient(hostName, portNumber, gui);
            gui.startView();

            new Thread() {
                public void run() {
                    socketClient.readMessage();
                }
            }.start();
        }
    }


    public static synchronized void setIPAddress(String ipAddress){
        ClientApp.hostName = ipAddress;
    }

    public static synchronized void setPortNumber(int portNumber){
        ClientApp.portNumber = portNumber;
    }

    public static synchronized String getIPAddress(){
        return ClientApp.hostName;
    }

    public static synchronized int getPortNumber(){
        return ClientApp.portNumber;
    }


}

