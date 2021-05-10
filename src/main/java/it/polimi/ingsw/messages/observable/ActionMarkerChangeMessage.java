package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;

import java.util.ArrayList;

public class ActionMarkerChangeMessage extends Message {
    private final MessageType messageType = MessageType.ACTIONMARKERCHANGE;


    private ArrayList<ActionMarker> deck;


    public ActionMarkerChangeMessage(ArrayList<ActionMarker> list ){
        this.deck=new ArrayList();
        this.deck=list;
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }

    public ArrayList<ActionMarker> getDeck() {
        return deck;
    }
}
