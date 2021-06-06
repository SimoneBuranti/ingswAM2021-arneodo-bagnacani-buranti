package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;

public class NotYourTurnErrorMessage extends Message{
    /**
     * message error of not your turn from server to client
     * due to all possible action turn
     */
    private final MessageType messageType = MessageType.NOTYOURTURNERROR;


    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public String toString(){
        return "wait for your turn to activate the action.";
    }
}
