package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;

import java.io.IOException;

public class UseActionMarkerMessage extends Message {
    /**
     * message which contain the information
     * for notify you about action marker application
     * from server to client
     */
    private final MessageType messageType = MessageType.USEACTIONMARKER;

    private String actionType;
    public UseActionMarkerMessage(String actionType)
    {
        this.actionType=actionType;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public String getActionType() {
        return actionType;
    }
}
