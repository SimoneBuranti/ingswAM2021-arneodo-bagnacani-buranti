package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;

public class UseActionMarkerMessage extends Message {private final MessageType messageType = MessageType.USEACTIONMARKER;

    ActionMarker actionMarker;
    public UseActionMarkerMessage(ActionMarker actionMarker)
    {
        this.actionMarker=actionMarker;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    public ActionMarker getActionMarker() {
        return actionMarker;
    }
}
