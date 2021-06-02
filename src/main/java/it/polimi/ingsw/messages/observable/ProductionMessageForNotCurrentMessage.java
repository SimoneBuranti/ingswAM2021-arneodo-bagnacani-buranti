package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.client.commands.commandParsers.StandardParser;
import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.actionMarkers.ActionMarker;
import it.polimi.ingsw.server.model.players.Player;

import java.io.IOException;
import java.util.ArrayList;

public class ProductionMessageForNotCurrentMessage extends Message {

    private final MessageType messageType = MessageType.PRODUCTIONUPDATE;


    private ArrayList<Resource> resource;
    private String player;

    public ProductionMessageForNotCurrentMessage(String player, ArrayList<Resource> resource){

        this.player=player;
        this.resource = resource;

    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }

    public String getPlayer() {
        return player;
    }

    public ArrayList<Resource> getResource() {
        return resource;
    }

    @Override
    public String toString(){
        return player +" has activated a production";
    }
}
