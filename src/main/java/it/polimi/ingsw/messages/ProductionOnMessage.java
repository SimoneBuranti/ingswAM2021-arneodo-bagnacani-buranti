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

    private ArrayList<Resource> list;

    private int faithMove;

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


    public ArrayList<Resource> getList() {
        return list;
    }

    public void setList() {
        this.list=list;
    }

    public int getFaithMove() {
        return faithMove;
    }

    public void setFaithMove(int faithMove) {
        this.faithMove = faithMove;
    }
}
