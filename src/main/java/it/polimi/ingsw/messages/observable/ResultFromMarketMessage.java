package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.util.ArrayList;

public class ResultFromMarketMessage extends Message {
    /**
     * message which contain the information
     * for notify light strorage
     * after market action
     * from server to client
     */
    private final MessageType messageType = MessageType.RESULTFROMARKET;


    private ArrayList<Resource> resource;


    public ResultFromMarketMessage(ArrayList<Resource> resource){

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
