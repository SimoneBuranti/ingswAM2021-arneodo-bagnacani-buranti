package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.players.Player;

import java.io.IOException;
import java.util.ArrayList;

public class ResultFromMarketNotCurrentMessage extends Message {
    /**
     * message which contain the information
     * for notify opponent light reserve about some resource differences
     * after market action
     * from server to client
     */
    private final MessageType messageType = MessageType.RESULTFROMARKETNOTCURRENT;


    private ArrayList<Resource> resource;
    private String player;


    public ResultFromMarketNotCurrentMessage(String player, ArrayList<Resource> resource){
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


    public String getPlayer() {
        return player;
    }

    @Override
    public String toString(){
        return player +" made a market action";
    }
}
