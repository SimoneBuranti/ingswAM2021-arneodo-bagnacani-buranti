package it.polimi.ingsw.server.virtualview;

import it.polimi.ingsw.observer.Observer;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.server.controller.ClientController;

import java.io.IOException;

public class VirtualView implements Observer {

    private ClientController clientController;


    /**
     * Default constructor.
     *  @param clientController
     *
     */
    public VirtualView(ClientController clientController) {
        this.clientController = clientController;
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    /**
    * Receives an update message from the model.
    * The message is sent over the network to the client.
    * The proper action based on the message type will be taken by the real view on the client.
    *
    * @param message the update message.
    */
    @Override
    public void update(Message message) throws IOException, InterruptedException {
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
    public void updateOnlyCurrent(Message message) throws IOException, InterruptedException {
        if (clientController.turnCheck())
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
    public void updateNotTheCurrent(Message message) throws IOException, InterruptedException {
        if (!clientController.turnCheck())
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
    public void updateOnlyObserverByNickname(Message message,String nickame) throws IOException, InterruptedException {
        if (clientController.getNickname().equals(nickame))
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
    public void updateAllObserverLessOneByNickname(Message message,String nickame) throws IOException, InterruptedException {
        if (clientController.getNickname().equals(nickame))
            clientController.getClientHandler().sendMessage(message);
    }










}

