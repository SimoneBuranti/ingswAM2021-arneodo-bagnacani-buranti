package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;

import java.io.IOException;
import java.util.Map;

public class ReserveValueMessage extends Message {
    /**
     * message which contain the information
     * for notify opponent light reserve configuration after game restart
     * from server to client
     */
    private final MessageType messageType = MessageType.RESERVEVALUE;
    private Map<Resource, Integer> reserve;

    public ReserveValueMessage(Map<Resource,Integer> map) {
        this.reserve=map;

    }

    public Map <Resource, Integer> getReserve() {
        return reserve;
    }


    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
