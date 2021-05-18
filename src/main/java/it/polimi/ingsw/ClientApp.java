package it.polimi.ingsw;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.client.view.cli.Cli;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.messages.EndOfTurnMessage;
import it.polimi.ingsw.messages.NumberPlayerMessage;
import it.polimi.ingsw.messages.UsernameMessage;

import java.io.IOException;

public class ClientApp {


    public static void main(String[] args) throws IOException, InterruptedException {

        String hostName = "127.0.0.1";

        /*InetAddress hostAddress = InetAddress.getByName("95.248.220.116");*/

        int portNumber = 1234;

        View cli = new Cli();
        SocketClient socketClient = new SocketClient(hostName, portNumber, cli );

        new Thread(){
            public void run(){
                socketClient.readMessage();
            }
        }.start();

        UsernameMessage msg1 = new UsernameMessage("aa");

        socketClient.sendMessage(msg1);

        NumberPlayerMessage msg = new NumberPlayerMessage(2);

        socketClient.sendMessage(msg);


        Thread.sleep(5000);


        EndOfTurnMessage msg2 = new EndOfTurnMessage();

        socketClient.sendMessage(msg2);


    }
}

