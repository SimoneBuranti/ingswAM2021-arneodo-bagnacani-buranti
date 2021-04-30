package it.polimi.ingsw.server.network.messages;

import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;

public class LorenzoActionMessage extends Message{
    private final MessageType messageType = MessageType.LORENZOSACTION;
    private ActionMarker actionMarker;

    public ActionMarker getActionMarker() {
        return actionMarker;
    }

    public void setActionMarker(ActionMarker actionMarker) {
        this.actionMarker = actionMarker;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }
}
