package it.polimi.ingsw.server.virtualview;

import it.polimi.ingsw.Observer.Observer;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.controller.ClientController;
import it.polimi.ingsw.server.model.Game;
import it.polimi.ingsw.server.network.ClientHandler;

public class VirtualView implements Observer {
    private final ClientController clientController;
    private final Game game;

    /**
     * Default constructor.
     *
     * @param clientController
     * @param game
     */
    public VirtualView(ClientController clientController, Game game) {
        this.clientController = clientController;
        this.game=game;
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
    clientController.getClientHandler().sendMessage(message);
}





    /**
     * Receives an update message from the model.
     * The message is sent over the network to the client.
     * The proper action based on the message type will be taken by the real view on the client.
     *
     * @param message the update message.
     */
    @Override
    public void updateOnlyCurrent(Message message) {
        if (clientController.turnCheck())
        clientController.getClientHandler().sendMessage(message);
    }



}

