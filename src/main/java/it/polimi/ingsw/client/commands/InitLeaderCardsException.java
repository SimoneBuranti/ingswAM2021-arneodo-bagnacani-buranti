package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.messages.Message;

/**
 * This exception is thrown after the initial leader card choice as a different behaviour of the commandOn is required.
 */
public class InitLeaderCardsException extends Exception{

    /**
     * Message attribute.
     */
    private Message message;

    /**
     * Class constructor.
     * @param message
     */
    public InitLeaderCardsException(Message message){
        this.message = message;
    }


    /**
     * Message getter.
     * @return
     */
    public Message getInitLeaderCardsMessage() {
        return message;
    }
}
