package it.polimi.ingsw;

import it.polimi.ingsw.Client.SocketClient;
import it.polimi.ingsw.messages.EndOfTurnMessage;
import it.polimi.ingsw.messages.UsernameMessage;

import java.io.IOException;

public class clientSEcond {
    public static void main(String[] args) throws IOException, InterruptedException {

        String hostName = "127.0.0.1";


        int portNumber = 1234;

        SocketClient socketClient = new SocketClient(hostName, portNumber, cli);

        new Thread(){
            public void run(){
                socketClient.readMessage();
            }
        }.start();

        UsernameMessage msg1 = new UsernameMessage("bb");

        socketClient.sendMessage(msg1);

        Thread.sleep(5000);


        EndOfTurnMessage msg2 = new EndOfTurnMessage();

        socketClient.sendMessage(msg2);

        Thread.sleep(5000);


        EndOfTurnMessage msg3 = new EndOfTurnMessage();

        socketClient.sendMessage(msg3);


    }
}
