package it.polimi.ingsw;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.cli.Cli;

import java.io.IOException;

public class clientFourth {

        public static void main(String[] args) throws IOException, InterruptedException {

            String hostName = "127.0.0.1";


            int portNumber = 1236;

            View cli = new Cli();
            SocketClient socketClient = new SocketClient(hostName, portNumber, cli);
            cli.startView();
            new Thread() {
                public void run() {
                    socketClient.readMessage();
                }
            }.start();
        }
}
