package it.polimi.ingsw.messages;

import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
import java.util.ArrayList;

public class ProductionOnMessage extends Message {

    private int columnNumber;


    /**
     * type of message
     */
    private final MessageType messageType=MessageType.PRODUCTIONON;


    public ProductionOnMessage(int choosenColumn) {
        this.columnNumber = choosenColumn;
    }


    /**
     */@Override
    public MessageType getMessageType() {
        return messageType;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    @Override
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }
}
