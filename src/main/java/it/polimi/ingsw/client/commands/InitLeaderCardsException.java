package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.messages.Message;

public class InitLeaderCardsException extends Exception{

    private Message message;

    public InitLeaderCardsException(Message message){
        this.message = message;
    }


    public Message getInitLeaderCardsMessage() {
        return message;
    }
}
