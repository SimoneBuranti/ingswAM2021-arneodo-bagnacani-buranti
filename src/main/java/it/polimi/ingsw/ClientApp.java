package it.polimi.ingsw;

import it.polimi.ingsw.client.SocketClient;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.NumberPlayerMessage;
import java.io.IOException;

public class ClientApp {


    public static void main(String[] args) throws IOException {

        String hostName = "127.0.0.1";

        /*InetAddress hostAddress = InetAddress.getByName("95.248.220.116");*/

        int portNumber = 1234;

        SocketClient socketClient = new SocketClient(hostName, portNumber);

        //socketClient.readMessage();

        NumberPlayerMessage msg = new NumberPlayerMessage(3);

        socketClient.sendMessage(msg);
    }
}

