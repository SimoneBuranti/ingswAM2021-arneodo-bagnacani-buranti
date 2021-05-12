package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.Resource;

import java.util.Map;

public class ReserveValueMessage extends Message {
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
    public void accept(MessageVisitor v) {
        v.visit(this);
    }
}
