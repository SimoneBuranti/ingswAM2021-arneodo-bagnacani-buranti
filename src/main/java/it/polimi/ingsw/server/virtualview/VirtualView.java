package it.polimi.ingsw.server.virtualview;

import it.polimi.ingsw.Observer.Observer;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.network.ClientHandler;

public class VirtualView implements Observer {
    private final ClientHandler clientHandler;

    /**
     * Default constructor.
     *
     * @param clientHandler the client handler the virtual view must send messages to.
     */
    public VirtualView(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }


    /**
 * Receives an update message from the model.
 * The message is sent over the network to the client.
 * The proper action based on the message type will be taken by the real view on the client.
 *
 * @param message the update message.
 */
@Override
public void update(Message message) {
    clientHandler.sendMessage(message);
}



}
