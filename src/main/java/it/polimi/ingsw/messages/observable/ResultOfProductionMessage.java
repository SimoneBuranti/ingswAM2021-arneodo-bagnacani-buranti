package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.players.Player;

import java.io.IOException;
import java.util.ArrayList;

public class ResultOfProductionMessage extends Message {
    private final MessageType messageType = MessageType.PRODUCTIONRESULT;


    private ArrayList<Resource> resource;


    public ResultOfProductionMessage( ArrayList<Resource> resource){

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
}
