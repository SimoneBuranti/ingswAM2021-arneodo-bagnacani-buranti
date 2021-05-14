package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.util.ArrayList;

public class ProductionCardConfigMessage extends Message {

    private final MessageType messageType = MessageType.TABLEPRODUCTIONCARDCONFIG;


    private int[][] list;


    public ProductionCardConfigMessage(int[][] list ){

        this.list=list;

    }

    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.visit(this);
    }


    public int[][] getListOwnProductioncard() {
        return list;
    }
}
