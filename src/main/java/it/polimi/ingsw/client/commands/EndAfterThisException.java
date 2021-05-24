package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.messages.Message;

public class EndAfterThisException extends Exception{

    private Message extraMessage;

    public EndAfterThisException(Message extraMessage){
        this.extraMessage = extraMessage;
    }

    public Message getExtraMessage() {
        return extraMessage;
    }
}
