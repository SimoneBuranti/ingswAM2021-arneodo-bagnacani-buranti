package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;
import it.polimi.ingsw.server.model.players.Player;

import java.util.ArrayList;

public class ProductionMessageForNotCurrentMessage extends Message {

    private final MessageType messageType = MessageType.PRODUCTIONUPDATE;


    private ArrayList<Resource> resource;
    private Player player;

    public ProductionMessageForNotCurrentMessage(Player player, ArrayList<Resource> resource){

        this.player=player;
        this.resource = resource;

    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }


    public ArrayList<Resource> getResource() {
        return resource;
    }
}
