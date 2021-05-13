package it.polimi.ingsw;

import it.polimi.ingsw.Client.SocketClient;
import it.polimi.ingsw.messages.NumberPlayerMessage;
import it.polimi.ingsw.messages.UsernameMessage;

import java.io.IOException;

public class clientSEcond {
    public static void main(String[] args) throws IOException {

        String hostName = "127.0.0.1";

        /*InetAddress hostAddress = InetAddress.getByName("95.248.220.116");*/

        int portNumber = 1234;

        SocketClient socketClient = new SocketClient(hostName, portNumber);

        new Thread(){
            public void run(){
                socketClient.readMessage();
            }
        }.start();

        UsernameMessage msg1 = new UsernameMessage("bb");

        socketClient.sendMessage(msg1);

        //socketClient.readMessage();

        }
}
