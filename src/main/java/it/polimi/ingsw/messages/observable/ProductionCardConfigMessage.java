package it.polimi.ingsw.messages.observable;

import it.polimi.ingsw.messages.Message;
import it.polimi.ingsw.messages.MessageType;
import it.polimi.ingsw.messages.MessageVisitor;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;

import java.io.IOException;
import java.util.ArrayList;

public class ProductionCardConfigMessage extends Message {

    /**
     * message which contain the information
     * for configure light model table production at restart or simple start game
     * it includes the list of personal production card in right order bby key
     * it includes also the deck number
     * from server to client
     */
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
    public void accept(MessageVisitor v) throws IOException, InterruptedException {
        v.visit(this);
    }


    public int[][] getListOwnProductioncard() {
        return list;
    }
}
