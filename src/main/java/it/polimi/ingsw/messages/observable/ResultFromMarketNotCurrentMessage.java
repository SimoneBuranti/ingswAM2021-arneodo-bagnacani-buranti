package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.players.Player;

import java.io.IOException;
import java.util.ArrayList;

public class ResultFromMarketNotCurrentMessage extends Message {
    private final MessageType messageType = MessageType.RESULTFROMARKETNOTCURRENT;


    private ArrayList<Resource> resource;
    private Player player;


    public ResultFromMarketNotCurrentMessage(Player player, ArrayList<Resource> resource){
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


    public ArrayList<Resource> getResource() {
        return resource;
    }

    public Player getPlayer() {
        return player;
    }
}
