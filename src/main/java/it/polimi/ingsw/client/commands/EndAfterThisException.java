package it.polimi.ingsw.client.commands;

import it.polimi.ingsw.messages.Message;

/**
 *The EndAfterThisException is used whenever a command must end the action. In this case the exception stores the
 * message to be sent and when it is caught it will be sent an EndTurnMessage too.
 */
public class EndAfterThisException extends Exception{

    private Message extraMessage;

    public EndAfterThisException(Message extraMessage){
        this.extraMessage = extraMessage;
    }

    public Message getExtraMessage() {
        return extraMessage;
    }
}
