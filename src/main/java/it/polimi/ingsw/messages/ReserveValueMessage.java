package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;

import java.util.Map;

public class ReserveValueMessage extends Message{
    private final MessageType messageType = MessageType.RESERVEVALUE;
    private Map<Resource, Integer> reserve;

    public Map<Resource, Integer> getReserve() {
        return reserve;
    }

    public void setReserve(Map<Resource, Integer> reserve) {
        this.reserve = reserve;
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
